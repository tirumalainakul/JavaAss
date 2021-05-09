package com;

import java.util.List;

abstract class FileProcessor {
    private String inFileName;
    private String outFileName;
    
    public FileProcessor(String InputFileName, String OutputFileName) {
	inFileName = InputFileName;
	outFileName = OutputFileName;
    }
    
    abstract public void readCreditCardRecords(List<CreditCard> cards);
    abstract public void writeCreditCardRecords(List<CreditCard> cards);
}

