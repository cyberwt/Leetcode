* while 循环判定清，跳出值
while(left <= right)

* mid 计算不溢出 (Integer.MAX_VALUE)

> 防溢出措施：

-mid = left+ (right-left)/2

-mid< n/mid


> 通式:

public int binarySearch(int[] nums, int key) {
    int l = 0, h = nums.length - 1;
    while (l <= h) {
        int m = l + (h - l) / 2;
        if (nums[m] == key) {
            return m;
        } else if (nums[m] > key) {
            h = m - 1;
        } else {
            l = m + 1;
        }
    }
    return -1;

> 时间复杂度 

每次都能将查找区间减半，这种折半特性的算法时间复杂度为 O(logN)。

所以优化解时，都可用这种方式，有 有序数组 作为前提

> 未成功查找的返回值

-1：以一个错误码表示没有查找到 key
l：将 key 插入到 nums 中的正确位置

> 变种

例如在一个有重复元素的数组中查找 key 的最左位置的实现如下：

public int binarySearch(int[] nums, int key) {
    int l = 0, h = nums.length;
    while (l < h) {
        int m = l + (h - l) / 2;
        if (nums[m] >= key) {
            h = m;
        } else {
            l = m + 1;
        }
    }
    return l;
}

> 变化的量有

1. while(l<=h) 有没有等号
那可以继续思考退出条件
l<=h, 退出条件: l>h
l<h, 退出条件:l=h


2. l, h 和mid的关系， 需不需要+1/-1
3. 返回值, l or h or -1 
or return l < n ? letters[l] : letters[0];


4. 两种类型，求最左，求最右的边界
LC 34