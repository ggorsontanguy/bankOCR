package bankOCR;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
