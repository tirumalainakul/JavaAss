package com;

import java.time.LocalDate;

public class ErrorCreditCard extends CreditCard {
    private String ErrorReason;
    public ErrorCreditCard(String CreditCardNumber, String HolderName, 
			   String ErrorReason) {
	super(CreditCardNumber, HolderName, "");
	this.ErrorReason = ErrorReason;
    }
    public String getType() {
	return "Error";
    }
}
