package coderust.misc;

import java.nio.ByteOrder;

public class HostEndianness {
	
	public static void main(String[] args) {
		
		System.out.println("Host endian of the system: "+ host_byte_order());
	}
	
	public static ByteOrder
	  host_byte_order() {
	    
	    return ByteOrder.nativeOrder();
	  }

}
