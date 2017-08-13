package hackerearth.medlife;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class TestClass {
	
	public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
  *//*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);*/
        
        /*String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
        	strings[i] = br.readLine();
        }
      
        for(String s: strings){
        	int length = s.length();
        	int sum = (length*(length-1))/2;
        	System.out.println(sum);
        }*/
      
        
        //System.out.println("Hello World!");
		
		Scanner in = new Scanner(System.in);

		int totalNumbers = in.nextInt();

		Queue q= new Queue();
		//int[] a = new int[totalNumbers];
		
		for( int i=0;i<totalNumbers;i++){
			q.enqueue(in.nextInt());
		}
		
		int val = in.nextInt();
		
		if(val==1){
			q.enqueue(in.nextInt());
		}else if(val==0){
			q.dequeue();
		}
		
		q.showQueue();
		
    }
	
	static class Node {

		private Node nextNode;
		private int data;
		
		public Node(){
			
		}
		
		public Node(int data){
			this.data=data;
			
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}
		
		
		
	}
	
	static class Queue {
		
		private Node Front;
		private Node Rear;
		private int count;
		
		public Queue(){
			
		}
		public Queue(Node node){
			Front = node;
			Rear = node;
			count = 1;
		}
		public boolean isEmpty(){
			if(Rear!=null && Front!=null){
				return false;
			}
			return true;
		}
		
		public void enqueue(int data){
			Node node = new Node(data);
			if(isEmpty()){
				Front=node;
				Rear=node;
				count=1;
			}else{
				Rear.setNextNode(node);
				Rear=node;
				count++;
			}
		}
		
		public void enqueue(Node node){
			if(isEmpty()){
				Front=node;
				Rear=node;
				count=1;
			}else{
				Rear.setNextNode(node);
				Rear=node;
				count++;
			}
		}
		
		public Object dequeue(){
			int data=0;
			if(isEmpty()){
				System.out.println("Queue is Empty!!");
			}else{
				data=Front.getData();
				if(Front!=Rear){
					Front=Front.getNextNode();
				}else{
					Front=Rear=null;
				}
				count--;
			}
			return data;
		}
		
		public Node dequeueNode(){
			Node node= new Node();
			if(isEmpty()){
				System.out.println("Queue is Empty!!");
			}else{
				node=Front;
				if(Front!=Rear){
					Front=Front.getNextNode();
				}else{
					Front=Rear=null;
				}
				count--;
			}
			return node;
		}
		
		
		public void showQueue(){
			if(isEmpty()){
				System.out.println("Queue is Empty!!");
			}else{
				Node node= new Node();
				node=Front;
				while(node.getNextNode()!=null){
					System.out.print(node.getData());
					node=node.getNextNode();
				}
				System.out.println(node.getData());
			}
		}

	}

}
