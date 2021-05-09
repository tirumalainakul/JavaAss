package com;

import java.lang.IllegalArgumentException;

public class FileProcessorFactory {
    private static final String UNKNOWN_EXTENSION="unknown";
    private static final String CSV_EXTENSION="csv";
    private String getLowerCaseExtension(String fileName) {
	int dotIdx = fileName.lastIndexOf(".");
	if (dotIdx == -1) {
	    return UNKNOWN_EXTENSION;
	}
	String ext = fileName.substring(dotIdx + 1).toLowerCase();
	return ext;
    }
    public FileProcessor getFileProcessor(String inFileName, String outFileName) {
	String inExt = getLowerCaseExtension(inFileName);
	String outExt = getLowerCaseExtension(outFileName);
	if (!inExt.equals(outExt)) {
	    System.out.println("Please enter the same type of files.");
	}
	FileProcessor processor;
	if (inExt.equals(CSV_EXTENSION)) {
	    processor = new CSVFileProcessor(inFileName, outFileName);
	} else {
	    processor = new InvalidFileProcessor(inFileName, outFileName);
	    throw new IllegalArgumentException(inExt + " is not a supported file type");
	}
	return processor;
    }
}
