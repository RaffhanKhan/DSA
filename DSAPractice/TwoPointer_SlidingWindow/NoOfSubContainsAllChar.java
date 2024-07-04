package TwoPointer_SlidingWindow;

//---------Number of substring contains all character (a,b,c) -----------//

import java.util.HashSet;

public class NoOfSubContainsAllChar {

    public static int bruthForceSolution(String s) {
        int c=0;
        for (int i = 0; i < s.length()+1 ; i++){
            for (int j=i; j<s.length()+1; j++){
                String temp = s.substring(i,j);
                if(temp.contains("a") && temp.contains("b") && temp.contains("c")){
                    c++;
                }
            }
        }
        return c;
    }

    public static int bruthForceSolutionWithHash(String s) {

        int c=0;
        HashSet<Character> characters = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            for (int j=i; j<s.length(); j++){
                characters.add(s.charAt(j));
                if(characters.contains('a') && characters.contains('b') && characters.contains('c')){

                    c++;
                }
            }
            characters.clear();

        }
        return c;
    }

    private static int betterSolution(String s) {
        if(s.length()<3){
            return 0;
        }

        int[] lastseen = {-1,-1,-1};
        int c=0;
        for(int i=0; i<s.length(); i++){
            lastseen[s.charAt(i)-'a'] = i;
            if(lastseen[0]!=-1 && lastseen[1]!=-1 && lastseen[2]!=-1){
                c=c+(1+Math.min(lastseen[0],Math.min(lastseen[1],lastseen[2])));

            }
        }

        return c;
    }


    public static void main(String[] args) {
//        String s = "bbacba";
        String s = "ababbbc";

        System.out.println(bruthForceSolution(s));
        System.out.println(bruthForceSolutionWithHash(s));
        System.out.println(betterSolution(s));
    }


}
