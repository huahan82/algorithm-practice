/*
 * [1] Given an array of integers, determine whether or not there exist two 
 * elements in the array (at different positions) whose sum 
 * is equal to some target value.

Examples:
[5, 4, 2, 4], 8 --> true
[5, 1, 2, 4], 8 --> false
 */
package leetcode;
import java.util.*;

/**
 *calculate whether any two elements in an array sum up to a given value
 * @author hua
 */
public class TwoSum {
    
    public static boolean twoSum(int[] ary, int n){
        if (ary.length==0) return false;
        Arrays.sort(ary); //sort the array
        //if the given taget is smaller than twice of the smallest number 
        //or larger than tiwce of the largest number, return false
        if (n < 2 * ary[0] || n > 2 *ary[ary.length -1]) return false;
        int left = 0;
        int right = ary.length -1;
        while (left<right) {
            if ((ary[left]+ary[right])==n) return true;
            while ((ary[left]+ary[right])< n && left <right) left++;
            while (((ary[left]+ary[right])> n && left<right)) right--;
        }
        return false;
        
        
    }
    
    public static void main(String[] args) {
        int[] ary = {5,4,2,4};
        int[] ary2 = {5,1,2,4};
        

        if (twoSum(ary, 0)) System.out.println("get 0!");
        if (twoSum(ary, 8)) System.out.println("get 8");
        if (twoSum(ary, 10)) System.out.println("get 10");
        if (twoSum(ary, 14)) System.out.println("get 14");
        if (twoSum(ary2, 8)) System.out.println("ary2 get 8");
        
        
    }
    
}
