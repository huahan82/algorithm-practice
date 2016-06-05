/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author hua
 */
public class Container {
    int size;
    int level = 0;
    public Container(int size){
        this. size = size; 
    }
    public void in() {
        level = size;
    }
    public void out() {
        level = 0;
    }
    //transfer water from c1 to c2
    public void transfer(Container c2) {
        int temp = c2.level;
        c2.level = ((this.level + temp)< c2.size)? (this.level+temp): c2.size;
        this.level = ((this.level + temp) < c2.size)? 0: this.level + temp - c2.size;     
    }
    /*
    public static void main(String[] args){
        Container c1 = new Container(5);
        Container c2 = new Container (3);
               System.out.println(c1.level);
        c1.in();
               System.out.println(c1.level);
        
        c1.transfer(c2);
               System.out.println(c2.level);
        c2.out();
               System.out.println(c2.level);
        c1.transfer(c2);
        c1.in();
               System.out.println(c1.level);
        c1.transfer(c2);
        System.out.println(c1.level);
    }
    */
}
