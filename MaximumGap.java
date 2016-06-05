/*
 * LeetCoce 164
 * Given an unsorted array, find the maximum difference between the 
 * successive elements in its sorted form.
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author hua
 */
import java.util.*;
public class MaximumGap {
    //pegieon hole /bucket sorting algorithm
     public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n<2) return 0;
        int min=nums[0];
        int max=nums[0];
        for (int i = 1 ; i< n ; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        //get the inteval bwteen buckets, in case max==min add 1
        int inteval = (max-min+1)/n + 1;
        //create arrays for buckets
        
        int[] maxi = new int[n+1];
        int[] mini = new int[n+1];
        Arrays.fill(maxi, Integer.MIN_VALUE);
        Arrays.fill(mini, Integer.MAX_VALUE);
        //put nums into buckets
        for (int i = 0 ; i <n ; i++) {
            int index = (nums[i]-min) /inteval; 
            maxi[index] = Math.max(maxi[index], nums[i]);
            mini[index] = Math.min(mini[index],nums[i]);
        }
        int prev = min;
        int gap=0;
        for (int i = 0 ; i<=n ; i++) {
            if (maxi[i]==Integer.MIN_VALUE) continue;
            gap = Math.max(gap, mini[i]-prev);
            prev=maxi[i];
        }
        return gap;
    }
    // radix sorting algorithm
}
