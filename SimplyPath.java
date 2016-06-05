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
public class SimplyPath {
    public static String simplifyPath(String path) {
        String[] strs = path.split("/");
        System.out.println("size: " +strs.length);
        for (int i = 0;i<strs.length;i++) 
            System.out.println(strs[i]);
        Stack<String> stk = new Stack<String>();
        for (int i = 0 ; i<strs.length ; i++) {
            String cur = strs[i];
            if (cur.equals(".")||cur.equals(""))
            {
                
            }
            else if (cur.equals("..")) {
                if (!stk.isEmpty())
                    stk.pop();
            }
            else stk.push(cur);
        }
        
        StringBuilder sb = new StringBuilder();
        
        if(!stk.isEmpty()) {
            while(!stk.isEmpty()) {
                String cur = stk.pop();
                if (cur!=""&&cur.length()!=0) {
                    sb.insert(0,cur);
                    sb.insert(0,"/");
                }
            }
        }
        else sb.append("/");
        return sb.toString();
        
    }
    public static void main (String[] args) {
        String str = "/..";
        System.out.println(simplifyPath(str));
        
    }
    
}
