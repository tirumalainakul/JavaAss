package com;

import java.time.LocalDate;

public class DiscoverCreditCard extends CreditCard {
    public DiscoverCreditCard(String CreditCardNumber, String HolderName, LocalDate ExpirationDate) {
	super(CreditCardNumber, HolderName, ExpirationDate);
    }

    public String getCardType() {
	return "Discover";
    }
}
