package com.alura.hotelalura.model;

public class Reserve {

	private Integer id;
	private Integer guestId;
	private String dateIn;
	private String dateOut;
	private String price;
	private String paymentMethod;

	public Reserve(Integer guestId, String dateIn, String dateOut, String price, String paymentMethod) {
		super();
		this.guestId = guestId;
		this.dateIn = dateIn;
		this.dateOut = dateOut;
		this.price = price;
		this.paymentMethod = paymentMethod;
	}

	public Integer getId() {
		return id;
	}

	public Integer getGuestId() {
		return guestId;
	}

	public String getDateIn() {
		return dateIn;
	}

	public String getDateOut() {
		return dateOut;
	}

	public String getPrice() {
		return price;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setGuestId(Integer guestId) {
		this.guestId = guestId;
	}

}
