import java.util.Scanner;


public class Exercise1 {
	
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		String line= "raj iv  is a 	good	 boy\n\nhhh  fg  ";//sc.nextLine();
		
		System.out.println(line);
		boolean flag = false;
		
		if(line.indexOf("\n")!=-1){
			line=line.replaceAll("\n", " ");
			
		}
		if(line.indexOf("\t")!=-1){
			line=line.replaceAll("\t", " ");
		}
		//if(line.indexOf(" ")!=-1){
		//	flag=true;
		//}
		//StringBuffer line= new StringBuffer(line1);
		System.out.println(line);
		for (int i=0;i<line.length();i++){
			if(line.charAt(i)==' '){
				//System.out.println(line);
				if(flag==true){
					//line.replace(" " , "");
					line= line.substring(0,i)+line.substring(i+1,line.length());
					//line.setCharAt(i, '\u0000');
					System.out.println(line);
				}else{
					flag=true;
				}
				}else{
					
					flag=false;
				}
			}
			
		
		
		System.out.println(line);
	}

}
