package csp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class T36_3 {


    static class cacheBlock {
        int bid;
        boolean isDirty;

        cacheBlock() {
            this.bid = -1;
            this.isDirty = false;
        }

        cacheBlock(int bid, boolean isDirty) {
            this.bid = bid;
            this.isDirty = isDirty;
        }
    }


    static class cacheGroup {
        LinkedHashMap<Integer,cacheBlock> lhm;
        int num;

        cacheGroup() {
            lhm = new LinkedHashMap<>(10000,1,true);
            num = 0;
        }

    }


    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out, false);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String[] strArr = br.readLine().split("\\s+");
        int n = Integer.parseInt(strArr[0]), N = Integer.parseInt(strArr[1]), q = Integer.parseInt(strArr[2]);
        int logn = -1, logN = -1, tmpn = n;
        while (tmpn != 0) {
            tmpn >>>= 1;
            logn++;
        }
//        while (N != 0) {
//            N >>>= 1;
//            logN++;
//        }

        // x / n % N;

        int o, a;

        cacheGroup[] cgArr = new cacheGroup[N];
        for (int i = 0; i < N; i++) {
            cgArr[i] = new cacheGroup();
        }

        int tofindGroup = 0, tofindBlock = 0, op;
        cacheGroup tmpcg;
        cacheBlock tmpcb;
        for (int i = 0; i < q; i++) {
            strArr = br.readLine().split("\\s+", 2);
            tofindBlock = Integer.parseInt(strArr[1]);
            op = Integer.parseInt(strArr[0]);

            tofindGroup = (tofindBlock >>> logn) % N;
            tmpcg = cgArr[tofindGroup];
            if (tmpcg.lhm.containsKey(tofindBlock)) {
                tmpcb = tmpcg.lhm.get(tofindBlock);
            } else {
                if (tmpcg.num == n) {
                    tmpcb = tmpcg.lhm.pollFirstEntry().getValue();
                    if (tmpcb.isDirty) {
                        pw.printf("%d %d\n", 1, tmpcb.bid);
                    }
                    pw.printf("%d %d\n", 0, tofindBlock);
                    tmpcb = new cacheBlock(tofindBlock, false);
                    tmpcg.lhm.put(tofindBlock,tmpcb);
                } else {
                    pw.printf("%d %d\n", 0, tofindBlock);
                    tmpcb = new cacheBlock(tofindBlock, false);
                    tmpcg.lhm.put(tofindBlock, tmpcb);
                    tmpcg.num++;
                }

            }


            if (op == 1) {
                tmpcb.isDirty = true;
            }
        }


        br.close();
        pw.flush();
        pw.close();
    }
}
