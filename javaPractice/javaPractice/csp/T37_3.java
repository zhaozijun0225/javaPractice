package csp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

//2025.12.04 重练，失败，这个版本不行  原因：模板的变量不一定只有一个！不能用set。所以说用set前要想清楚是不是只有一个
class T37_3 {


    static long M = 1000000007L;

    static class cell {
        boolean isDynamic;
        long ans;
        String name;

        Map<String, Long> dynamicParam;
        long staticAns;
        boolean isDirty;

        cell(boolean isDynamic, boolean isDirty, String name) {
            this.isDynamic = isDynamic;
            this.isDirty = isDirty;
            this.ans = 0;
            this.dynamicParam = null;
            this.staticAns = 0;
            this.name = name;
        }
    }

    static cell nullCell = new cell(false, false, "nullCell");


    static Map<String, cell> params = new HashMap<String, cell>(1000, 1);
    static Map<String, HashSet<cell>> dirtyCall = new HashMap<String, HashSet<cell>>();
    //要传播脏值
    //变量赋值时，如果之前存在，要通知脏值传播取消之前的记录


    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out, false);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split("\\s+");
        int n = Integer.parseInt(strArr[0]);
        cell tmpcell1;
        HashSet tmpHashSet;
        for (int i = 0; i < n; i++) {
            strArr = br.readLine().split("\\s+", 3);

            if (strArr[0].equals("1")) {
                tmpcell1 = params.getOrDefault(strArr[1], new cell(false, false, strArr[1]));
                if (tmpcell1.isDynamic) {
                    //已经有了，要通知脏扩散消除这个cell
                    for (String c : tmpcell1.dynamicParam.keySet()) {
                            dirtyCall.get(c).remove(tmpcell1);
                    }
                }
                tmpcell1.isDynamic = false;
                initLength(tmpcell1, strArr[2]);
                params.put(strArr[1], tmpcell1);
                spreadDirty(strArr[1]);

            } else if (strArr[0].equals("2")) {
                tmpcell1 = params.getOrDefault(strArr[1], new cell(false, false, strArr[1]));
                if (tmpcell1.isDynamic) {
                    //已经有了，要通知脏扩散消除这个cell
                    for (String c : tmpcell1.dynamicParam.keySet()) {
                            dirtyCall.get(c).remove(tmpcell1);
                    }
                }

                tmpcell1.isDynamic = true;

                initLength(tmpcell1, strArr[2]);
                params.put(strArr[1], tmpcell1);
                spreadDirty(strArr[1]);

            } else {
                tmpcell1 = params.getOrDefault(strArr[1], nullCell);
                if (tmpcell1.isDynamic && tmpcell1.isDirty) {
                    pw.printf("%d\n", calParam(strArr[1]));
                } else {
                    pw.printf("%d\n", tmpcell1.ans);
                }

            }
        }

        pw.flush();
        br.close();
        pw.close();
        return;
    }


    //要设置dirty为false
//    计算ans,更新dynamicParam，isDirty
    static void initLength(cell c, String s) {
        long ans = 0L, staticAns = 0L;
        HashSet<cell> tmpHashSet;
        if (c.isDynamic) {
            long tmpInt1;
            String tmpStr1;
            c.dynamicParam = new HashMap<>();
            for (String str : s.split("\\s+")) {
                if (str.charAt(0) == '$') {
                    tmpStr1 = str.substring(1);
                    tmpInt1 = calParam(tmpStr1);
                    c.dynamicParam.put(tmpStr1, tmpInt1);
                    ans = (ans + tmpInt1) % M;
                    tmpHashSet = dirtyCall.getOrDefault(tmpStr1, null);

                    if (tmpHashSet == null) {
                        tmpHashSet = new HashSet<cell>();
                        dirtyCall.put(tmpStr1, tmpHashSet);
                        tmpHashSet.add(c);
                    }else{
                        tmpHashSet.add(c);
                    }


                } else {
                    staticAns = (staticAns + str.length()) % M;
                }
            }
            c.staticAns = staticAns;
            c.ans = (staticAns + ans) % M;
            c.isDirty = false;

        } else {
            for (String st : s.split("\\s+")) {
                if (st.charAt(0) == '$')
                    ans = (ans + (long) calParam(st.substring(1))) % M;
                else
                    ans = (ans + st.length()) % M;

            }
            c.ans = ans;
        }
        return;
    }

    static long calParam(String s) {
        cell tmpCell1 = params.getOrDefault(s,nullCell);

        if (tmpCell1.isDynamic && tmpCell1.isDirty) {
            long ans = tmpCell1.staticAns;
            long tmpInt1;
            for (Map.Entry<String, Long> e : tmpCell1.dynamicParam.entrySet()) {
                if (e.getValue() != -1) {
                    ans = (ans + e.getValue()) % M;
                } else {
                    tmpInt1 = calParam(e.getKey());
                    tmpCell1.dynamicParam.put(e.getKey(), tmpInt1);
                    ans = (ans + tmpInt1) % M;

                }
            }
            tmpCell1.ans = ans;
            tmpCell1.isDirty = false;
        }

        return tmpCell1.ans;
    }

    static void spreadDirty(String s) {
        HashSet<cell> hs = dirtyCall.getOrDefault(s,null);
        if(hs==null)
            return;

        Deque<cell> dq = new ArrayDeque<cell>(100);
        Deque<String> dqname = new ArrayDeque<String>(100);

        for (cell c : hs) {
            dq.offer(c);
            dqname.offer(s);
        }
        cell tmpCell;
        String tmpStr1;
        while (!dq.isEmpty()) {
            tmpCell = dq.poll();
            tmpStr1 = dqname.poll();
            tmpCell.isDirty = true;
            tmpCell.dynamicParam.put(tmpStr1,-1L);
            hs = dirtyCall.getOrDefault(tmpCell.name,null);
            if(hs == null)
                continue;
            for (cell c : hs) {
                dq.offer(c);
                dqname.offer(tmpCell.name);
            }

        }
        return;

    }


}
