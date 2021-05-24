package facebook.practice_question;

/**
 * swap时， 时做一半操作就够了，很精巧的思考和数据操作
 *
 *
 * T:O(N) S:O(N)
 *
 * 4/6/21.
 */
public class MinimizingPermutations {

    int minOperations(int[] arr) {
        // Write your code here

        if(arr == null || arr.length <= 0) {
            return 0;
        }

        int[] a = arr;

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if(i+1 == a[i]) {
                continue;
            }

            int st = i;
            int en = st;
            for (int j = i+1; j < a.length; j++) {
                if(a[j] == i + 1) {
                    en = j;
                    break;
                }
            }

            revers(a, st, en);
            count++;
        }

        return count;
    }

    void revers(int[] a, int i, int j) {
        int stop = (j-i)/2 + i + 1;
        for (; i<stop; i++, j--) {
            swap(a,i,j);
        }
    }

    void swap(int[]a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
