package CurrencyHolder;

public class Account {

	private double cash = 10000;
	private double btc = 0;
	private double myBTCprice =0;

	private double percentChange = 0.02;

	public Account(double cash, PriceDay priceDay) {
		this.cash = cash;
		this.myBTCprice = priceDay.price;
		buyBTC(priceDay);
	}

	private void buyBTC(PriceDay priceDay) {
		btc += cash/priceDay.price;
		cash = 0;
		myBTCprice = priceDay.price;
	}

	private void sellBTC(PriceDay priceDay) {
		cash += btc*priceDay.price;
		btc = 0;
		myBTCprice = priceDay.price;
	}



	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	public double getMyBTCprice() {
		return myBTCprice;
	}

	public void setMyBTCprice(double myBTCprice) {
		this.myBTCprice = myBTCprice;
	}

	public void processNextDay(PriceDay nextPriceDay) {

		System.out.printf("(%.2f)Status: BTC: %.6f, cash: %.2f | %s \n",currentFiat(nextPriceDay),btc,cash, nextPriceDay);
		if(nextPriceDay.price < (myBTCprice*(1-percentChange))){
			sellBTC(nextPriceDay);
			return;
		}

		if(nextPriceDay.price > (myBTCprice*(1+percentChange))){
			buyBTC(nextPriceDay);
			return;
		}

		//if(nextPriceDay.price > myBTCprice)
		//	myBTCprice = nextPriceDay.price;
	}

	private double currentFiat(PriceDay priceDay){
		return cash + (btc*priceDay.price);
	}
}
