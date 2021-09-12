package CurrencyHolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class BTC {

	private double price = 50000;
	private List<PriceDay> priceDayList;

	public BTC(String fileName) {
		readDataFromCSV(fileName);
	}

	public PriceDay getNextPriceDay() {
		if (priceDayList.size() > 0)
			return priceDayList.remove(0);
		else return null;
	}

	private void readDataFromCSV(String fileName) {
		try {
			priceDayList =
					Files.readAllLines(Path.of(fileName))
							.stream()
							.map(singleLine -> {
								String[] splittedLine = singleLine.split(",");
								return new PriceDay(splittedLine[0].split(" ")[0], splittedLine[1]);
							}).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new BTC("src/main/resources/btc_price.csv");
	}


}
