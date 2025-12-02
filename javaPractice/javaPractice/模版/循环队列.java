package 模版;

// 必须要有一个空位置，用来区分:空、满、一个点
public class 循环队列 {
    static int target = 100;  //假设逻辑上限制容量为100

    static class loopQ {
        int tol;
        int[] arr;
        int l, r;

        loopQ(int target) {
            tol = target + 1; //一定要注意多开一个
            arr = new int[tol];
            l = 0;
            r = 0;
        }

        void offer(int num) {
            if ((r + 1) % tol == l) {
                //可修改为其他代码
                System.out.printf("队列已满，添加失败");
                throw new RuntimeException();
            }

            arr[r] = num;
            r = (r + 1) % tol; //手撕的时候可能没有tol这个变量，记得看清楚长度，加一

        }

        int poll() {
            if (r == l) {
                System.out.printf("队列为空，没有东西");
                throw new RuntimeException();
            }
            int ans = arr[l];
            l = (l + 1) % tol;
            return ans;
        }

    }

}
