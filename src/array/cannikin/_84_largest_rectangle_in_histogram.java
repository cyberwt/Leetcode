package array.cannikin;

import java.util.Stack;

/**
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
 * M3: Stack
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
        int len = heights.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++){
            int h = (i == len ? 0 : heights[i]);
            if (s.isEmpty() || h >= heights[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

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
}
