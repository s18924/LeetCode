package CurrencyHolder;

public class DownspikesMinimizer {
	public static void main(String[] args) {

		BTC btc = new BTC("src/main/resources/btc_price.csv");
		Account account = new Account(10000, btc.getNextPriceDay());

		PriceDay priceDay = null;
		while ((priceDay = btc.getNextPriceDay()) != null)
			account.processNextDay(priceDay);

	}
}
