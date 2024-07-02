package TwoPointer_SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaxLengthWithAtMostKElements {

    public static int solve(char[] chars, int k) {
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

    public static void main(String[] args) {
        char[] chars = {'a','a','a','b','b','c'};
        System.out.println(solve(chars, 2));
    }
}
