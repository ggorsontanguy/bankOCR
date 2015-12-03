package bankOCR;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

	public static final String BLANK_BLOCK = "";
	
	private File file;

	public FileParser(File file) {
		this.file = file;
	}

	public List<String> parseFile() {
		List<String> returnedList = new ArrayList<String>();
		try {
			BufferedReader input = new BufferedReader(new FileReader(file));
			try {
				String line = null;
	
				int counter = 1;
				final int maxLine = 4;
				String block = BLANK_BLOCK;
	
				while ((line = input.readLine()) != null) {
					block += line;
					counter++;
					if (counter >= maxLine) {
						returnedList.add(block);
						counter = 1;
						block = BLANK_BLOCK;
					}
				}
			} finally {
				input.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return returnedList;
	}

}
