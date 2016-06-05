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
public class findOrder2 {
    List[] pre;
    boolean[] visited;
    boolean[] added;
    int[] res;
    int cur;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res = new int[numCourses];
        visited = new boolean[numCourses];
        added = new boolean[numCourses];
        pre = new List[numCourses];
        cur = numCourses-1;
        for ( int i =0 ; i<numCourses ; i++) {
            pre[i] = new ArrayList<Integer> ();
        }
        for (int i = 0 ; i < prerequisites.length ; i ++) {
            pre[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for (int i = 0 ; i < numCourses ; i++) {
            if (added[i]) continue;
            if (!dfs(i)) 
            {   System.out.println("there is a loop");
                return new int[0];
            }
        }
        return res;
}
    public boolean dfs(int i ) {
        System.out.println("visitied " + i +" "+visited[i]);
        if (visited[i]) {
            System.out.println("a loop");
            return false;
        }
        visited[i]=true;
        for (int j =0 ; j<pre[i].size() ; j++) {
            int next = (int)pre[i].get(j);
            if (!added[next]) {
                if(!dfs (next))
                    return false;
            }
        }
        res[cur--]=i;
        added[i]=true;
        visited[i]=false;
        return true;
    }
}
    

