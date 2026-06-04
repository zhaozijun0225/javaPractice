package 模版;

//selectSort 每次将当前元素替换为后面最小的元素
public static void selectSort(int[] nums) {
    int N = nums.length;
    for (int i = 0; i < N; i++) {
        int min = i;
        for (int j = i + 1; j < N; j++) {
            if (nums[j] < nums[min]) min = j;

        }
        if(min!=i){
            int t = nums[i];
            nums[i] = nums[min];
            nums[min] = t;
        }
    }
}


//insertSort 每次将当前元素插入到前面已经排好序的元素中
public static void insertSort(int[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
        int temp = a[i];
        int j = i;
        for (; j > 0 && a[j - 1] > temp; j--) {
            a[j] = a[j - 1];
        }
        a[j] = temp;
    }
}


//shellSort 将数组分组，并不断减小分组的步长直到为1，每次分组均进行插入排序
public static void shellSort(int[] a) {
    for (int step = a.length / 2; step > 0; step /= 2) {
        for (int i = step; i < a.length; i++) {
            int temp = a[i];
            int j = i;
            for (; j >= step && a[j - step] > temp; j -= step) {
                a[j] = a[j - step];
            }
            a[j] = temp;
        }
    }
}


//mergeSort 递归 对两个有序节点序列进行合并来实现排序，分治思想
public static void mergeSort(int[] arr) {
    if (arr == null || arr.length <= 1) return;
    int[] temp = new int[arr.length];
    mergeSort(arr, 0, arr.length - 1, temp);
}

//分解的方法
private static void mergeSort(int[] arr, int left, int right, int[] temp) {
    //如果左边索引小于右边就可以一直分，l=r时，就是分到只剩一个数了
    if (left < right) {
        int mid = (left + right) / 2;//左少右多
        //向左递归分解
        mergeSort(arr, left, mid, temp);
        //向右递归分解
        mergeSort(arr, mid + 1, right, temp);
        //合并
        merge(arr, left, mid, right, temp);
    }
}
//合并的方法

/**
 * @param arr   待排序的原始数组
 * @param left  左边有序序列的初始索引
 * @param mid   中间索引
 * @param right 右边结束索引
 * @return
 */
private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
    int i = left;
    int j = mid + 1;
    int t = 0;//temp数组的当前索引

    //合并数组，比较找最大
    while (i <= mid && j <= right) {
        if (arr[i] <= arr[j]) temp[t++] = arr[i++];
        else temp[t++] = arr[j++];
    }
    while (i <= mid) temp[t++] = arr[i++];
    while (j <= right) temp[t++] = arr[j++];

    //将temp数组拷贝到arr数组，并不是每次都拷贝所有
    t = 0;
    while (left <= right) arr[left++] = temp[t++];
}


//bubbleSort n-1遍历，每次找到未排序数组的最大值
public void bubbleSort(int[] arr) {
    if (arr == null || arr.length <= 1) return;
    for (int i = arr.length - 1; i >= 0; i--) {
        boolean hasSwapped = false;
        for (int j = 0; j < i; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                hasSwapped = true;
            }
        }
        if(!hasSwapped) break;
    }
}


//radixSort 按位数进行排序，借助桶bucket进行分配与收集
public void radixSort(int[] arr) {
    int max = 0;
    for (int i : arr) {
        if (i > max) max = i;
    }
    int count = (max + "").length();
    int digit, radixMulti = 1;
    for (int i = 1; i <= count; i++, radixMulti *= 10) {

        //分配
        int[][] bucket = new int[10][arr.length];
        //bucketCount用于统计该桶中元素的数量
        int[] bucketCount = new int[10];

        for (int value : arr) {
            digit = (value / radixMulti) % 10;
            bucket[digit][bucketCount[digit]++] = value;
        }

        //收集
        int k = 0;
        for (int j = 0; j < 10; j++) {
            //如果桶中有数据，放入数组
            if (bucketCount[j] != 0) {
                //循环该桶，取出元素到arr中，每取一个元素，桶中元素-1
                // 正确（正序取元素，保持稳定）
                for (int m = 0; m < bucketCount[j]; m++) {
                    arr[k++] = bucket[j][m];
                }
                //错误↓，倒序取的
//                while (bucketCount[j] != 0) arr[k++] = bucket[j][--bucketCount[j]];
            }
        }
    }
}


