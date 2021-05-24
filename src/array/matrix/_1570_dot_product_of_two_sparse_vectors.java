package array.matrix;

import java.util.HashMap;

/*
*
*  Sparse Matrix:
*  1.hashmap to record if needs calculation
*  2. convert to use less size map do the caculation
*  3. map.keySet()  T:O(N)  S:O(numNonZeroValues) space
*
 *
 *4/24/21.
 */
public class _1570_dot_product_of_two_sparse_vectors {
    Map<Integer, Integer> map;      // For all non-zero values in the vector, we map the index to the non-zero value.

    // O(nums.length) time.
    // O(numNonZeroValues) space.
    SparseVector(int[] nums) {
        map = new HashMap<>();
        // Store the position and value of non-zero values.
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }


    // O(min(vec1numNonZeroValues, vec2numNonZeroValues)) time because we iterate through non-zero values of the vector that has fewer non-zero values and for each value we check in O(1) time whether the other vector has a non-zero value at that index.
    // O(1) space.
    public int dotProduct(SparseVector vec) {
        if (vec.map.size() < this.map.size()) return vec.dotProduct(this);      // We want to iterate through the smaller map.

        int result = 0;
        for (Integer currIdx : this.map.keySet()) {
            // If both vectors have a non-zero value at currIdx then multiply the values and add them to the result.
            if (vec.map.containsKey(currIdx)) {
                result += this.map.get(currIdx) * vec.map.get(currIdx);
            }
        }
        return result;
    }
}
