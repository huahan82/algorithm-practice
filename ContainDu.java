/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author hua
 */
public class ContainDu {
    Node root;
    public class Node {
        int val;
        Node left;
        Node right;
        public Node() {
        }
        public Node(int val) {
            this.val=val;
        }
  
    }
    public ContainDu(){
    }
    public void put(int num) {
            root = add(root, num);
    }
    //add a new value to the tree
    public Node add(Node root, int num) {
        Node cur = new Node(num);
        if (root==null) {
            return cur;
        }
        else if (root.val>num) root.left = add(root.left, num);
        else root.right = add(root.right, num);
        return root;
    }
    //check whether a value is in the tree
    public boolean search(Node root, int val) {
        if (root==null) return false;
        if (root.val==val) return true;
        else if (root.val<val) return search(root.right, val) ;
        else return search(root.left, val);
    }
    public void delete(Node root, int num) {
        if (root==null) return;
        if (root.val==num) {
            Node node = root
            while (node.right!=null) {
                node= node.right;
            }
            node.left
        }
        if (root.val>num) return delete(root.left, num);
        else return delete(root.right, num);
    }
 
        
    public boolean BST(int num, int i, Node root, int k, int t) {
        
        Node cur =new Node(num,i);
        if (root==null) {
            root = cur;
            return false;
        }
        System.out.println("root val: " +root.val + " num val: " + num);
        if (Math.abs(num-root.val)<= t && (i-root.index)<= k ) 
            return true;
        if (root.val==num) 
        {
            root.index = i;
            return false;
        }
        
        if (root.val>num)  {
            if (root.left==null) {
                root.left = cur;
                return false;
            }
            return BST(num, i, root.left, k , t);
        
        }
            
        else {
            if (root.right==null) {
                root.right=cur;
                return false;
            }
            return BST(num, i, root.right, k, t);
        }
 
        } 

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length==0 ||nums.length==1) return false;
        Node root=new Node(nums[0],0);
        for (int i = 1; i< nums.length ; i++) 
            if (BST(nums[i], i , root, k, t)) return true;
        return false;
        
    }
    
    public static void main(String[] args) {
        int[] nums = {10,100,11,9}; 
        int t = 2;
        int k = 1;
        ContainDu test = new ContainDu();
        if (test.containsNearbyAlmostDuplicate(nums, k, t))
            System.out.println(" yes");
    }
}
    

