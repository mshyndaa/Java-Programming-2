import java.util.Random;

public class Hdd extends Drive{
	
	private long speed;
	private int totalDisk;
	

	public Hdd(String type, String manufacturer, int size, long speed, int totalDisk) {
		super(type, manufacturer, size);
		// TODO Auto-generated constructor stub
		
		this.speed = speed;
		this.totalDisk = totalDisk;
		super.setID(initialID());
		super.setPrice((int)(speed/10000*1.5)+(totalDisk+25)+(size/4));
	}
	
	

	@Override
	public String initialID() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		
		return (super.getManufacturer().substring(0, 3)).toUpperCase() + super.getType() + (rand.nextInt(100)+1) + super.getSize();
	}

	public long getSpeed() {
		return speed;
	}

	public void setSpeed(long speed) {
		this.speed = speed;
	}

	public int getTotalDisk() {
		return totalDisk;
	}

	public void setTotalDisk(int totalDisk) {
		this.totalDisk = totalDisk;
	}
	
	

}
