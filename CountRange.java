/*
 * given an array, find consective subsequence within the lower and upper bound
 * limit, inclusive.
 * divide and conquer, BST search, 
 * in case there are duplicated, the upper bound and lower bound is adjusted by 0.5
 */
package leetcode;

/**
 *
 * @author hua
 */
import java.util.*;
public class CountRange {
    public  int countRangeSum(int[] nums, int lower, int upper) {
        return count(nums, 0 ,nums.length-1, lower, upper); 
    }

    // merge sort and store numbers that should be moved to the left of the ith 
     //       number
    public  int count(int[] nums, int left, int right, int lower, int upper) {
        if(nums.length==0||left>right||lower>upper) return 0;
        if (left==right) {
            if (nums[left]>=lower&&nums[left]<=upper) {
                return 1;
            }
            else return 0;
        }
        int count =0;
        int mid = left + (right-left)/2;
        //get the sum for right side 
        long[] sum = new long[right-mid];
        sum[0]=nums[mid+1];
        for (int i = 1 ; i < sum.length ; i++) 
        { sum[i] +=sum[i-1] + nums[mid+i];
           
        }
        Arrays.sort(sum);
        for (int i =0; i< sum.length ;i++) 
             System.out.println("sum: " + sum[i]);
        int leftsum = 0;
        for (int k = mid ; k>=left ; k--) {
            leftsum+=nums[k];
            count  +=  binary(sum,0, sum.length-1, upper-leftsum+0.5)- binary(sum,0,sum.length-1, lower-leftsum-0.5);
        }


        return count(nums, left, mid, lower, upper) + count(nums, mid+1, right, lower, upper ) + count;
    }
    
    public int binary(long[] sum,int low, int high, double target) {
      
        while(low<=high) {
            int mid = low + (high-low)/2;
            if (sum[mid]<=target) low = mid+1;
            else high = mid - 1;
        }
  
        return low;

    }
    public static void main(String[] args) {
        int[] array = {-2,5,-1};
        int lower = -2;
        int upper = 2;
        CountRange cr = new CountRange();
        System.out.println(cr.countRangeSum(array, lower, upper)); 

    }
}
    

