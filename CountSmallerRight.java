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


public class CountSmallerRight {
    //1 solve the problem with binary index tree

    public List<Integer> countSmaller3(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length; 
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i< n ; i++) {
            min= Math.min(min, nums[i]);
        }
        int[] nums2 = new int[n];
        for (int i = 0 ; i< n ; i++) {
            nums2[i]=nums[i]-min+1;
            max=Math.max(max, nums2[i]);
        }
        int[] BIT = new int[max+1];
        for (int i = nums2.length-1; i>=0; i--) {
           // System.out.println("i: "+i);
           // System.out.println("nums2[i]: "+nums2[i]);
            
            res.add(0, get(nums2[i]-1, BIT));
            add(nums2[i],BIT);
        }
        return res;   
    }
    
    
    public void add(int i, int[] BIT) {
        while(i<BIT.length) {
            BIT[i]++;
            i += i&(-i);
        }
    }
    
    public int get(int i, int[] BIT) {
      //  System.out.println("i: "+i);
      //  System.out.println(BIT.length);
        int sum = 0;
        while(i>0) {
            sum += BIT[i];
            i -=i&(-i);
        }
        return sum;
    }
    
    
    
    //2 solve the problem with binary search tree,
    // the worst case will be o(n2)
    public class Node {
        int val;
        Node left, right;
        int leftSum =0;
        int count=1;
        public Node(int val) {
            this.val = val;
        }
    }
    Node root;
    public List<Integer> countSmaller2(int[] nums) {
        int n = nums.length;
        List<Integer> res = new LinkedList<>();
        if (n==0) return res;
        Integer[] count = new Integer[n];
        Arrays.fill(count, 0);
        for (int i = n - 1; i>=0 ; i--) 
            root=add(root, nums[i], count, i);
        res.addAll(Arrays.asList(count));
        return res;
    }
    public Node add(Node node, int num, Integer[] count, int i) {
        if (node==null) return new Node(num);
 
        else if (node.val>num) { 
            node.left = add(node.left, num, count, i);
            node.leftSum++;
        }
        else if (node.val<num) {
            node.right=add(node.right, num, count, i);
            count[i]=count[i]+ node.leftSum +node.count;
        }
        else {
            node.count++;
            count[i]+=node.leftSum;
        }
        return node;
        
    }
    //3 soleve the problem with merge sort
     public class NumInd {
        int val;
        int index;

        public NumInd(int val, int index) {
            this.val=val;
            this.index=index;
        }
    }
  

    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> res = new LinkedList<>();
        NumInd[] numIndex =new NumInd[n];
        int[] count =new int[n];
        for (int i = 0 ; i< n ; i++) {
            numIndex[i]= new NumInd(nums[i],i);
        }
        numIndex=sort(numIndex,count);
        for (int i = 0 ; i< n; i++) 
        res.add(count[i]);
        return res;
    }
    
    public NumInd[] sort(NumInd[] arr,int[] count) {
        
        int length = arr.length;
        if (length==1) return arr;
        int mid = length/2;
        
        NumInd[] left = new NumInd[mid];
        NumInd[] right = new NumInd[length-mid];
        for (int i = 0 ; i < mid; i++) 
         left[i]=arr[i];
        for (int i = mid; i<length ;i++) 
        right[i-mid]=arr[i];
        left = sort(left,count);
        right = sort(right,count);
        //merge
        int m = left.length;
        int n = right.length;
        int i = 0;
        int j = 0;

        while((i+j)<(n+m)) {
            if (j>=n|| i<m && (left[i].val<=right[j].val)) {
                arr[i+j]=left[i];
                count[left[i].index] +=j;
                i++;
            }
            else {
            arr[i+j]=right[j];
            j++;
            }
        }
        return arr;
        
    }
    
    public static void main(String[] args) {
        CountSmallerRight cs = new CountSmallerRight();
        int[] arr = {5,2,6,1};
        List<Integer> res = cs.countSmaller3(arr);
        for (Integer i: res) 
            System.out.println(i);
        res = cs.countSmaller (arr);
            for (Integer i: res) 
            System.out.println(i);
        
    }

    
}
