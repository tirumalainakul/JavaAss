package com;

abstract class CreditCard {
    private String cardNumber;
    private String holderName;
    private String expirationDate;
    
    public CreditCard(String cardNumber, String holderName, String expirationDate) {
	this.cardNumber = cardNumber;
	this.holderName = holderName;
	this.expirationDate = expirationDate;
    }
    
    abstract public String getType();

    public String getNumber() {
	return cardNumber;
    }
    public String getErrorReason() {
	return "";
    }
}
