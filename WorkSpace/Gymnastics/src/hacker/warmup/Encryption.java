package hacker.warmup;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Encryption {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String msg=null;
		try {
			msg = br.readLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			br.close();
		}
		
		msg = msg.replaceAll("\\s", "");
		System.out.println(msg);
		int length = msg.length();
		double root = Math.sqrt(length);
		int row = (int)Math.floor(root);
		int col  = (int)Math.ceil(root);
		
		if(!(row*col >= length)){
			row = col;
		}
			int index = 0;
			char[][] charArray = new char[row][col];
						
				for(int i=0;i<row;i++){
					for(int j=0;j<col;j++){
						charArray[i][j]='\0';
						if (index<length){
						char c = msg.charAt(index);
						charArray[i][j]=c;
						index++;
					}
				}
			}
				
				for(int i=0;i<col;i++){
					for(int j=0;j<row;j++){
						char a = charArray[j][i];
						if(a=='\0'){
							continue;
						}
						System.out.print(charArray[j][i]);
					}
					System.out.print(" ");
				}
			}	
			
			
		
				
		
	}


