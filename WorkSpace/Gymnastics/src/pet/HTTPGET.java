package pet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HTTPGET {
	
	public static void main(String[] args) {
		
		
		try {
			URL url = new URL("http://services.odata.org/V3/Northwind/Northwind.svc/");
			HttpURLConnection conn;
			conn = (HttpURLConnection)url.openConnection();
			conn.setRequestProperty("Accept", "application/json");
			
			InputStream is = conn.getInputStream();
			
			String response = getStringFromInputStream(is);
			System.out.println(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String getStringFromInputStream(InputStream is) {

		StringBuilder sb = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new InputStreamReader(is));) {
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} 

		return sb.toString();

	}

}


