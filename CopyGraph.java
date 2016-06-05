/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;
import java.util.*;


public class CopyGraph {
    final private static Map copyMap = new HashMap();
    final private static Stack nodeStack = new Stack();
    Node graph;
    
    public static class Node {
        final private Set<Node> neighbors = new HashSet();
        int value;
        
        public Set getNeighbors() {
            return this.neighbors;
        }
        
        public void addToNeighbor (final Node node) {
            neighbors.add(node);
        }
    }
    
    public CopyGraph(Node graph){this.graph=graph;}
    
    public static Node copyGraph ( Node graph) {
        if (graph == null) {
            return null;
        }
        
        
        nodeStack.push(graph);
        Node copy = new Node();
        copy.value = graph.value;
  
            
        copyMap.put(graph, copy);
        
        while (!nodeStack.empty()) {
            Node originalNode = (Node) nodeStack.pop();
            Node copiedNode = new Node();
            Iterator it =originalNode.getNeighbors().iterator();
            for (int i = 0;i< originalNode.getNeighbors().size();i++) {
                Node neighbor = (Node) it.next();
            if (!copyMap.containsKey(neighbor)) {
                Node copiedNeighbor = new Node();
                copiedNeighbor.value=neighbor.value;
                copyMap.put(neighbor, copiedNeighbor);
                nodeStack.push(neighbor);
            }
            ((Node)copyMap.get(originalNode)).addToNeighbor((Node) copyMap.get(neighbor));
            } 
            
            
        }
        return copy;
        
    }
    
    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
     public void recoverTree(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case. 
        if(root==null || (root.left==null&&root.right==null)) return;
        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode> ();
        sort(root, nodeList);
        int x=0, y=0;
    
        for (int i=0; i<nodeList.size()-1; i++) {
            if(nodeList.get(i).val>nodeList.get(i+1).val) {
                x=i;
                break;
            }
        }
        for (int i=nodeList.size()-1; i>0; i--) {
            if (nodeList.get(i).val<nodeList.get(i-1).val) {
                y=i;
                break;
            }
        }
  
        
            int tempVal=nodeList.get(x).val;
            nodeList.get(x).val=nodeList.get(y).val;
            nodeList.get(y).val=tempVal;
    }
    public static void sort(TreeNode root, LinkedList<TreeNode> nodeList) {
        if(root==null)
        return ;
        sort(root.left,nodeList);
        nodeList.add(root);
        sort(root.right,nodeList);
    }
        public static boolean isValid(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (s.length()%2 == 1) 
        return false;

        for (int i = 0; i<s.length(); ) {
            if ((s.substring(i,i+2) == "()")
            ||(s.substring(i,i+2) == "[]")
            ||(s.substring(i,i+2) == "{}"))
            i+=2;
            else 
                return false;
        }
        return true;
        
    }

    
    
    public static void main(String[] args) {
        Node n1 = new Node();
        n1.value = 1;

  Node n2 = new Node();
  n2.value = 2;

  Node n3 = new Node();
  n3.value=3;
  Node copy;
  
  n1.addToNeighbor(n2);
  n1.addToNeighbor(n3);
 
  
  copy = copyGraph(n1);
  Iterator it = copy.getNeighbors().iterator();
  while(it.hasNext())
  { Node nei;
    nei= (Node) it.next();
      System.out.println(nei.value);
  }
  
  System.out.println(copy.value);
  String pp="()";
  
  System.out.println(-1%2);
   System.out.println(-1/2);
  
 
 
        
    }
    
    
}