
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MakeMeRich {
	public static final List<String> symbols = Arrays.asList("AMD", "HPQ", "IBM", "AMZN");
//			"TXN", "VMW", "XRX", "AAPL", "ADBE",
//			"AMZN", "CRAY", "CSCO", "SNE", "GOOG", "INTC", "INTU", "MSFT", "ORCL", "TIBX", "VRSN", "YHOO");

	public static void main(String[] args) throws MalformedURLException, IOException {

		// 1. Print these symbols using a Java 8 for-each and lambdas
		symbols.stream().forEach(sym -> System.out.println(sym));

		// 2. print the price of Bitcoin
		System.out.println("the price of a Bitcoin is " + StockFinder.getingPriceFromAPI("BTC-USD"));

		// 3. Create a new List of StockInfo that includes the stock price

		List<StockInfo> list = new ArrayList<StockInfo>();
		for (String i : symbols) {
			list.add(new StockInfo(i, Double.parseDouble(StockFinder.getingPriceFromAPI(i))));

		}
		System.out.println(list.toString());

		// 4. Find the highest-priced stock under $500

		List<StockInfo> list1 = new ArrayList<StockInfo>();
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).price < 500) {
				list1.add(list.get(i));
			}
		}

		Collections.sort(list1, (s1, s2) -> (int) s2.price - (int) s1.price);

		System.out.println("the highest priced stock under 500$ is: " + list1.get(0));

	}

}
