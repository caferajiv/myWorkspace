package hacker.crackingcodinginterview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Ransom
{
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        int m = in.nextInt();
        int n = in.nextInt();
        
        String[] mag_words = new String[m];
        String[] msg_words = new String[n];
        for(int i=0;i<m;i++){
            mag_words[i] = in.next();
        }
        for(int i=0;i<n;i++){
            msg_words[i] = in.next();
        }
        
        System.out.println(canMakeRansomNote(mag_words,msg_words));
    }

    private static String canMakeRansomNote (String[] mag_words, String[] msg_words)
    {
        Map<String,Integer> map = new HashMap<>();
        for (String word: mag_words){
            if(map.get(word)!=null){
                map.put(word, map.get(word)+1);
            }else{
                map.put(word, 1);
            }
        }
        
        for(String word: msg_words){
            if(map.get(word)!=null && map.get(word)!=0){
                map.put(word, map.get(word)-1);
            }else{
                return "No";
            }
        }
        return "Yes";
    }

}