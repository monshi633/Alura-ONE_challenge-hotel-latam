package utils;

import java.math.BigDecimal;

public class ReservePrice {

	BigDecimal dayPrice = new BigDecimal("420.69");
	Integer days;
	BigDecimal totalPrice;
	
	public ReservePrice(Integer days) {
		this.days = days;
	}

	public BigDecimal getTotalPrice() {
		if (days == 0) {
			totalPrice = dayPrice;
		} else {
			totalPrice = new BigDecimal(days).multiply(dayPrice);
		}
		return totalPrice;
	}
}