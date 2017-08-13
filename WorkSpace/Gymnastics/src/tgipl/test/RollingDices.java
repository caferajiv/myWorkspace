package tgipl.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RollingDices {
	
	public static void main(String[] args) {
	
		String player1="{12, 11, 5, 2, 7, 5, 11}";
		String player2="{5, 12, 5, 7, 11, 2, 11}";
		System.out.println(lucky_player(player1, player2));
	}

	public static String lucky_player(String player1,String player2)
    {
        String luck="Lucky";//Lucky/Unlucky
        
        List<Integer> player1_score=getPlayerScore(player1);
        List<Integer> player2_score=getPlayerScore(player2);
        if(player1_score.size()!=player2_score.size())
        {
        	return "Unlucky";
        }
        else
        {
        	for(int i=0;i<player1_score.size();i++)
        	{
        		if(!(player1_score.get(i).equals(player2_score.get(i))))
        		{
        			return "Unlucky";	
        		}
        	}
        }
        
        
        return "Lucky";
    }

	private static List<Integer> getPlayerScore(String player1) {
		List<Integer> list= new ArrayList<Integer>();
		player1= player1.replace("{", "");
		player1= player1.replace("}", "");
		String[] score_array=player1.split(",");
		for(String s: score_array)
		{
			int score=Integer.parseInt(s.trim());
			list.add(score);
		}
		Collections.sort(list);
		return list;
	}
}
