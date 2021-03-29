package array.area;

import java.util.Stack;

/**
 *
 * Keep M1: stack
 *
 * M5: still reach TLE: but get local maximum index, from this index, gi back
 * T:O(N^2) S:O(1)
 *
 *
 *
 * 3/14/21
 *
 *
 * 想到一个点，是此柱必须被囊括，不必取比他低的点，因为比他低的点的计算，其他小柱会被默认取到
 *
 * M1: Brute force
 * T:O(N^2) S:O(1)
 *
 *
 * M2: Quick sort
 * T:O(NlogN) S:O(logN) -> 压栈空间
 *  S =  Math.max(getMaxArea(heights, left, mid),
                  getMaxArea(heights, mid + 1, right),
                  getMidArea(heights, left, mid, right);
 *
 * M3: Stack -- 重新做一遍
 *
 * for loop 整个数组
 *
 *
 *
 * 7/12/20.
 */
public class _84_largest_rectangle_in_histogram {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int res = 0;
        for(int i=0; i< heights.length; i++){
            int height = Integer.MAX_VALUE;
            for(int j=i; j<heights.length; j++){
                height = Math.min(height, heights[j]);
                res = Math.max(res, height*(j-i+1));
            }
        }
        return res;
    }

    public int largestRectangleArea2(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        return getMaxArea(heights, 0, heights.length - 1);
    }

    private int getMaxArea(int[] heights, int left, int right) {
        if (left == right) {
            return heights[left];
        }
        int mid = left + (right - left) / 2;
        //左半部分
        int area1 = getMaxArea(heights, left, mid);
        //右半部分
        int area2 = getMaxArea(heights, mid + 1, right);
        //中间区域
        int area3 = getMidArea(heights, left, mid, right);
        //选择最大的
        return Math.max(Math.max(area1, area2), area3);
    }

    private int getMidArea(int[] heights, int left, int mid, int right) {
        int i = mid;
        int j = mid + 1;
        int minH = Math.min(heights[i], heights[j]);
        int area = minH * 2;
        //向两端扩展
        while (i >= left && j <= right) {
            minH = Math.min(minH, Math.min(heights[i], heights[j]));
            //更新最大面积
            area = Math.max(area, minH * (j - i + 1));
            if (i == left) {
                j++;
            } else if (j == right) {
                i--;
                //选择较高的柱子
            } else if (heights[i - 1] >= heights[j + 1]) {
                i--;
            } else {
                j++;

            }
        }
        return area;
    }

    public int largestRectangleArea3(int[] heights) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
                int prev = stack.pop();
                if (stack.isEmpty()) {
                    ans = Math.max(ans, heights[prev] * i);
                } else {
                    ans = Math.max(ans, heights[prev] * (i - stack.peek() - 1));
                }
            }
            stack.push(i);
        }
        return ans;
    }
    // 这道题注意：
    // 去的是比当前位置小的第一个离最左，第一个里最右， 所以这两个值都不是真正的值
    // 且构建数组的时候
    // minLeft[0] = -1;
    // minRight[len-1] = len

    public int largestRectangleArea4(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        //求每个柱子的左边第一个小的柱子的下标
        int[] leftLessMin = new int[heights.length];
        leftLessMin[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            int l = i - 1;
            while (l >= 0 && heights[l] >= heights[i]) {
                l = leftLessMin[l];
            }
            leftLessMin[i] = l;
        }

        //求每个柱子的右边第一个小的柱子的下标
        int[] rightLessMin = new int[heights.length];
        rightLessMin[heights.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            int r = i + 1;
            while (r <= heights.length - 1 && heights[r] >= heights[i]) {
                r = rightLessMin[r];
            }
            rightLessMin[i] = r;
        }

        //求包含每个柱子的矩形区域的最大面积，选出最大的
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int area = (rightLessMin[i] - leftLessMin[i] - 1) * heights[i];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public int largestRectangleArea5(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int res=0;
        for(int i=0; i<heights.length; i++){
            // local optimal
            if (i + 1 < heights.length && heights[i] <= heights[i + 1]) {
                continue;
            }
            int localHeight = heights[i];
            for(int j=i; j>=0; j--){
                localHeight = Math.min(heights[j],localHeight );
                res = Math.max(res, localHeight* (i-j+1));
            }

        }
        return res;
    }
}
