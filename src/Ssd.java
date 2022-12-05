import java.util.Random;

public class Ssd extends Drive{
	
	private int nand;
	private String cache;

	public Ssd(String type, String manufacturer, int size, int nand, String cache) {
		super(type, manufacturer, size);
		// TODO Auto-generated constructor stub
		
		this.cache = cache;
		this.nand = nand;
		super.setID(initialID());
		if (cache.contains("cacheless")) {
			super.setPrice((int)(nand*3.75)+(size/2));
		} else {
			super.setPrice((int)(nand*3.75)+(size/2)+20);
		}
	}
	
	@Override
	public String initialID() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		
		return (super.getManufacturer().substring(0, 3)).toUpperCase() + super.getType() + (rand.nextInt(100)+1) + super.getSize();
	}

	public int getNand() {
		return nand;
	}

	public void setNand(int nand) {
		this.nand = nand;
	}

	public String getCache() {
		return cache;
	}

	public void setCache(String cache) {
		this.cache = cache;
	}
	
	

}
