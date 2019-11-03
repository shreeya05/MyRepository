package RmsCompare;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;

import com.opencsv.CSVReader;

public class fileReader {

	@Autowired
	CSVReader csvReader;
	Reader reader;

	
	public fileReader() {
		
	}
	public fileReader(String fileName) {
		try {
			reader = Files.newBufferedReader(Paths.get(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		csvReader = new CSVReader(reader);

	}

	public String[] csvFileHeader() {
		String[] headerString = null;
		
		try {
			headerString = csvReader.readNext();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return headerString;
	}
	
	
	public String rmsCompare() {
		boolean fail=false;
		String display="mach successfully..........";

		String[] omneReadArray, omneHeaderArray;
		String[] autoReadArray, autoHeaderArray;

		fileReader omneReader = new fileReader("C:\\Users\\Shreeya\\Documents\\omne1.csv");
		fileReader autoReader = new fileReader("C:\\Users\\Shreeya\\Documents\\auto.csv");

		omneHeaderArray = omneReader.csvFileHeader();
		autoHeaderArray = autoReader.csvFileHeader();

		omneReadArray = omneReader.csvFileHeader();
		autoReadArray = autoReader.csvFileHeader();

		while (autoReadArray != null) {

			for (int c = 0; c < autoHeaderArray.length; c++) {

				for (int oc = 0; oc < omneHeaderArray.length; oc++) {
					if (autoHeaderArray[c].equalsIgnoreCase(omneHeaderArray[oc])) {

						if (autoReadArray != null) {
							if (autoReadArray[c].equalsIgnoreCase(omneReadArray[oc])) {
								System.out.println(autoReadArray[c]);
								
								break;

							} else  {
								
								fail=true;
							}

						}

					}

				}

			}
			autoReadArray = autoReader.csvFileHeader();
			System.out.println("I am while looper");
		}

		if(fail==true)
			display="does not match successfully";
	
		return display;
	}

	public static void main(String[] args) {}

}
