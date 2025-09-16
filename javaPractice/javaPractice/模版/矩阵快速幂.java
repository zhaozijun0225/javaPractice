class mat {
    int[][] nums;

    mat(int a, int b) {
        nums = new int[a][b];
    }

    mat(int[][] a) {
        nums = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                nums[i][j] = a[i][j];
            }
        }
    }

    mat multiply(mat a) {
        mat res = new mat(this.nums.length, a.nums[0].length);
        int i, j, k;
        //小细节：乘法时的第一维索引要是外层for(相对会快一点)，所以调整了for循环的顺序
        for (k = 0; k < this.nums[0].length; k++)
            for (i = 0; i < this.nums.length; i++)
                for (j = 0; j < a.nums[0].length; j++)
                    res.nums[i][j] += this.nums[i][k] * a.nums[k][j];

        return res;
    }

    void initI(){
        for (int i = 0; i < this.nums.length; i++)
            this.nums[i][i] = 1;
    }

}

public mat matPow3(mat a, int b) {
    mat ans = new mat(a.nums.length, a.nums[0].length);
    ans.initI();
    mat tmpa = new mat(a.nums);

    while (b > 0) {
        if ((b & 1) == 1) {
            ans = ans.multiply(tmpa);
        }
        tmpa = tmpa.multiply(tmpa);
        b >>= 1;
    }
    return ans;
}

public void main() {
    int[][] t1 = new int[][] {{1,2},{1,2}};
    mat t2 = new mat(t1);
    mat ans = matPow3(t2,2);

    return;
}
