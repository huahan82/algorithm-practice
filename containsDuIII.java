/*
 Given an array of integers, 
 * find out whether there are two distinct indices i and j in the array 
 * such that the difference between nums[i] and nums[j] is at most t 
 * and the difference between i and j is at most k. 
 */
package leetcode;

/**
 *
 * @author hua
 */
import java.math.*;
public class containsDuIII {
    //brutal force
   public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
       int length = nums.length;
       if (length==0) return false;
       for (int i = 0 ; i < length ; i ++) {
           for (int j = i+1 ; j <= Math.min(length-1, i + k); j ++ ) {
               if (Math.abs(nums[i]-nums[j])<=t) 
                   return true;
           }
       } 
      return false;}
   
   //BST construc the BST based on value, save indexes and rankes of all values
      
}
