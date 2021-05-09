package com;

import java.time.LocalDate;

public class MasterCreditCard extends CreditCard {
    public MasterCreditCard(String CreditCardNumber, String HolderName, LocalDate ExpirationDate) {
	super(CreditCardNumber, HolderName, ExpirationDate);
    }

    public String getCardType() {
	return "Master";
    }
}
