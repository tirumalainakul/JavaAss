package com;

import java.time.LocalDate;

public class VisaCreditCard extends CreditCard {
    public VisaCreditCard(String CreditCardNumber, String HolderName, LocalDate ExpirationDate) {
	super(CreditCardNumber, HolderName, ExpirationDate);
    }

    public String getType() {
	return "Visa";
    }
}
