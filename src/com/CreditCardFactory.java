package com;

import java.lang.IllegalArgumentException;

public class CreditCardFactory {
    public CreditCard getCreditCard(String CreditCardNumber, String HolderName, String ExpirationDate) {
	try {
	    long number = Double.valueOf(CreditCardNumber).longValue();
	    String value = Long.toString(number);
	} catch (Exception e) {
	    return new ErrorCard(CreditCardNumber, HolderName);
	}
	    if (value.length() <= 16) {

	    if (value.length() == 15) {
		return new AmericanExpressCard(card_number);

	    } else if (value.length() == 16 && value.charAt(0) == '5') {
		return new MasterCard(card_number);

	    } else if (value.length() == 16 && value.charAt(0) == '6') {
		return new Discover(card_number);

	    } else if ((value.length() == 13 || value.length() == 16) && value.charAt(0) == '4') {
		return new Visa(card_number);

	    } else {
		return null;
	    }

	}
    }
}
