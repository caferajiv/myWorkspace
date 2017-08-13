package tgipl.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestFileReading {
	
	public static void main(String[] args) {
		
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("rajiv",1);
		System.out.println(map);
		map.put("rajiv", 3);
		System.out.println(map);
		
		
		try {
			countUniqueWords("C://rajiv.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int countChars(String fileName) throws IOException {
	    FileReader fileReader = new FileReader(fileName);
	    char[] cbuf = new char[1];
	    int n = 0;

	    while(fileReader.read(cbuf)!=-1) {
	        if(cbuf[0] == 'a') {
	            n++;
	        }
	    }
	    fileReader.close();
	    return n;
	}
	
	public static void countUniqueWords(String fileName) throws IOException {
	    FileReader fileReader = new FileReader(fileName);
	    BufferedReader br = new BufferedReader(fileReader);
	    Map<String, Integer> wordsMap=new HashMap<String, Integer>();
	    String line = "";
	    int count=0;
	    while(null!=(line=br.readLine()))
	    {
	    	String[] arrString = line.split(" ");
	    	for(String s : arrString)
	    	{
	    		if(null!= s && s.length()>1)
	    		{
	    			if(s.endsWith(",")||s.endsWith(".")||s.endsWith(";"))
	    			{
	    				s=s.substring(0,s.length()-1);
	    			}
					if (null != wordsMap.get(s)) {
						count = wordsMap.get(s);
					} else {
						count = 0;
					}
					wordsMap.put(s, ++count);
				}
	    	}
	    }
	    
	    System.out.println(wordsMap);
	}

}
