package CurrencyHolder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class PriceDay {

	LocalDate dateTime;
	double price;
	public PriceDay(String time, String price) {
		if(time.length() > 10){
			time = time.substring(1);
		}

		final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.dateTime = LocalDate.parse(time, dateTimeFormatter);
		this.price = Double.parseDouble(price);
	}

	@Override
	public String toString() {
		return "{" +
				"dateTime=" + dateTime +
				", price=" + price +
				'}';
	}
}
