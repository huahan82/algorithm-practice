/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author hua
 */
import java.util.*;
public class findMinLength {
    
      public static String minWindow(String s, String t) {
        
        Map<Character, Integer> map = new HashMap<Character, Integer> ();
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int index = 0;
        //construct the map for chars in string t
        for (int i = 0 ; i < t.length() ; i++ ) {
            map.put ( t.charAt(i), map.containsKey(t.charAt(i)) ? map.get(t.charAt(i))+1 :1);
            count++;
        }
        int j = 0;
        int i = 0;
        
        while(j<s.length()) {
            while ( count>0 && i<s.length() ) {
                if(map.containsKey(s.charAt(i))) 
                {
                    map.put(s.charAt(i), map.get(s.charAt(i))-1);
                    count--;
                    if (count==0) {
                       if (minLen>(i-j+1))
                        {
                        minLen=i-j+1;
                        index = i;
                        }  
                    }
                }
                    i++;
            }
            //reached the end of file and don't find all ch in T
            if (i==s.length()) break;

                //increase the need for the ch at j
  
                if(map.containsKey(s.charAt(j))) 
                {
                    map.put(s.charAt(j), map.get(s.charAt(j))-1);
                    count++;
                }
                //move the window right
                j++;
                
        }
        System.out.println("index: " + index + " len " + minLen);
        if (minLen==Integer.MAX_VALUE) return "";
       //return "";
        return s.substring(index,index+minLen);

    }
       //keep a sliding window and check the sum of numbers in the window, record the min length.
    public static int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n==0) return 0; 
        int[] sums = new int[n+1];
        int min = Integer.MAX_VALUE;
        
        for (int i =1 ; i<n+1 ; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        
        for (int i = 0 ; i < n ; i ++) {
            int end = binarySearch (sums[i]+s, i+1 , n, sums);
            System.out.println("break1: " + end);
            if (end > n) break;
            System.out.println("min set: " + min);
            min = Math.min(min, end-i);
        }
        if(min==Integer.MAX_VALUE) return 0;
        return min;

    }
    
    public static int binarySearch(int target, int start, int end, int[] sums) {
        while(start<=end) {
            int mid = start + (end - start)/2;
            System.out.println(" mid " + sums[mid]);
            if (sums[mid]<target) 
            start = mid + 1;
            else end = mid -1;
        }
        return start;
    }
    
    public static void main(String[] args) {
        //int[] nums = {1,2,5,7,5,3,6};
       // int len = minSubArrayLen(14, nums) ;
       // System.out.println(" the mini length is " + len);
        String s = "a";
        String t = "a";
        System.out.println(minWindow( s,  t) );
        
    }
    
}
