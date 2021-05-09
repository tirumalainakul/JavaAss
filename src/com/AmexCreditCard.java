package com;

import java.time.LocalDate;

public class AmexCreditCard extends CreditCard {
    public AmexCreditCard(String CreditCardNumber, String HolderName, LocalDate ExpirationDate) {
	super(CreditCardNumber, HolderName, ExpirationDate);
    }

    @Override 
    public String getType() {
	return "AmericanExpress";
    }
}
