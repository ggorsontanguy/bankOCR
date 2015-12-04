package bankOCR;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.assertj.core.description.Description;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class UserStory1 {

	String FILE_5;

	@Before
	public void setUp() {
		FILE_5 = "./src/test/resources/5_accounts_file.txt";
	}

	@Test
	public void should_read_the_file() throws IOException {
		File _5 = new File(FILE_5);
		FileReader fileReader = new FileReader(_5);
		fileReader.close();
	}

	@Test
	public void should_parse_a_file_into_list_of_4_lines_block() {
		// GIVEN
		List<String> listOf4LinesBlock = new ArrayList<String>();

		File _5 = new File(FILE_5);
		FileParser fileparser = new FileParser(_5);

		// WHEN
		listOf4LinesBlock = fileparser.parseFile();

		// THEN
		assertThat(listOf4LinesBlock.size()).isEqualTo(5);
	}

	
	@Test
	public void should_recognize_number_one() {
		// GIVEN
		Chiffre givenNumber = new Chiffre("   ", "  |", "  |", "   ");

		// WHEN
		Chiffre _1 = new Chiffre("   ", "  |", "  |", "   ");
		
		//THEN
		assertThat(givenNumber.equals(_1)).isTrue();
	}
	
	@Test
	public void number_one_should_be_converted_to_int_1() {
		// GIVEN
		Chiffre givenNumber = new Chiffre("   ", "  |", "  |", "   ");
		
		//WHEN
		int actual = givenNumber.convertToInt();
		
		//THEN
		int expected = 1;
		assertThat(actual).as("Given int value").isEqualTo(expected );
		
	}

	@Test
	public void should_found_number_one_in_the_first_block_of_the_file() {
		
		//GIVEN
		File file = new File(FILE_5);

		List<String> lines = new ArrayList<String>();
		
		try {
			BufferedReader input = new BufferedReader(new FileReader(file));
			try {
				String line = null;
				int counter = 0;
				final int maxLine = 4;
				while ((line = input.readLine()) != null) {
					if ((counter++) < maxLine) {
						lines.add(line);
					} else {
						break;
					}
				}
			} finally {
				input.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		assertThat(lines).isNotEmpty();
		assertThat(lines.size()).isEqualTo(4);
		
		int index = 0;
		String first = lines.get(index++).substring(0, 3);
		String second  = lines.get(index++).substring(0, 3);
		String third  = lines.get(index++).substring(0, 3);
		String fourth  = lines.get(index++).substring(0, 3);
		
		//WHEN
		Chiffre actualNumber = new Chiffre(first, second, third, fourth);
		
		
		assertThat(actualNumber.convertToInt()).isEqualTo(1);
	}
	
	@Test
	public void number_one_should_be_converted_to_int_2() {
		// GIVEN
		Chiffre givenNumber = new Chiffre(" _ ", " _|", "|_ ", "   ");
		
		//WHEN
		int actual = givenNumber.convertToInt();
		
		//THEN
		int expected = 2;
		assertThat(actual).as("Given int value").isEqualTo(expected );
		
	}
	
	@Test
	@Ignore
	public void should_read_a_block_and_do_not_throw_any_exception(){
		//GIVEN
		FileParser fileparser = new FileParser(new File(FILE_5));
		List<String> lines = fileparser.parseFile();
		assertThat(lines).isNotEmpty();
		assertThat(lines.size()).isGreaterThanOrEqualTo(4);
		String firstLine = lines.get(0);
		String secondLine = lines.get(1);
		String thirdLine = lines.get(2);
		String fourthLine = lines.get(3);
		
		//WHEN
		new Block(firstLine, secondLine, thirdLine, fourthLine);
	}
}
