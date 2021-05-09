package com;

import java.lang.IllegalArgumentException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.*;

public class CreditCardFactory {
    private void checkExpirationDate(String ExpirationDate) {
	List<String> valuesList = 
	    Arrays.asList(ExpirationDate.split("/", -1));
	if (valuesList.size() != 3) {
	    throw new IllegalArgumentException("Date is invalid");
	}
	
	int month = Integer.parseInt(valuesList.get(0));
	int day = Integer.parseInt(valuesList.get(1));
	int year = Integer.parseInt(valuesList.get(2));
	
	String monthStr = "";
	String dayStr = "";
	String yearStr = "";

	/* Append leading zeros so that the day, month 
	   and year are in the correct "mm/dd/yyyy" format */
	if (month < 10) {
	    monthStr = monthStr + "0";
	}
	monthStr += String.valueOf(month);
	if (day < 10) {
	    dayStr = day + "0";
	}
	dayStr += String.valueOf(day);
	if (year < 10) {
	    yearStr = yearStr + "000";
	} else if (year < 100) {
	    yearStr = yearStr + "00";
	} else if (year < 1000) {
	    yearStr = yearStr + "0";
	}
	yearStr += String.valueOf(year);
	String formattedDate = monthStr + "/" + dayStr + "/" + yearStr;
	System.out.println("Formatted date: " + formattedDate);
	try {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	    LocalDate expDate = LocalDate.parse(formattedDate, formatter);
	} catch (Exception e) {
	    throw new IllegalArgumentException("Date is invalid: " + e);
	}
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
	System.out.println("In getCreditCard Processing: " + CreditCardNumber + " " + HolderName + " " + ExpirationDate);
	try {
	    number = checkCardNumber(CreditCardNumber);
	} catch (Exception e) {
	    return new ErrorCreditCard(CreditCardNumber, HolderName, "Card number invalid");
	}
	System.out.println("Check card number complete");
	/*
	-- ENABLE THIS IF EXPIRATION DATE CHECKING IS NEEDED --
	try {
	    System.out.println("Checking Expiration Date: " + ExpirationDate);
	    checkExpirationDate(ExpirationDate);
	    System.out.println("Done Expiration Date");
	} catch (Exception e) {
	    return new ErrorCreditCard(CreditCardNumber, HolderName, "Expiration date invalid");
	}
	System.out.println("Check expiration date complete");
	*/
	int cardNumLength = Long.toString(number).length();
	System.out.println("Card Number of length: " + cardNumLength);

	if (cardNumLength == 15) {
	    System.out.println("Creating Amex card");
	    return new AmexCreditCard(CreditCardNumber, HolderName, ExpirationDate);

	} else if (cardNumLength == 16 &&
		   CreditCardNumber.charAt(0) == '5') {
	    System.out.println("Creating Master card");
	    return new MasterCreditCard(CreditCardNumber, HolderName, ExpirationDate);

	} else if (cardNumLength == 16 &&
		   CreditCardNumber.charAt(0) == '6') {
	    System.out.println("Creating Discover card");
	    return new DiscoverCreditCard(CreditCardNumber, HolderName, ExpirationDate);

	} else if ((cardNumLength == 13 || cardNumLength == 16) &&
		   CreditCardNumber.charAt(0) == '4') {
	    System.out.println("Creating Visa card");
	    return new VisaCreditCard(CreditCardNumber, HolderName, ExpirationDate);
	} 

	return new ErrorCreditCard(CreditCardNumber, HolderName, "Credit card type invalid");
    }
}
