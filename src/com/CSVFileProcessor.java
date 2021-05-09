package com;

import java.util.List;

public class CSVFileProcessor extends FileProcessor {

    public CSVFileProcessor(String InputFileName, String OutputFileName) {
        super(InputFileName, OutputFileName);
    }

    @Override
    public void readCreditCardRecords(List<CreditCard> cards) {
    }

    @Override
    public void writeCreditCardRecords(List<CreditCard> cards) {
    }
}
