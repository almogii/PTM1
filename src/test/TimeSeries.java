package test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class TimeSeries {
	HashMap<String, ArrayList<Float>> arrTimeSeries = new HashMap<String, ArrayList<Float>>(); // Array of lists at the size of 4

	public String[] getFirstLine() {
		return FirstLine;
	}

	// The function saves a csv file to an Array of lists
	String[] FirstLine;


   public TimeSeries(String csvFileName) throws IOException {
			// Initialize values
			Scanner scanner = new Scanner(new File(csvFileName));
			strFirstLine = scanner.nextLine().split(",");
			int nIndex;
			for(nIndex = 0;nIndex< strFirstLine.length;nIndex++) {
				arrTimeSeries.put(strFirstLine[nIndex], new ArrayList<Float>());
			}

			nIndex = 0;
			while(scanner.hasNext()) {
				for(int nCol =0;nCol < strFirstLine.length;nCol++)
					arrTimeSeries.get(strFirstLine[nCol]).add(nIndex,scanner.nextFloat());
				nIndex++;
			}
			scanner.close();
		}

		public HashMap<String, ArrayList<Float>> getHashTimeSeries() {
			return arrTimeSeries;
		}

		public String[] getHashKeys() {
			return strFirstLine;
		}
}
