package com;

import java.time.LocalDate;

public class ErrorCreditCard extends CreditCard {
    private String ErrorReason;
    private static final LocalDate ErrorDate = LocalDate.of(0,0,0);
    public ErrorCreditCard(String CreditCardNumber, String HolderName, String ErrorReason) {
	super(CreditCardNumber, HolderName, ErrorDate);
	this.ErrorReason = ErrorReason;
    }
    public String getCardType() {
	return "Error:" + ErrorReason;
    }
}
