package pet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class HTTPGET {
	
	public static void main(String[] args) {
		
		
		try {
			URL url = new URL("http://services.odata.org/V3/Northwind/Northwind.svc/");
			HttpURLConnection conn;
			conn = (HttpURLConnection)url.openConnection();
			conn.setRequestProperty("Accept", "application/json");
			String res = conn.getResponseMessage();
			InputStream is = conn.getInputStream();
			//InputStreamReader isr = new InputStreamReader(is);
			String response = getStringFromInputStream(is);
			System.out.println(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}

}


