package CurrencyHolder;

import javax.swing.*;

public class Account {


	private double cash = 10000;
	private double btc = 0;
	private double myBTCprice = 0;
	private double rebuyPrice = 0;
	private boolean hold = true;

	private double percentChange = 0.05;
	private Visualizer visualizer;

	public Account(double cash, PriceDay priceDay) {
		this.cash = cash;
		this.myBTCprice = priceDay.price;
		buyBTC(priceDay);
		SwingUtilities.invokeLater(()->visualizer = new Visualizer());

	}

	private void buyBTC(PriceDay priceDay) {
		btc += cash / priceDay.price;
		cash = 0;
		myBTCprice = priceDay.price;
		hold = true;
	}

	private void sellBTC(PriceDay priceDay) {
		cash += btc * priceDay.price;
		btc = 0;
		myBTCprice = priceDay.price;
		rebuyPrice = priceDay.price;
		hold = false;
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

		visualizer.paint

		System.out.printf("(%.2f)Status: BTC: %.6f, cash: %.2f | %s \n", currentFiat(nextPriceDay), btc, cash, nextPriceDay);
		if (nextPriceDay.price < (myBTCprice * (1 - percentChange)) && hold) {
			sellBTC(nextPriceDay);
			return;
		}

		/*if(nextPriceDay.price > (myBTCprice*(1+percentChange))){
			buyBTC(nextPriceDay);
			return;
		}*/
		if (nextPriceDay.price > rebuyPrice) {
			buyBTC(nextPriceDay);
			return;
		}

		/*if (nextPriceDay.price > myBTCprice && !hold)
			myBTCprice = nextPriceDay.price;*/
	}

	private double currentFiat(PriceDay priceDay) {
		return cash + (btc * priceDay.price);
	}
}
