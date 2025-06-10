package 模版;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();//数组a的长度
        int q = scan.nextInt();//询问的个数
        int[] a=new int[n];
        int m=(int)(Math.log(n+1)/Math.log(2))+1;
        int[][] st=new int[n][m];
        for(int i=0;i<n;i++){
            a[i]=scan.nextInt();
            st[i][0]=a[i];
        }
        for(int j=1;j<m;j++){
            for(int i=0;i+(1<<j)-1<n;i++){
                st[i][j]=Math.max(st[i][j-1],st[i+(1<<j-1)][j-1]);
            }
        }
        while(q-->0)
        {
            int l=scan.nextInt();
            int r=scan.nextInt();
            System.out.println(RMQ(st,l-1,r-1));
        }
    }
    public static int RMQ(int[][] st,int l,int r){
        int k=(int)(Math.log(r-l+1)/Math.log(2));
        return Math.max(st[l][k],st[r-(1<<k)+1][k]);
    }
}