//heapSort 构建大顶堆或者小顶堆，将堆顶元素与堆尾元素交换后再调整，如此反复
public void heapSort(int[] arr) {
    //构建大顶堆 k为最后一个非叶子节点，逐渐-1，即从下向上，从右往左
    for (int k = arr.length / 2 - 1; k >= 0; k--) {
        adjustHeap(arr, k, arr.length);
    }

    //排序 交换+调整
    int temp = 0;
    for (int i = arr.length - 1; i >= 0; i--) {
        temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
        adjustHeap(arr, 0, i);
    }
}

/**
 * @param arr    待调整数组
 * @param i      非叶子节点在数组中的索引
 * @param length 对多少个元素进行调整
 */
public void adjustHeap(int[] arr, int i, int length) {
    int temp = arr[i];//取出当前非叶子叶结点的值
    //k为当前节点的左子节点
    for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
        if (k + 1 < length && arr[k + 1] > arr[k]) {//右子节点大于左子节点
            k++;//k指向右子节点
        }
        if (arr[k] > temp) {//如果当前节点大于父节点就交换
            arr[i] = arr[k];
            i = k;//!!!!!!精髓，因为该子节点值大小发生了改变，可能会使其子根堆发生改变，索引要调整其子根堆
        } else {
            break;//否则直接退出，因为其后面的节点一定满足堆定义
        }
    }
    arr[i] = temp;
}


//quickSort 每次选择一个元素并且将整个数组以这个元素分为两部分，小于该元素的放右边，大于该元素的放左边
public void quickSort(int[] arr, int l, int r) {
    if (l < r) { //跳出递归的条件
        //partition就是划分操作，将arr划分成满足条件的两个子表
        int n = partition(arr, l, r);
        //依次对左右两个子表进行递归排序
        quickSort(arr, l, n - 1);
        quickSort(arr, n + 1, r);
    }
}

public int partition(int[] arr, int l, int r) {
//    //以当前数组的最后一个元素作为中枢pivot，进行划分
//    int pivot = arr[r];
    // 优化2：三数取中法选择基准值，避免有序数组最坏情况O(n²)
    int pivot = median3(arr, l, r); // 基准值已经被交换到了r位置
    while (l < r) {
        while (l < r && arr[l] < pivot) l++;
        arr[r] = arr[l];//将比中枢值大的移动到右端r处 由于r处为中枢或者该位置值已经被替换到l处，所以直接可以替换
        while (l < r && arr[r] >= pivot) r--;
        arr[l] = arr[r];//将比中枢值小的移动到左端l处 由于前面l处的值已经换到r处，所以该位置值也可以替换掉
    }
    //l==r时，重合，这个位置就是中枢的最终位置
    arr[l] = pivot;
    //返回存放中枢的最终位置
    return l;
}

// 三数取中法：返回左、中、右三个数的中位数，并将其交换到r位置
private static int median3(int[] arr, int l, int r) {
    int mid = (l + r) >>> 1; // 无符号右移，避免整数溢出（比(l+r)/2更安全）

    // 排序三个数，使 arr[l] <= arr[mid] <= arr[r]
    if (arr[l] > arr[mid]) swap(arr, l, mid);
    if (arr[l] > arr[r]) swap(arr, l, r);
    if (arr[mid] > arr[r]) swap(arr, mid, r);

    // 将中位数（基准值）交换到r位置，这样你原来的partition代码完全不用改
    swap(arr, mid, r);
    return arr[r];
}

// 辅助交换方法
private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
