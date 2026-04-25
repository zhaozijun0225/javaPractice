package leetcode;

import java.util.ArrayDeque;
import java.util.Objects;

public class T394 {
    int idx;
    ArrayDeque tmpdq = new ArrayDeque<>();

    public String decodeString(String s) {
        idx = 0;
        ArrayDeque<String> stk = new ArrayDeque<>();
        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (Character.isDigit(c)) {
                String digits = getDigit(s);
                stk.push(digits);
            } else if (c == '[' || (c >= 'a') && c <= 'z') {
                stk.push(String.valueOf(c));
                idx++;
            } else {
                idx++;
                StringBuffer sb = new StringBuffer();
                tmpdq.clear();
                while (!"[".equals(stk.peek())) {
                    tmpdq.push(stk.pop());
                }
                stk.pop();
                while(!tmpdq.isEmpty()) {
                    sb.append(tmpdq.pop());
                }
                int t = Integer.parseInt(stk.pop());
                stk.push(sb.toString().repeat(t));


            }


        }
        StringBuffer sb = new StringBuffer();

        for(String tmp : stk.reversed()){
            sb.append(tmp);
        }

        return sb.toString();

    }

    String getDigit(String s) {
        StringBuffer sb = new StringBuffer();
        while (Character.isDigit(s.charAt(idx))) {
            sb.append(s.charAt(idx++));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
