package lu.lllc.ajax.entity;

public class CountryRequest {
	private String substring;
	private int size;
	public CountryRequest(String substring, int size) {
		this.substring = substring;
		this.size = size;
	}
	public String getSubstring() {
		return substring;
	}
	public void setSubstring(String substring) {
		this.substring = substring;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}


	
}
