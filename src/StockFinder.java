import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import org.json.JSONObject;

public class StockFinder {
	final static String API_KEY = "VXEKOX43AVCUY84S";
	static String sym;

	
	public static String getingPriceFromAPI(String sym) throws MalformedURLException, IOException {
		String rootURL = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + sym + "&apikey=" + API_KEY;
		URL request = new URL(rootURL);
		InputStream openStream = request.openStream();
		String response = IOUtils.toString(openStream);
		// System.out.println(response);
		JSONObject root = new JSONObject(response);
		JSONObject quote = (JSONObject) root.get("Global Quote");
		String price = (String) quote.get("05. price");
		return price;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String priceFromAPI = getingPriceFromAPI("AMZN");
		System.out.println("The price of AMZN stock is " + priceFromAPI);
	}
}