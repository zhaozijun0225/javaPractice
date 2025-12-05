package csp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class T36_3 {

    static int ENVIRONMENT_TIME = 0;

    static class block {
        int id;

        block(int id) {
            this.id = id;
        }
    }

    static class cacheBlock {
        block b;
        boolean isDirty;
        int putTime;

        cacheBlock() {
            this.b = null;
            this.isDirty = false;
            this.putTime = ENVIRONMENT_TIME;
        }

        cacheBlock(block b, boolean isDirty) {
            this.b = b;
            this.isDirty = isDirty;
            this.putTime = ENVIRONMENT_TIME;
        }
    }


    static class cacheGroup {
        Deque<cacheBlock> dq;
        HashMap<Integer, cacheBlock> hm;
        int num;
        cacheGroup(){
            dq = new LinkedList<>();
            hm = new HashMap<Integer,cacheBlock>();
            num = 0;
        }

    }


    public static void main(String[] args) throws IOException {
        ENVIRONMENT_TIME = 0;
        PrintWriter pw = new PrintWriter(System.out, false);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String[] strArr = br.readLine().split("\\s+");
        int n = Integer.parseInt(strArr[0]), N = Integer.parseInt(strArr[1]), q = Integer.parseInt(strArr[2]);
        int logn = -1, logN = -1;
        while (n != 0) {
            n >>>= 1;
            logn++;
        }
        while (N != 0) {
            N >>>= 1;
            logN++;
        }

        // x / n % N;

        int o, a;


        br.close();
        pw.flush();
        pw.close();
    }
}
