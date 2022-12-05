
public class Drive {
	private String ID;
	private String type;
	private String manufacturer;
	private int size;
	private int price;
	
	public Drive(String type, String manufacturer, int size) {
		this.type = type;
		this.manufacturer = manufacturer;
		this.size = size;
	}
	
	public String initialID() {
		return null;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

}
