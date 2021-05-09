package com;

import java.util.Date;

abstract class CreditCard {
    private String cardNumber;
    private String holderName;
    private Date expirationDate;
    
    public CreditCard(String cardNumber, String holderName, Date expirationDate) {
	this.cardNumber = cardNumber;
	this.holderName = holderName;
	this.expirationDate = expirationDate;
    }
    
    abstract String getCardType();
}
