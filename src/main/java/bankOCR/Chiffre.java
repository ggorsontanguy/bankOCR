package bankOCR;

public class Chiffre {

	private String first__;
	private String second;
	private String third_;
	private String fourth;
	
	public Chiffre(String first__, String second, String third_, String fourth) {
		checkSize(first__);
		checkSize(second);
		checkSize(third_);
		checkSize(fourth);
		this.first__ = first__;
		this.second = second;
		this.third_ = third_;
		this.fourth = fourth;
	}
	
	private void checkSize(String line){
		if(line.length()>3){
			throw new IllegalArgumentException();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first__ == null) ? 0 : first__.hashCode());
		result = prime * result + ((fourth == null) ? 0 : fourth.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		result = prime * result + ((third_ == null) ? 0 : third_.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chiffre other = (Chiffre) obj;
		if (first__ == null) {
			if (other.first__ != null)
				return false;
		} else if (!first__.equals(other.first__))
			return false;
		if (fourth == null) {
			if (other.fourth != null)
				return false;
		} else if (!fourth.equals(other.fourth))
			return false;
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		if (third_ == null) {
			if (other.third_ != null)
				return false;
		} else if (!third_.equals(other.third_))
			return false;
		return true;
	}
	
	
	
}
