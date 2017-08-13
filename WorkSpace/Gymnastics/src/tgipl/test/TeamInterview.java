package tgipl.test;

import java.util.HashMap;
import java.util.Map;

public class TeamInterview {

	public static void main(String[] args) {
		int questions=2;
		int people=4;//(1,2),(1,-2),(-1,-2), (-1,2)
		String[] ans ={"1#2","1#-2","-1#-2","-1#2"};
		System.out.println(get_responce(questions,people,ans));
		
	}
	
	public static String get_responce(int questions,int people,String[] ans)
    {
		Map<Integer,Boolean> map= new HashMap<Integer, Boolean>();
		for (int i=1;i<=questions;i++)
		{
			map.put(i, null);
		}
		
		verifyOnce(ans, map);
		verifyTwice(ans, map);
		boolean response=verifyThrice(ans, map);
		if(!response)
		{
			return "Yes";
		}
        return "No";
    }

	private static boolean verifyThrice(String[] ans, Map<Integer, Boolean> map) {
		boolean changed=false;
		for (String answer: ans)
		{
			String[] a = answer.split("#");
			
				int q1 = Integer.parseInt(a[0]);
				int q2 = Integer.parseInt(a[1]);
				
				if(q1>0 && q2>0)
				{
					if(map.get(q1)==true || map.get(q2)==true)
					{
						continue;
					}
					else
					{
						changed=true;
						break;
					}
						
				}
				else if(q1>0 && q2<0)
				{
					q2=q2*-1;
					if(map.get(q1)==true || map.get(q2)==false)
					{
						continue;
					}
					else
					{
						changed=true;
						break;
					}
				}
				else if(q1<0 && q2>0)
				{
					q1=q1*-1;
					if(map.get(q1)==false || map.get(q2)==true)
					{
						continue;
					}
					else
					{
						changed=true;
						break;
					}
				}
				else if(q1<0 && q2<0)
				{
					q1=q1*-1;
					q2=q2*-1;
					if(map.get(q1)==false || map.get(q2)==false)
					{
						continue;
					}
					else
					{
						changed=true;
						break;
					}
				}
			}
		
		return changed;
	}

	private static void verifyTwice(String[] ans, Map<Integer, Boolean> map) {
		for (String answer: ans)
		{
			String[] a = answer.split("#");
			
				int q1 = Integer.parseInt(a[0]);
				int q2 = Integer.parseInt(a[1]);
				
				if(q1>0 && q2>0)
				{
					if(map.get(q1)==true || map.get(q2)==true)
					{
						continue;
					}
					else
					{
						map.put(q2, true);
					}
						
				}
				else if(q1>0 && q2<0)
				{
					q2=q2*-1;
					if(map.get(q1)==true || map.get(q2)==false)
					{
						continue;
					}
					else
					{
						map.put(q2, false);
					}
				}
				else if(q1<0 && q2>0)
				{
					q1=q1*-1;
					if(map.get(q1)==false || map.get(q2)==true)
					{
						continue;
					}
					else
					{
						map.put(q2, true);
					}
				}
				else if(q1<0 && q2<0)
				{
					q1=q1*-1;
					q2=q2*-1;
					if(map.get(q1)==false || map.get(q2)==false)
					{
						continue;
					}
					else
					{
						map.put(q2, false);
					}
				}
			}
	}

	private static void verifyOnce(String[] ans, Map<Integer, Boolean> map) {
		for (String answer: ans)
		{
			String[] a = answer.split("#");
			
				int q1 = Integer.parseInt(a[0]);
				int q2 = Integer.parseInt(a[1]);
				//first assign the value if not already assigned
				assignInitialValue(map,q1);
				assignInitialValue(map,q2);
				
				if(q1>0 && q2>0)
				{
					if(map.get(q1)==true || map.get(q2)==true)
					{
						continue;
					}
					else
					{
						map.put(q1, true);
					}
						
				}
				else if(q1>0 && q2<0)
				{
					q2=q2*-1;
					if(map.get(q1)==true || map.get(q2)==false)
					{
						continue;
					}
					else
					{
						map.put(q1, true);
					}
				}
				else if(q1<0 && q2>0)
				{
					q1=q1*-1;
					if(map.get(q1)==false || map.get(q2)==true)
					{
						continue;
					}
					else
					{
						map.put(q1, false);
					}
				}
				else if(q1<0 && q2<0)
				{
					q1=q1*-1;
					q2=q2*-1;
					if(map.get(q1)==false || map.get(q2)==false)
					{
						continue;
					}
					else
					{
						map.put(q1, false);
					}
				}
			}
	}

	private static void assignInitialValue(Map<Integer, Boolean> map, int q) {
		if(q<0)
			q=q*-1;
		if(map.get(q)==null)
		{
			if(q>0)
			{
				map.put(q, true);
			}
			else
			{
				q=q*-1;
				map.put(q, false);
			}
		}
		
	}
}
