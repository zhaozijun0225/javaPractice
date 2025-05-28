package csp;

import java.io.BufferedInputStream;
import java.util.*;

class T37_3 {

    static class param {
        boolean isDynamic;
        boolean isDirty;

        long staticLength;

        long cacheLength;
        Set<param> needs; //内部需要的变量
        List<token> nowStore; //该变量对应的句子
        Set<param> asked; //会访问该变量的变量

        param() {
            isDynamic = false;
            isDirty = false;
            staticLength = 0;
            cacheLength = 0;
            needs = new HashSet<param>();
            nowStore = new ArrayList<token>();
            asked = new HashSet<param>();

        }


    }

    static class token {

        String value;
        boolean isFunc;

        token(String value, boolean isFunc) {
            this.value = value;
            this.isFunc = isFunc;
        }

    }

    static final long M = 1000000007;

    static HashMap<String, param> paramMap = new HashMap<String, param>();


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int i, n = in.nextInt(), j;
//        要去掉换行！！！
        in.nextLine();
        String[] part;

        for (i = 0; i < n; i++) {
            part = in.nextLine().split("\\s+", 3);
            if (part[0].equals("1")) {
                handleStatic(part[1], part[2]);
            } else if (part[0].equals("2")) {
                handleDynamic(part[1], part[2]);

            } else {
                System.out.println(getLength(part[1]) % M);

            }

        }


        return;
    }

    static long getLength(String s) {
        param p = paramMap.get(s);
        if (p == null) {
            return 0;
        }
        if (!p.isDynamic) {
            return p.staticLength % M;
        }

        if (!p.isDirty) {
            return p.cacheLength % M;
        }
        long l = 0;

//        if (!p.nowStore.isEmpty()) {
            for (token t : p.nowStore) {
                if (t.isFunc) {
                    l = (l + getLength(t.value)) % M;
                } else {
                    l = (l + t.value.length()) % M;
                }
            }
//        }
        p.isDirty = false;
        p.cacheLength = l;
        return l;


    }


    static void handleStatic(String paramName, String paramValue) {
        param p = paramMap.get(paramName);
        if (p == null) {
            p = new param();
            paramMap.put(paramName, p);
        }


        String[] t = paramValue.split("\\s+");

        long l = 0;
        for (String s : t) {
            if (s.charAt(0) == '$') {
                l = (l + getLength(s.substring(1))) % M;

            } else {
                l = (l + s.length()) % M;
            }

        }

        /// ///////////////

        if (p.isDynamic) {
            for (param tmp2 : p.needs) {
                tmp2.asked.remove(p);
            }
            p.needs.clear();
            p.nowStore.clear();

        }
        p.isDynamic = false;



        p.staticLength = l;
//        p.isDirty = true;
        spread(p);

    }

    static void handleDynamic(String paramName, String paramValue) {
        param p = paramMap.get(paramName);
        if (p == null) {
            p = new param();
            paramMap.put(paramName, p);
        }

        if (p.isDynamic) {
            for (param tmp2 : p.needs) {
                tmp2.asked.remove(p);
            }

        }


        String[] t = paramValue.split("\\s+");


        p.needs.clear();
        p.nowStore.clear();

        String subs;
        param tmp;
        for (String s : t) {
            if (s.charAt(0) == '$') {
                subs = s.substring(1);


                tmp = paramMap.get(subs);
                if (tmp == null) {
                    tmp = new param();
                    paramMap.put(subs, tmp);
                }
                p.nowStore.add(new token(subs, true));
                p.needs.add(tmp);
                tmp.asked.add(p);

            } else {

                p.nowStore.add(new token(s, false));
            }
        }

        for (param parent : p.needs) {
            parent.asked.add(p);
        }

        p.isDynamic = true;
        p.isDirty = true;
        spread(p);

    }

    static void spread(param p) {
        Queue<param> q = new LinkedList<>();
        Set<param> visited = new HashSet<param>();
        q.offer(p);
        visited.add(p);
        param tmp;
        while (!q.isEmpty()) {
            tmp = q.poll();

                for (param tmp2 : tmp.asked) {
                    if(!visited.contains(tmp2)) {

                            tmp2.isDirty = true;
                            q.offer(tmp2);

                        visited.add(tmp2);
                    }
                }

        }

    }

}
