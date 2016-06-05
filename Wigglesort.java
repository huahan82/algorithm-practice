/*
 * Given an unsorted array nums, reorder it 
 * such that nums[0] < nums[1] > nums[2] < nums[3].... 
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author hua
 */
public class Wigglesort {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int median= findKth(nums,0,n-1, n/2);
        for (int i = 0; i< n; i++) 
            System.out.println("list: " + nums[i]);
        System.out.println("median: " +median);
        //put number smaller than median to left, number larget than median to right number equal to median in middle
        int high = n/2 -1;
        for (int i = 0 ; i<high; i++) {
            while (nums[i]==median&&i<high) { 
                swap(nums, i, high);
                high--;
            }
            
        }
        int low = n/2+1;
        for (int i = (n-1); i>low; i-- ) {
            while(nums[i]==median && i>low) {
                swap(nums, i , low);
                low++;
            }
        }
        
        //now add number to the final location
       // for (int i =1; i<n/2 ; i+=2) {
        //    if(n/2%2!=0)
        //    swap(nums, i, n/2+i);
        //    else 
        //    swap(nums, i, n/2-1+i);
       // }
        int[] left = new int[(n+1)/2];
        int[] right = new int[n/2];
        for (int i = 0; i< (n+1)/2; i++) {
            left[i]=nums[i];
            System.out.println("Left: " + left[i]);
        }
        for (int i = 0 ; i < n/2 ; i++) {
            right[i]=nums[(n+1)/2 +i];
                 System.out.println("Right: " + right[i]);
        }
        for (int i = 0 ; i < n/2 ; i++) {
            nums[2*i]=left[i];
            nums[2*i+1] =right[i];
        }
        if (n%2==1) nums[n-1]= left[n/2];
        
    }
    
    public int findKth(int[] nums, int low, int high, int k) {
        if (low==high) return nums[low];
        int l = low;
        int h = high;
        while(l<h) {
            while(nums[l]<nums[high]&&h>l) l++;
            while(nums[h]>=nums[high]&&h>l) h--;
            if (l<h) swap(nums, l,h);
        }
        swap( nums,  l,  high);
        if (l==k) return nums[l];
        else if (l>k) return findKth(nums, low, l-1,k);
        else return findKth(nums, l+1, high, k);
    }
    
   public void swap(int[] nums, int i, int j) {
       int temp = nums[i];
       nums[i]=nums[j];
       nums[j]=temp;
   }


      
       public static void main(String[] args) {
           //int[] nums = {1,3,2,2,2,1,1,3,1,1,2};
           //int[] nums = {1,5,1,1,6,4};
           int[] nums = {4,5,5,6};

         Wigglesort ws = new Wigglesort();
           ws.wiggleSort(nums);
           for (int i = 0; i< nums.length ; i++) {
               System.out.println(nums[i]);
           }
           
       }
}
    

