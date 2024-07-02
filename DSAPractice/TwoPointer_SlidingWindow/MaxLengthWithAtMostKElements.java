package TwoPointer_SlidingWindow;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

public class MaxLengthWithAtMostKElements {

    public static int betterSolution(char[] chars, int k) {
        Map<Character, Integer> maxEle = new HashMap<>();
        int sp =0,ep=0,maxLen=0;
        while (ep<chars.length){
            maxEle.put(chars[ep], maxEle.getOrDefault(chars[ep],0)+1);
            while (maxEle.size()>k){
                maxEle.put(chars[sp], maxEle.getOrDefault(chars[sp],0)-1);
                if(maxEle.get(chars[sp])==0) {
                    maxEle.remove(chars[sp]);
                }
                sp++;
            }
            if(maxEle.size()<=k){
                maxLen = Math.max(maxLen, ep-sp+1);
            }
            ep++;
        }
        return maxLen;
    }

    public static int optimalSolution(char[] chars, int k) {
        Map<Character, Integer> maxEle = new HashMap<>();
        int sp =0,ep=0,maxLen=0;
        while (ep<chars.length){
            maxEle.put(chars[ep], maxEle.getOrDefault(chars[ep],0)+1);
            if (maxEle.size()>k){ // not letting the window size to decrease less than max length
                maxEle.put(chars[sp], maxEle.getOrDefault(chars[sp],0)-1);
                if(maxEle.get(chars[sp])==0) {
                    maxEle.remove(chars[sp]);
                }
                sp++;
            }
            if(maxEle.size()<=k){
                maxLen = Math.max(maxLen, ep-sp+1);
            }
            ep++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        char[] chars = {'a','a','a','b','b','c','c','c'};
        long start1 = System.nanoTime();
        System.out.println(betterSolution(chars, 2));
        long end1= System.nanoTime();

        long start2 = System.nanoTime();
        System.out.println(optimalSolution(chars, 2));
        long end2 = System.nanoTime();

        System.out.println("Better solution took ::"+ (end1-start1));
        System.out.println("Optimal solution took ::"+ (end2-start2));
    }
}
