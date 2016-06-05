/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;
import java.math.*;

/**
 *
 * @author hua
 */

public class SetImplementation  {
    
    //elements in the set 
        public class DoubleListNode{
        int val;
        DoubleListNode next=null;
        DoubleListNode pre=null;
        private DoubleListNode(int val) {
            this.val = val;

        }
        
        private DoubleListNode() {
            this.val = 0;
        }
    }

    
    DoubleListNode head;
    DoubleListNode tail;
    int count = 0;
    
    public SetImplementation() {
        
}
    //add an element at the end of the set
    public boolean add( int e) {
        DoubleListNode node = new DoubleListNode(e);
        if (head == null) {
            head = node;
            tail = node;
        }
        else {
            tail.next=node;
            node.pre=tail;
            tail = node;
        }
        count++;
        return true; 
    }
    public boolean insert(int e) {
        return this.add(e);
    }
    
    //insert an element to the ith index position
    public boolean insert(int i, int e) {
        assert(i>=0);
        
        if (i>=count) return this.add(e);
        DoubleListNode node = new DoubleListNode(e);
        
        if (i==0) {
            node.next=head;
            head.pre=node;
            head=node;
        }
        else {
            DoubleListNode p = head;
            for (int k = 1; k < i ;k ++) p=p.next;
            node.next=p.next;
            p.next.pre=node;
            p.next=node;
            node.pre=p;
        }
        
        count++;
        return true;
    }
    //get the index of an element in the set
    // if the element is not in the set, return -1;
    public int indexOf(int e) {
        int i =0;
        DoubleListNode node = head;
        while(i<count) {
            if (node.val == e) break;
            node = node. next ;
            i ++;
        }
        if (i == count) return -1;
        return i;
    }
    //return the element at given index
    public int get(int index) {
        assert (index>=0 && index<count);
        DoubleListNode node = head;
        for (int i = 0 ; i< index; i++) node = node.next;
        return node.val;
    }
    //remove an element from the set, if the element is not in the set, return 
    //false
    public boolean remove(int e) {
        int i = indexOf(e);
        if ( i == -1) 
            return false;
        //remove head
        if (i == 0) {
            if (count == 1)  {
                head = null;
                tail = null;
    
            }
            DoubleListNode newHead = head.next;
            newHead.pre = null;
            head.next = null;
            head = newHead;
        }
        //remove tail
        else if (i == count - 1) {
            DoubleListNode newTail = tail.pre;
            newTail.next = null;
            tail.pre = null;
            tail = newTail;
        }
        //remove middle index of element
        else {
            DoubleListNode pre = head;
            for (int k = 1; k < i; k ++ ) {
                pre = pre.next;
            }
            DoubleListNode p = pre.next;
            pre.next = p.next;
            p.next.pre = pre;
            p.pre=null;
            p.next=null;
        }
        count--;
        return true;
    }
    //return a random number in the set
    public int getRandom() {
        int index = (int) (Math.random()*count);
        return get(index);
    }
    public int size() {
        return count;
    }
    public static void main(String[] args) {
        SetImplementation set = new SetImplementation();
        set.insert(1);
        set.insert(3);
        set.insert(6);
        set.insert(8);
        System.out.println("set after insertion: ");
        for (int i = 0; i< set.size() ; i++) 
        System.out.println(set.get(i));
        set.remove(6);
        System.out.println("set after remove: ");
        for (int i = 0; i< set.size() ; i++) 
        System.out.println(set.get(i));
        System.out.println("get random: ");
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
    }
    
}
