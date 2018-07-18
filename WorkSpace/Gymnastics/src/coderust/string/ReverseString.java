package coderust.string;

public class ReverseString {
	
	public static void main(String[] args) {
		
		String input = "Quick brown fox jumped over the lazy dog.";
		reverse_words(input.toCharArray());
		
	}
	
	public static void reverse_words (char[] sentence) {
	    //Quick brown fox jumped over the lazy dog
	    //dog lazy the over jumped fox brown Quick
	    int start = 0;
	    int end = 0;
	    
	    for(char c : sentence){
	    System.out.print(c);
	    }
	    for(int i=0;i<sentence.length;i++){
	       
	      char c  = sentence[i];
	      if(c==' ' || c=='\0') {
	        end = i-1;
	        reverse(sentence, start, end);
	        start = i+1;
	      }else if(i==sentence.length-1) {
	    	  reverse(sentence, start, i);
	      }
	      
	    }
	    
	    System.out.println();
	    reverse(sentence, 0, sentence.length-1);
	    
	    for(char c : sentence){
	    System.out.print(c);
	    }
	    
	  } 
	  
	  private static void reverse(char[] arr, int i, int j) {
	  
	    for(;i<j;i++,j--){
	    char temp = arr[i];
	      arr[i] = arr[j];
	      arr[j] = temp;
	    }
	  }

}
