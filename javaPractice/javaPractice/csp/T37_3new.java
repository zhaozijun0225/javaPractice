package csp;
import java.io.*;
import java.util.*;

class T37_3new {
    static final long MOD = 1000000007;  // 取模常量

    // 变量定义类：表示一个变量是静态还是动态、其静态长度、表达式操作数列表、
    // 依赖的父变量集合、依赖它的子变量列表，以及缓存值和脏标志。
    static class VarDef {
        boolean isDynamic;               // 是否为动态赋值变量
        long staticLength;               // 静态赋值时的长度值（直接赋值）
        List<Operand> exprOperands;      // 动态赋值时保存的操作数列表
        Set<VarDef> dependencies;        // 该变量依赖的父变量（动态时用）
        List<VarDef> children;           // 依赖于该变量的动态子变量列表
        long cachedLength;              // 缓存的当前计算长度（mod后）
        boolean dirty;                  // 动态变量是否需要重新计算

        VarDef() {
            isDynamic = false;
            staticLength = 0;
            exprOperands = null;
            dependencies = new HashSet<>();
            children = new ArrayList<>();
            cachedLength = 0;
            dirty = false;
        }
    }

    // 表达式操作数：要么是变量引用，要么是文字串
    static class Operand {
        boolean isVar;      // true 表示是变量引用
        String value;       // 如果 isVar，则为变量名；否则为文字串内容
        Operand(boolean isVar, String value) {
            this.isVar = isVar;
            this.value = value;
        }
    }

    // 全局变量映射：变量名 -> VarDef
    static Map<String, VarDef> varMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        // 逐行处理每个语句
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) { i--; continue; }
            String[] parts = line.split(" ", 3);
            String type = parts[0];

            if (type.equals("1")) {
                // 直接赋值：格式 "1 var expr"
                String varName = parts[1];
                String expr = parts[2];
                handleDirectAssignment(varName, expr);
            } else if (type.equals("2")) {
                // 间接赋值：格式 "2 var expr"
                String varName = parts[1];
                String expr = parts[2];
                handleIndirectAssignment(varName, expr);
            } else if (type.equals("3")) {
                // 输出查询：格式 "3 var"
                String varName = parts[1];
                long result = getLength(varName);
                System.out.println(result % MOD);
            }
        }
    }

    // 处理类型1：直接赋值。立即解析表达式并更新静态长度。
    static void handleDirectAssignment(String varName, String expr) {
        VarDef var = varMap.get(varName);
        if (var == null) {
            var = new VarDef();
            varMap.put(varName, var);
        }
        // 计算新值的长度（累加各操作数长度）
        String[] tokens = expr.split(" ");
        long newLength = 0;
        for (String token : tokens) {
            if (token.isEmpty()) continue;
            if (token.charAt(0) == '$') {
                // 变量引用，递归获取当前长度
                String depName = token.substring(1);
                long len = getLength(depName);
                newLength = (newLength + len) % MOD;
            } else {
                // 文字串操作数，直接取长度
                newLength = (newLength + token.length()) % MOD;
            }
        }
        // 如果原来是动态定义，需要先清除旧依赖
        if (var.isDynamic) {
            for (VarDef parent : var.dependencies) {
                parent.children.remove(var);
            }
            var.dependencies.clear();
            var.exprOperands = null;
            var.isDynamic = false;
        }
        // 更新为静态赋值的新长度
        var.staticLength = newLength;
        var.isDynamic = false;
        // 标记并传播依赖：通知所有动态子变量重新计算
        propagateDirty(var);
    }

    // 处理类型2：间接赋值。保存表达式结构，更新依赖关系。
    static void handleIndirectAssignment(String varName, String expr) {
        VarDef var = varMap.get(varName);
        if (var == null) {
            var = new VarDef();
            varMap.put(varName, var);
        }
        // 清除旧依赖（如果有的话）
        if (var.isDynamic) {
            for (VarDef parent : var.dependencies) {
                parent.children.remove(var);
            }
        }
        var.dependencies.clear();

        // 解析表达式操作数
        String[] tokens = expr.split(" ");
        List<Operand> operandList = new ArrayList<>();
        Set<VarDef> newDeps = new HashSet<>();
        for (String token : tokens) {
            if (token.isEmpty()) continue;
            if (token.charAt(0) == '$') {
                // 变量引用操作数
                String depName = token.substring(1);
                VarDef parent = varMap.get(depName);
                if (parent == null) {
                    parent = new VarDef();
                    varMap.put(depName, parent);
                }
                operandList.add(new Operand(true, depName));
                newDeps.add(parent);
            } else {
                // 文字串操作数
                operandList.add(new Operand(false, token));
            }
        }
        // 更新变量为动态定义，保存操作数列表
        var.isDynamic = true;
        var.exprOperands = operandList;
        var.dependencies = newDeps;
        // 将自己加入每个父变量的子列表
        for (VarDef parent : newDeps) {
            parent.children.add(var);
        }
        // 标记为脏，并通知后代
        var.dirty = true;
        propagateDirty(var);
    }

    // 递归获取变量的当前值长度（取模），使用缓存优化
    static long getLength(String varName) {
        VarDef var = varMap.get(varName);
        if (var == null) {
            // 未赋值变量视为空字符串
            return 0;
        }
        if (!var.isDynamic) {
            // 静态变量，直接返回存储的长度
            return var.staticLength % MOD;
        }
        // 对动态变量，如果不脏则直接返回缓存值
        if (!var.dirty) {
            return var.cachedLength;
        }
        // 重新计算长度
        long sum = 0;
        if (var.exprOperands != null) {
            for (Operand op : var.exprOperands) {
                if (op.isVar) {
                    // 变量引用
                    long len = getLength(op.value);
                    sum = (sum + len) % MOD;
                } else {
                    // 文字串操作数
                    sum = (sum + op.value.length()) % MOD;
                }
            }
        }
        // 缓存结果并清除脏标志
        var.cachedLength = sum;
        var.dirty = false;
        return sum;
    }

    // 广度优先遍历，将 var 以及其所有动态后代标记为脏
    static void propagateDirty(VarDef var) {
        Queue<VarDef> queue = new LinkedList<>();
        Set<VarDef> visited = new HashSet<>();
        visited.add(var);
        queue.offer(var);
        while (!queue.isEmpty()) {
            VarDef current = queue.poll();
            for (VarDef child : current.children) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    child.dirty = true;
                    queue.offer(child);
                }
            }
        }
    }
}
