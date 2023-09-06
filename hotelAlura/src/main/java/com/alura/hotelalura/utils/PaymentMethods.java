package com.alura.hotelalura.utils;

public enum PaymentMethods {
	CREDIT_CARD("Tarjeta de cr�dito"),
	DEBIT_CARD("Tarjeta de d�bito"),
	CASH("Dinero en efectivo"),
	BITCOIN("Bitcoin");
	
	private final String displayName;

    PaymentMethods(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
    
    @Override
    public String toString() {
    	return displayName;
    }
}
