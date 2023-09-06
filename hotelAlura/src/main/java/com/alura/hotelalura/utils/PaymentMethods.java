package com.alura.hotelalura.utils;

public enum PaymentMethods {
	CREDIT_CARD("Tarjeta de crédito"),
	DEBIT_CARD("Tarjeta de débito"),
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
