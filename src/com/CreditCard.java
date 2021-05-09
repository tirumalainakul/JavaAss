package com;

import java.time.LocalDate;

abstract class CreditCard {
    private String cardNumber;
    private String holderName;
    private LocalDate expirationDate;
    
    public CreditCard(String cardNumber, String holderName, LocalDate expirationDate) {
	this.cardNumber = cardNumber;
	this.holderName = holderName;
	this.expirationDate = expirationDate;
    }
    
    abstract String getCardType();
}
