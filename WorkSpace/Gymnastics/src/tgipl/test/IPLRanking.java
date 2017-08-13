package tgipl.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IPLRanking {
	public static void main(String[] args) {
		int teams=7;
		String[] names={"Chargers","Royalchallengers","Superkings",
			"Knightriders","Indians","Warriors","Daredevils"};
		String[] sortedNames=team_name(teams, names);
		
		for(String name: sortedNames)
		{
			System.out.println(name);
		}
	}

	public static String[] team_name(int teams,String[] names)
    {
		//int max_size=names[0].length();
		List<String> capitalList = new ArrayList<String>();
		List<String> smallList = new ArrayList<String>();
		String[] iplRank = new String[0];
		for(String name: names)
		{
			if(checkIfNameContainsCapitalLetter(name))
			{
				capitalList.add(name);
			}
			else
			{
				smallList.add(name);
			}
			
		}
			Collections.sort(smallList);
			
			List<String> dupcapitalList = new ArrayList<String>();
			for(String s : capitalList)
			{
				for(int i=0;i<s.length();i++)
				{
					char c=s.charAt(i);
					if(c>=65 && c<=90)
					{
						if(dupcapitalList!=null && dupcapitalList.size()>i && dupcapitalList.get(i)!=null)
						{
							char b=dupcapitalList.get(i).charAt(i);
							if(c<b)
							{
								dupcapitalList.add(i,s);
								break;
							}
							else
							{
								dupcapitalList.add(i+1,s);
								break;
							}
						}
						else
						{
							dupcapitalList.add(dupcapitalList.size(),s);
							break;
						}
						
					}
				}
			}
			
			dupcapitalList.addAll(dupcapitalList.size(), smallList);
			
			iplRank = new String[dupcapitalList.size()];
			iplRank=dupcapitalList.toArray(iplRank);
			
		
		
		
        return iplRank;
    }

	

	private static boolean checkIfNameContainsCapitalLetter(String name) {
		boolean capitalPresent=false;
		for(char c : name.toCharArray())
		{
			if(c>=65 && c<=90)
			{
				capitalPresent=true;
			}
			
		}
		return capitalPresent;
	}
}
