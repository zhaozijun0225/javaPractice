package 模版;

import java.util.Arrays;

public class UnionFindSet {
    // 并查集的底层为一个数组
    private int[] element;

    // 构造函数，初始化并查集
    public UnionFindSet(int initial) {
        element = new int[initial];
        Arrays.fill(element, -1); // 初始化数组，表示每个元素自成一个集合
    }

    // 查找两个元素是否在同一个集合内
    public boolean isSameSet(int val1, int val2) {
        return findRoot(val1) == findRoot(val2); // 比较两个元素的根节点
    }

    // 查找元素的根节点
    // 路径压缩 - 查找根节点 - 使每个节点的值直接为根节点
    public int findRoot(int val) {
        // 检查索引是否越界
        if (val < 0 || val >= element.length) {
            throw new ArrayIndexOutOfBoundsException("索引越界!!!");
        }
        // 如果当前元素是根节点，直接返回
        if (element[val] < 0) {
            return val;
        } else {
            // 递归查找根节点，并在此过程中进行路径压缩
            element[val] = findRoot(element[val]); // 将当前节点的父节点直接指向根节点
            return element[val]; // 返回根节点
        }
    }

    // 合并两个集合
    // 按秩合并 - 合并两个集合，将树高度低的接在树高度高的上
    public void unionSet2(int val1, int val2) {
        // 找到val1和val2的根节点
        int index1 = findRoot(val1);
        int index2 = findRoot(val2);

        // 如果两个元素的根节点不同，进行合并
        if (index1 != index2) {
            // 判断树的高度（通过数组中的值判断）进行合并
            if (element[index1] < element[index2]) {
                // 将index1的集合合并到index2的集合上
                element[index1] += element[index2]; // 更新index1集合的大小
                element[index2] = index1; // 将index2的根指向index1
            } else {
                // 将index2的集合合并到index1的集合上
                element[index2] += element[index1]; // 更新index2集合的大小
                element[index1] = index2; // 将index1的根指向index2
            }
        }
    }

    // 返回当前集合的个数
    public int SetNumber() {
        int count = 0; // 计数器
        for (int i = 0; i < element.length; i++) {
            if (element[i] < 0) {
                count++; // 每找到一个根节点，计数器加一
            }
        }
        return count; // 返回集合的个数
    }
}