package csp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class T38_3byDouBao {
    static Map<Long, String> Hash2Name25;
    static Map<Long, String> Hash2Name12;

    // 常量定义：提取魔法数，提升可读性和类型安全
    private static final long THRESHOLD_25 = 1L << 25; // 2^25
    private static final long IDX0_DENOM = 36L * 10L * 26L * 26L * 26L;
    private static final long IDX1_DENOM = 10L * 26L * 26L * 26L;
    private static final long IDX2_DENOM = 26L * 26L * 26L;
    private static final long IDX3_DENOM = 26L * 26L;
    private static final long IDX4_DENOM = 26L;
    private static final long HASH_MULTIPLIER = 47055833459L;
    private static final int BASE_38 = 38;
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        // Map初始化：根据n设置初始容量，避免扩容
        Hash2Name25 = new HashMap<>(n * 2);
        Hash2Name12 = new HashMap<>(n * 2);

        // IO优化：使用PrintWriter减少IO开销
        PrintWriter pw = new PrintWriter(System.out);

        String inputStr, code1, code2, code3;
        String sender, receiver, local;
        long tmplong1;
        int codeint1, codeint2;
        long hash12, hash25;

        for (int i = 0; i < n; i++) {
            inputStr = br.readLine();

            if (inputStr.startsWith("0")) { // 简单消息：更可读的判断
                code1 = inputStr.substring(1, 29);
                code2 = inputStr.substring(29, 57);
                code3 = inputStr.substring(57, 72);

                codeint1 = Integer.parseInt(code1, 2);
                codeint2 = Integer.parseInt(code2, 2);
                receiver = parse28(codeint1);
                sender = parse28(codeint2);

                // 局部变量语义化：localCode代替tmpInt1
                int localCode = Integer.parseInt(code3, 2);
                local = localCode != 0 ? String.valueOf(localCode) : null;

                // 存入Map的逻辑
                if (codeint1 >= THRESHOLD_25) {
                    tmplong1 = parseName2FullCode(receiver);
                    hash12 = parseCode2Hash(tmplong1, 12);
                    hash25 = parseCode2Hash(tmplong1, 25);
                    Hash2Name12.put(hash12, receiver);
                    Hash2Name25.put(hash25, receiver);
                }
                if (codeint2 >= THRESHOLD_25) {
                    tmplong1 = parseName2FullCode(sender);
                    hash12 = parseCode2Hash(tmplong1, 12);
                    hash25 = parseCode2Hash(tmplong1, 25);
                    Hash2Name12.put(hash12, sender);
                    Hash2Name25.put(hash25, sender);
                }
            } else { // 复杂消息
                code1 = inputStr.substring(1, 59);
                code2 = inputStr.substring(59, 71);
                code3 = inputStr.substring(71, 72);

                local = null;
                String tmpStr1;
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

            // 输出优化：用PrintWriter
            if (local == null) {
                pw.printf("%s %s%n", receiver, sender);
            } else {
                pw.printf("%s %s %s%n", receiver, sender, local);
            }
        }

        pw.flush(); // 最后flush确保输出
        br.close();
        pw.close();
    }

    private static String parse28(int s) {
        StringBuilder sb = new StringBuilder(); // 局部StringBuilder，线程安全

        if (s >= THRESHOLD_25) {
            long tmplong1 = s - THRESHOLD_25;

            // 计算各索引
            long idx0 = tmplong1 / IDX0_DENOM;
            tmplong1 %= IDX0_DENOM;
            if (idx0 > 0) {
                if (idx0 <= 10) {
                    sb.append((char) ('0' + idx0 - 1));
                } else {
                    sb.append((char) ('A' + idx0 - 11));
                }
            }

            long idx1 = tmplong1 / IDX1_DENOM;
            tmplong1 %= IDX1_DENOM;
            sb.append(idx1 < 10 ? (char) ('0' + idx1) : (char) ('A' + idx1 - 10));

            long idx2 = tmplong1 / IDX2_DENOM;
            tmplong1 %= IDX2_DENOM;
            sb.append((char) ('0' + idx2));

            long idx3 = tmplong1 / IDX3_DENOM;
            tmplong1 %= IDX3_DENOM;
            sb.append((char) ('A' + idx3));

            long idx4 = tmplong1 / IDX4_DENOM;
            tmplong1 %= IDX4_DENOM;
            sb.append((char) ('A' + idx4));

            sb.append((char) ('A' + tmplong1));
            return sb.toString();
        } else {
            return "#".concat(Hash2Name25.getOrDefault((long) s, "##")); // 避免不必要的装箱
        }
    }

    private static String parse12(String s) {
        long code = Long.parseLong(s, 2);
        return "#".concat(Hash2Name12.getOrDefault(code, "##"));
    }

    private static String parse58(String s) {
        StringBuilder sb = new StringBuilder(); // 局部StringBuilder
        long tmplong1 = Long.parseLong(s, 2);

        while (tmplong1 != 0) {
            long tmplong2 = tmplong1 % BASE_38;
            if (tmplong2 != 0) {
                if (tmplong2 <= 10) {
                    sb.append((char) ('0' + tmplong2 - 1));
                } else if (tmplong2 <= 36) {
                    sb.append((char) ('A' + tmplong2 - 11));
                } else {
                    sb.append('_');
                }
            }
            tmplong1 /= BASE_38;
        }

        return sb.reverse().toString();
    }

    private static long parseCode2Hash(long s, int hashL) {
        s = (s * HASH_MULTIPLIER) >>> (64 - hashL);
        return s;
    }

    private static long parseName2FullCode(String s) {
        long code = 0;
        char[] charArr = s.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            int tmpChar;
            if (charArr[i] == ' ') {
                tmpChar = 0;
            } else if (Character.isDigit(charArr[i])) { // 简化判断逻辑
                tmpChar = 1 + (charArr[i] - '0');
            } else if (Character.isUpperCase(charArr[i])) {
                tmpChar = 11 + (charArr[i] - 'A');
            } else {
                tmpChar = 37;
            }
            code += POWER38[i] * tmpChar;
        }

        return code;
    }
}