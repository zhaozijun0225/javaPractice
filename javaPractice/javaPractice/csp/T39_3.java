package csp;


import java.io.BufferedInputStream;
import java.util.Scanner;

class T39_3 {

    static class Node {
        Character data;
        Node left;
        Node right;

        Node(Character data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        Node() {
            this.data = null;
            this.left = null;
            this.right = null;
        }
    }

    static class HuffmanTreeRebuilder {

        public static Node rebuildHuffmanTree(String s, int[] index) {
            if (index[0] >= s.length()) {
                return null;
            }

            if (s.charAt(index[0]) == '1') {
                index[0]++;
                char ch = s.charAt(index[0]);
                index[0]++;
                return new Node(ch);
            } else if (s.charAt(index[0]) == '0') {
                index[0]++;
                Node node = new Node();
                node.left = rebuildHuffmanTree(s, index);
                node.right = rebuildHuffmanTree(s, index);
                return node;
            }
            return null;
        }
    }


    static String getHuffString(Node huffTree, String s, int exceptNum) {
        Node tmpNode = huffTree;
        StringBuilder sb = new StringBuilder();
        s = s.toUpperCase();

        int tmpNum;

        for (char c : s.toCharArray()) {
            tmpNum = Character.digit(c, 16);
            sb.append(String.format("%4s", Integer.toBinaryString(tmpNum)).replace(' ', '0'));
        }

        char[] binary = new char[sb.length() - exceptNum];
        sb.getChars(0, sb.length() - exceptNum, binary, 0);
        sb.setLength(0);
        tmpNode = huffTree;
        char c;
        for (int i = 0; i < binary.length; i++) {
            c = binary[i];
            if (c == '0') {
                tmpNode = tmpNode.left;
            } else {
                tmpNode = tmpNode.right;
            }

            if (tmpNode.data != null) {
                sb.append(tmpNode.data);
                tmpNode = huffTree;
            }
        }

        return sb.toString();

    }

    static String checkAndGetString(String s) {

        if (s.startsWith("HH")) {
            return s.substring(1);
        } else if (s.startsWith("H")) {
            int exceptNum = Character.digit(s.charAt(s.length() - 1), 16);
            return getHuffString(huffTree, s.substring(1, s.length() - 2), exceptNum);
        } else {
            return s;
        }


    }

    static Node huffTree;

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedInputStream(System.in));

        int S, D;
        S = in.nextInt();
        D = in.nextInt();

        String[] staticKey = new String[S], staticValue = new String[S], tmpStrArr;
        String tmpStr1 = in.nextLine();

        for (int i = 0; i < S; i++) {
            tmpStr1 = in.nextLine();
            tmpStrArr = tmpStr1.split("\\s+", 2);
            staticKey[i] = tmpStrArr[0];
            staticValue[i] = tmpStrArr[1];
        }

        String encodedTree = in.nextLine();
        int[] index = {0};
        huffTree = HuffmanTreeRebuilder.rebuildHuffmanTree(encodedTree, index);

        int N = in.nextInt();
        tmpStr1 = in.nextLine();


        String[] dynamicKey = new String[D + 1], dynamicValue = new String[D + 1];
        int l = 0, r = 0; //l==r is empty, (r+1)%D==l is full

        int cmd, cmdIdx;
        String cmdKey = null, cmdVal = null;
        String ansKey = null, ansval = null;


        for (int i = 0; i < N; i++) {
            //读指令
            tmpStr1 = in.nextLine();
            tmpStrArr = tmpStr1.split("\\s+", 4);
            cmd = Integer.parseInt(tmpStrArr[0]);
            cmdIdx = Integer.parseInt(tmpStrArr[1]);
            if (tmpStrArr.length > 2)
                cmdKey = tmpStrArr[2];
            if (tmpStrArr.length == 4)
                cmdVal = tmpStrArr[3];


            //执行指令
            if (cmd == 1) {
                if (cmdIdx <= S) {
                    ansKey = staticKey[cmdIdx - 1];
                    ansval = staticValue[cmdIdx - 1];
                } else {
                    ansKey = dynamicKey[(r - 1 - (cmdIdx - S - 1) + D + 1) % (D + 1)];
                    ansval = dynamicValue[(r - 1 - (cmdIdx - S - 1) + D + 1) % (D + 1)];
                }
                System.out.printf("%s: %s\n", ansKey, ansval);
            } else if (cmd == 2) {
                if (cmdIdx == 0) {
                    ansKey = checkAndGetString(cmdKey);
                    ansval = checkAndGetString(cmdVal);
                } else {
                    if (cmdIdx <= S) {
                        ansKey = staticKey[cmdIdx - 1];
                    } else {
                        ansKey = dynamicKey[(r - 1 - (cmdIdx - S - 1) + D + 1) % (D + 1)];
                    }
                    ansval = checkAndGetString(cmdKey);
                }
                System.out.printf("%s: %s\n", ansKey, ansval);

                //存入

                if ((r + 1) % (D + 1) == l) {
                    l = (l + 1) % (D + 1);
                }

                dynamicKey[r] = ansKey;
                dynamicValue[r] = ansval;
                r = (r + 1) % (D + 1);

            } else {
                if (cmdIdx == 0) {
                    ansKey = checkAndGetString(cmdKey);
                    ansval = checkAndGetString(cmdVal);
                } else {
                    if (cmdIdx <= S) {
                        ansKey = staticKey[cmdIdx - 1];
                    } else {
                        ansKey = dynamicKey[(r - 1 - (cmdIdx - S - 1) + D + 1) % (D + 1)];
                    }
                    ansval = checkAndGetString(cmdKey);
                }
                System.out.printf("%s: %s\n", ansKey, ansval);
            }
        }
    }
}
