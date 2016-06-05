/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 * Divide two integers without using multiplication, division and mod operator.
If it is overflow, return MAX_INT. 
 * @author hua
 */
public class Divide {
        public static int divide(int dividend, int divisor) {
            
       // System.out.println("divisor:" + divisor);
        if(divisor==0) return Integer.MAX_VALUE;
        if (dividend==0 || dividend<divisor) return 0;
        int sign= (dividend>0)^(divisor>0)?-1:1;
        long div=Math.abs((long)dividend);
        long dis=Math.abs((long)divisor);
        long lans = divideL(div, dis);
        if (lans>Integer.MAX_VALUE) {
            return (sign==-1? Integer.MIN_VALUE: Integer.MAX_VALUE);
        }
        //int ans = (int) (sign*lans);
        return (int) (sign*lans);
    }
        public static long divideL(long dividend, long divisor) {
            long lans;
           
            if (dividend==divisor) return 1;
            if (dividend < divisor) return 0;
            long sum= divisor;
            lans = 1;
            while ((sum+sum) <=dividend) {
                sum += sum;
                lans += lans;
            }
            lans +=divideL(dividend-sum, divisor);
            
         
            return lans;
        }
        
     public static void main(String[] args) {
         int dividend = 2147483647;
         int divisor = 1;
         System.out.println(divide(dividend,divisor));
     }
    
}
