package bankOCR;

public class Block {

	private Chiffre first__;
	private Chiffre second;
	private Chiffre third_;
	private Chiffre fourth;
	
	public Block(String first__, String second, String third_, String fourth) {
		checkSize(first__);
		checkSize(second);
		checkSize(third_);
		checkSize(fourth);
	}
	
	private void checkSize(String line){
		if(line.length()>27){
			throw new IllegalArgumentException();
		}
	}
	
}
