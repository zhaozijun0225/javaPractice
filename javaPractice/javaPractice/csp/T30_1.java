package csp;

import java.io.*;
import java.util.*;


class T30_1 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        String s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {

            sb.setLength(0);
            for (int j = 0; j < 8; j++) {
                st = new StringTokenizer(br.readLine());
                sb.append(st.nextToken());
            }
            s = sb.toString();
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }

            System.out.println(map.get(s));


        }


    }

}
