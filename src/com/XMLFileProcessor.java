package com;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.parser.*;


public class JSONFileProcessor extends FileProcessor {
    private CreditCardFactory cardFactory;
    private JSONArray jsonObjects;

    public JSONFileProcessor(String InputFileName, String OutputFileName) {
        super(InputFileName, OutputFileName);
	cardFactory = new CreditCardFactory();
	jsonObjects = new JSONArray();
    }

    @Override
    public void readCreditCardRecords(List<CreditCard> cards) {
	/* Get all the lines from the input file */
	getJSONObjectsFromFile();

	if (inputLines.size() == 0) {
	    /* TODO: Add an error message here */
	    return;
	}

	/* Convert all lines to credit cards */
	processLinesToCards(cards);
    }

    @Override
    public void writeCreditCardRecords(List<CreditCard> cards) {
	try {
	    FileWriter outFile = new FileWriter(outFileName);
	    /* Write the title here */
	    outFile.write("CardNumber,CardType,Error\n");
	    Iterator<CreditCard> cardIterator = cards.iterator();
	    while (cardIterator.hasNext()) {
		CreditCard card = cardIterator.next();
		String cardString;
		String cardNumber = card.getNumber();
		String cardType = card.getType();
		String cardErrorReason = card.getErrorReason();
		cardString = 
		    (cardNumber + "," + 
		     cardType + "," + 
		     cardErrorReason + "\n");
		outFile.write(cardString);
	    }
	    outFile.close();
	} catch (Exception e) {
	    System.out.println("Error: Exception in writing to file");
	}
    }

    private void getJSONObjectsFromFile() {
	JSONParser jsonParser = new JSONParser();
	
        try (FileReader reader = new FileReader(inFileName))
        {
            Object obj = jsonParser.parse(reader);
            jsonObjects = (JSONArray) obj;
        } catch (FileNotFoundException e) {
	    System.out.println("Error: File " + inFileName + " could not be found");
        } catch (ParseException e) {
	    System.out.println("Error: JSON parse failure: " + e);
        } catch (Exception e) {
	    System.out.println("Error: Other exception found: " + e);
	}
    }

    private void processJSONObjects(List<CreditCard> cards) {
	int objectCount = 0;
	try {
	    for (int idx = 0; idx < jsonObjects.length(); idx++) {
		JSONObject jsonObj = jsonObjects.getJSONObject(idx);
		String CreditCardNumber = jsonObj.get("CardNumber").toString();
		String ExpirationDate = jsonObj.get("ExpirationDate").toString();
		String ExpirationDate = jsonObj.get("NameOfCardholder").toString();
		CreditCard creditCard = 
		    cardFactory.getCreditCard(CreditCardNumber, HolderName, ExpirationDate);
		cards.add(creditCard);
		objectCount++;
	    }
	} catch (Exception e) {
	    System.out.println("Error: Object number " + objectCount + "has an error");
	}
    }
}
