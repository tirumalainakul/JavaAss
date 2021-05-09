package com;

public class CCApp {
    private String inFileName;
    private String outFileName;
    List<CreditCard> creditCards;
    
    public CCApp(String InputFileName, String OutputFileName) {
	inFileName = InputFileName;
	outFileName = OutputFileName;
    }
    
    public void run() {
	/* Instantiate file processor factory */
	FileProcessorFactory factory = new FileProcessorFactory();

	/* Create the appropriate file processor with the 
	   InputFileName */
	FileProcessor ccFileProcessor = 
	    factory.getFileProcessor(inFileName, outFileName);

	/* Process the Input file and create the credit 
	   card records*/
	ccFileProcessor.readCreditCardRecords(creditCards);
	
	/* Write records into output file specified 
	   in the outFileName */
	ccFileProcessor.writeCreditCardRecords(creditCards);
    }
}
