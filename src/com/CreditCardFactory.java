package com;

import java.lang.IllegalArgumentException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class CreditCardFactory {
    private LocalDate checkExpirationDate(String ExpirationDate) {
	LocalDate expDate;
	try {
	    System.out.println("Expiration Date: " + ExpirationDate);
	    //	    expDate = LocalDate.parse(ExpirationDate, DateTimeFormatter.BASIC_ISO_DATE);
	    expDate = LocalDate.parse(ExpirationDate);
	    System.out.println("Parsing date done");
	} catch (Exception e) {
	    throw e;
	}

	return expDate;
    }

    private long checkCardNumber(String CreditCardNumber) {
	long number = 0;
	try {
	    number = Double.valueOf(CreditCardNumber).longValue();
	    int CardNumberLength = Long.toString(number).length();
	    if (CardNumberLength > 16) {
		throw new IllegalArgumentException("Card number is invalid");
	    }
	    return number;
	} catch (Exception e) {
	    throw e;
	}
    }

    public CreditCard getCreditCard(String CreditCardNumber, String HolderName, String ExpirationDate) {
	long number = 0;
	LocalDate expDate;
	try {
	    number = checkCardNumber(CreditCardNumber);
	} catch (Exception e) {
	    return new ErrorCreditCard(CreditCardNumber, HolderName, "Card number invalid");
	}
	try {
	    System.out.println("Checking Expiration Date: " + ExpirationDate);
	    expDate = checkExpirationDate(ExpirationDate);
	    System.out.println("Done Expiration Date");
	} catch (Exception e) {
	    return new ErrorCreditCard(CreditCardNumber, HolderName, "Expiration date invalid");
	}

	int cardNumLength = Long.toString(number).length();
	if (cardNumLength == 15) {
	    return new AmexCreditCard(CreditCardNumber, HolderName, ExpirationDate);

	} else if (cardNumLength == 16 &&
		   CreditCardNumber.charAt(0) == '5') {
	    return new MasterCreditCard(CreditCardNumber, HolderName, ExpirationDate);

	} else if (cardNumLength == 16 &&
		   CreditCardNumber.charAt(0) == '6') {
	    return new DiscoverCreditCard(CreditCardNumber, HolderName, ExpirationDate);

	} else if ((cardNumLength == 13 || cardNumLength == 16) &&
		   CreditCardNumber.charAt(0) == '4') {
	    return new VisaCreditCard(CreditCardNumber, HolderName, ExpirationDate);
	} 

	return new ErrorCreditCard(CreditCardNumber, HolderName, "Credit card type invalid");
    }
}
