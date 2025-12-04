package csp;

import java.io.*;
import java.math.BigInteger;
import java.util.*;


class T38_3 {

    static Map<Long, String> Hash2Name25;
    static Map<Long, String> Hash2Name12;


    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(new BufferedInputStream(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
//        int n = Integer.parseInt(in.nextLine());
        Hash2Name25 = new HashMap<Long, String>(15000, 1);
        Hash2Name12 = new HashMap<Long, String>(15000, 1);
        String inputStr = null, code1, code2, code3;
        String sender, receiver, local;
        int tmpInt1;
        String tmpStr1;
        Long hash12, hash25;
        long tmplong1;
        int codeint1, codeint2;
        // IO优化：使用PrintWriter减少IO开销
        PrintWriter pw = new PrintWriter(System.out);
        
        for (int i = 0; i < n; i++) {
            inputStr = br.readLine();

            if (inputStr.charAt(0) == '0') {
                //简单消息
                code1 = inputStr.substring(1, 29);
                code2 = inputStr.substring(29, 57);
                code3 = inputStr.substring(57, 72);
                codeint1 = Integer.parseInt(code1, 2);
                codeint2 = Integer.parseInt(code2, 2);
                receiver = parse28(codeint1);
                sender = parse28(codeint2);
                tmpInt1 = Integer.parseInt(code3, 2);
                if (tmpInt1 != 0)
                    local = String.valueOf(tmpInt1);
                else
                    local = null;
                //得在取完后放map
                if (codeint1 >= (1L << 25)) {
                    tmplong1 = parseName2FullCode(receiver);
                    hash12 = parseCode2Hash(tmplong1, 12);
                    hash25 = parseCode2Hash(tmplong1, 25);
                    Hash2Name12.put(hash12, receiver);
                    Hash2Name25.put(hash25, receiver);
                }
                if (codeint2 >= (1L << 25)) {
                    tmplong1 = parseName2FullCode(sender);
                    hash12 = parseCode2Hash(tmplong1, 12);
                    hash25 = parseCode2Hash(tmplong1, 25);
                    Hash2Name12.put(hash12, sender);
                    Hash2Name25.put(hash25, sender);
                }
            } else {
                //复杂消息
                code1 = inputStr.substring(1, 59);
                code2 = inputStr.substring(59, 71);
                code3 = inputStr.substring(71, 72);

                local = null;
                if (code3.equals("0")) {
                    sender = parse58(code1);
                    receiver = parse12(code2);
                    tmpStr1 = sender;
                } else {
                    receiver = parse58(code1);
                    sender = parse12(code2);
                    tmpStr1 = receiver;
                }
                tmplong1 = Long.parseLong(code1, 2);
                hash12 = parseCode2Hash(tmplong1, 12);
                hash25 = parseCode2Hash(tmplong1, 25);
                Hash2Name12.put(hash12, tmpStr1);
                Hash2Name25.put(hash25, tmpStr1);


            }
            if (local == null)
                pw.printf("%s %s\n", receiver, sender);
            else
                pw.printf("%s %s %s\n", receiver, sender, local);

        }
        pw.flush(); // 最后flush确保输出
        br.close();
        pw.close();
    }

    static StringBuilder sb = new StringBuilder();
    private static final int THRESHOLD_25 = 1 << 25; // 2^25，提取常量
    static String parse28(int s) {
        String ans = null;
        String hash12, hash25;
        sb.setLength(0);

        if (s >= (1L << 25)) {
//            ans = parseEasy2Name(s.substring(3));
            int tmplong1 = s - THRESHOLD_25, tmplong2;

            // idx5
            sb.append((char) ('A' + tmplong1 % 26));
            tmplong1 = tmplong1 / 26;

            // idx4
            sb.append((char) ('A' + tmplong1 % 26));
            tmplong1 = tmplong1 / 26;

            // idx3
            sb.append((char) ('A' + tmplong1 % 26));
            tmplong1 = tmplong1 / 26;

            // idx2
            sb.append((char) ('0' + tmplong1 % 10));
            tmplong1 = tmplong1 / 10;

            // idx1
            tmplong2 = tmplong1 % 36;
            tmplong1 = tmplong1 / 36;
            if (tmplong2 < 10) {
                sb.append((char) ('0' + tmplong2));
            } else {
                sb.append((char) ('A' + tmplong2 - 10));
            }

            // idx0
            if (tmplong1 <= 10 && tmplong1 > 0) {
                sb.append((char) ('0' + tmplong1 - 1));
            } else if (tmplong1 > 0) {
                sb.append((char) ('A' + tmplong1 - 11));
            }

            ans = sb.reverse().toString();

        } else {
            ans = "#".concat(Hash2Name25.getOrDefault(Long.valueOf(s), "##"));
        }

        return ans;
    }

    static String parse12(String s) {
        String ans = "#".concat(Hash2Name12.getOrDefault(Long.parseLong(s, 2), "##"));

        return ans;
    }


    static String parse58(String s) {
        sb.setLength(0);
        long tmplong1 = Long.parseLong(s, 2), tmplong2;

        //要注意他是从结尾补的空格
        while (tmplong1 != 0) {
            tmplong2 = tmplong1 % 38;
            if (tmplong2 != 0 && tmplong2 <= 10) {
                sb.append((char) (tmplong2 + '0' - 1));
            } else if (tmplong2 != 0 && tmplong2 <= 36) {
                sb.append((char) (tmplong2 + 'A' - 11));
            } else if(tmplong2 != 0) {
                sb.append('_');
            }

            tmplong1 /= 38;
        }
        String ans = sb.reverse().toString();
        return ans;

    }

    static Long parseCode2Hash(long s, int hashL) {
        s  = (s*47055833459L)>>>(64-hashL);

        return s;
    }

    private static final long[] POWER38 = {
            6278211847988224L, // 38^10
            165216101262848L,  // 38^9
            4347792138496L,    // 38^8
            114415582592L,     // 38^7
            3010936384L,       // 38^6
            79235168L,         // 38^5
            2085136L,          // 38^4
            54872L,            // 38^3
            1444L,             // 38^2
            38L,               // 38^1
            1L                 // 38^0
    };

    static long parseName2FullCode(String s) {
        long tmpBI = 0;
        int tmpChar;

        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == ' ') {
                tmpChar = 0;
            } else if (charArr[i] - '0' >= 0 && charArr[i] - '9' <= 0) {
                tmpChar = 1 + charArr[i] - '0';
            } else if (charArr[i] - 'A' >= 0 && charArr[i] - 'Z' <= 0) {
                tmpChar = 11 + charArr[i] - 'A';
            } else {
                tmpChar = 37;
            }
            tmpBI += POWER38[i] * tmpChar;
        }
        return tmpBI;

    }


}
