package hacker.challenges;

import java.util.Scanner;

public class ValidateEmail {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String emailAddres = in.next();
		System.out.println(isEmailValid(emailAddres));
	}

	private static String isEmailValid(String email) {
		String domain = "hogwarts.com";
		String valid = "No";
		if(email!=null && email.length()>0){
			if(email.indexOf("@"+domain)!=-1){
				String[] arr = email.split("@");
				if(arr!=null && arr.length==2){
					if(arr[1].equals(domain) && arr[0].length()==5){
						String username = arr[0];
						for(int i=0;i<5;i++){
							if(!isSmallAlphaBet(username.charAt(i))) {
								valid = "No";
								break;
							}else{
								valid = "Yes";
							}
						}
					}
				}
			}
				
		}
		return valid;
	}
	
	public void test () {
		System.out.println("testing git commit and push");
	}

	private static boolean isSmallAlphaBet(char c) {
		if(c>='a' && c<='z')
		return true;
		return false;
	}

}
