import java.util.*;
public class Solution {
    /*
    Source: https://leetcode.com/problems/longest-consecutive-sequence/?tab=Description
    Find the longest consecutive sequence in an array
    */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> S = new HashSet<Integer>();
        int n = nums.length;
        int ans = 0;

        // Hash all the array elements
        for (int i=0; i<n; ++i) S.add(nums[i]);

        // check each possible sequence from the start
        // then update optimal length
        for (int i=0; i<n; ++i) {
            // if current element is the starting
            // element of a sequence
            if (!S.contains(nums[i]-1))
            {
                // Then check for next elements in the
                // sequence
                int j = nums[i];
                while (S.contains(j))
                    j++;

                // update  optimal length if this length
                // is more
                if (ans<j-nums[i]) ans = j-nums[i];
            }
        }
        return ans;
    }
}
