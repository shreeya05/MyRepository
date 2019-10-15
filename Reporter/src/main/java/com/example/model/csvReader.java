package com.example.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class csvReader {

	String responseString;

	public Iterator<User> responseGenerator(String fileName) throws IllegalStateException, InstantiationException,
			IllegalAccessException, CsvRequiredFieldEmptyException, IOException {

		CSVReader reader = new CSVReader(new FileReader(fileName), '\t');

		CsvToBean<User> csvToBean = new CsvToBeanBuilder(reader).withType(User.class).build();

		Iterator<User> csvUserIterator = csvToBean.iterator();

		return csvUserIterator;
	}
}
