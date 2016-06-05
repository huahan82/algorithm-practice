/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;
import java.util.*;

/**
 *
 * @author hua
 */
public class findOrder {
    public  int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int cur = 0;
        int[] degree = new int[numCourses];
        List [] pre = new List[numCourses];
        for ( int i =0 ; i<numCourses ; i++) {
            pre[i] = new ArrayList<Integer> ();
        }
        for (int i = 0 ; i < prerequisites.length ; i ++) {
            pre[prerequisites[i][1]].add(prerequisites[i][0]);
            degree[prerequisites[i][0]]++;
        }
        System.out.println("degree");
        for (int i = 0 ; i<numCourses; i++) 
            System.out.println(degree[i]);
        List<Integer> layer = new ArrayList<Integer>();
        for (int i = 0; i <numCourses ; i++) {
            if (degree[i]==0) {
                layer.add(i);
                res[cur++]=i;
            }
        }
        while (!layer.isEmpty()&&cur<numCourses) {
            List<Integer> newLayer = new ArrayList<Integer>();
            for (int i : layer) {
                for (int j = 0 ; j<pre[i].size() ; j++ ) {
                    int course =(int) pre[i].get(j);
                    if (--degree[course] == 0) 
                    {newLayer.add(course);
                    res[cur++]=course;
                    }
                }
            }
            layer = newLayer;
        }
        if (cur == numCourses)
        return res;
        else return null;
    }
    
    public static void main(String[] args) {
        int numCourses = 2 ;
        findOrder2 test = new findOrder2();
        //findOrder test = new findOrder();
        int[][] pre = {{1,0}};
        //int[][] pre = {{0,1},{2,0},{3,1},{3,2}};
        int[] res = test.findOrder(numCourses, pre);
        System.out.println("course schedule");
        for (int i = 0 ; i < res.length ; i ++) {
            System.out.println(res[i]);
        }
    }
    
}
