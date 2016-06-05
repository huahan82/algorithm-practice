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
public class LadderLength {
     public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int count=0;
     
        Set<String> begin = new HashSet<String>();
        Set<String> end = new HashSet<String>();
        Set<String> next;
        //Set<String> map = new HashSet<String>();
        
        begin.add(beginWord);
        end.add(endWord);
        while(true) {
            if(begin.size()>end.size())
            {
                Set<String> temp = begin;
                begin = end;
                end = temp;
            }
            next = new HashSet<String>();
            count++;
            System.out.println("begin set: ");
            for (String word:begin) {
                System.out.println(word);
                if (end.contains(word))
                    return count;
                else {
                    for (String diffWord: oneCharDiff(word)) {
                        //if (wordList.contains(diffWord)&&!map.contains(diffWord)) {
                         if (wordList.contains(diffWord)) {
                            next.add(diffWord);
                            //map.add(diffWord);
                    }}
                }
            }
            if (next.size()==0) return 0;
            else begin = next;
        }
    }
    public static Set<String> oneCharDiff(String first) {
        int length=first.length();
        char[] ch = first.toCharArray();
        Set<String> diff = new HashSet<String>();
        String s;
 
        for (int i=0;i<length;i++) {
            char tem = ch[i];
            for (char c='a'; c<='z';c++) {
                ch[i]=c;
                if (ch[i]!=tem)
                diff.add(new String(ch));
            }
            ch[i]=tem;
      
        }
        return diff;
    }
    
    public static void main(String[] args) {
        String beginWord = "zings";
        String endWord = "Brown";
        Set<String> wordList = new HashSet<String>();
        beginWord = "hit";
        endWord = "cog";
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("chump");
        wordList.add("sours");
        wordList.add("mcgee");
        wordList.add("piers");
        wordList.add("match");
        wordList.add("folds");
        wordList.add("rinse");
        wordList.add("films");
        wordList.add("small");
        wordList.add("umbel");
        wordList.add("assad");
        System.out.println(ladderLength(beginWord, endWord, wordList));
        
                
        
    }
    
    
}
