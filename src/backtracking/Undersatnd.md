https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)



如果是求:所有的解的排列 -> permutation -> I need index from 0, to help me, reuse every elemenets that in the arr
所有解 -> combination
所有路径 -> subsets

数组，去重解，
> Arrays.sort(nums)   if(i!=index && nums[i] == nums[i-1]) continue;

> 什么时候用 boolean[]



index from 0


