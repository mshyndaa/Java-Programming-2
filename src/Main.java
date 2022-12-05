import java.util.*;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class Main {
	
	Scanner in = new Scanner(System.in);
	int menu = 0;
	String type, manufacturer, cache;
	int size = 0, diskNo = 0, nand = 0;
	long rpm = 0;
	
	private Vector<Drive> driveList = new Vector<Drive>();
	private Vector<Hdd> hddList = new Vector<Hdd>();
	private Vector<Ssd> ssdList = new Vector<Ssd>();
	
	public Main() {
		
		do {
			
			System.out.println("AD Drive Store");
			System.out.println("==============");
			System.out.println("");
			System.out.println("1. Add Drive");
			System.out.println("2. View Drives");
			System.out.println("3. Remove Drive");
			System.out.println("4. Buy");
			System.out.println("5. Exit");
			System.out.print("Choose [1-5]: ");
			
			try {
				menu = in.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
			}
			in.nextLine();
			
			if (menu == 1) {
				add();
			} else if (menu == 2) {
				view();
			} else if (menu == 3) {
				remove();
			} else if (menu == 4) {
				buy();
			}
			
		} while (menu != 5);
		
	}
	
	public void add() {
		
		// type
		do {
			
			System.out.print("Select drive type [HDD | SSD]: ");
			
			try {
				type = in.nextLine();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} while (!type.contains("HDD") && !type.contains("SSD"));
		
		
		// manufacturer
		do {
			
			System.out.print("Input manufacturer name [5..25]: ");
			
			try {
				manufacturer = in.nextLine();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} while (manufacturer.length() < 5 || manufacturer.length() > 25);
		
		
		
		// size
		do {
			
			System.out.print("Input drive size [256 | 512 | 1024 | 2048] GB: ");
			
			try {
				size = in.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
			}
			in.nextLine();
			
		} while (size != 256 && size != 512 && size != 1024 && size != 2048);
		
		if(type.contains("HDD")) {
			
			// rpm
			do {
				
				System.out.print("Input drive's ration speed (RPM) [5200 - 10000]: ");
				
				try {
					rpm= in.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
				}
				in.nextLine();
				
			} while (rpm < 5200 || rpm > 10000);
			
			// disk
			do {
				
				System.out.print("Input no. of disk plate [5 - 12]: ");
				
				try {
					diskNo = in.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
				}
				in.nextLine();
				
			} while (diskNo < 5 || diskNo > 12);
			
			Hdd disk = new Hdd(type, manufacturer, size, rpm, diskNo);
			hddList.add(disk);
			
		} else if (type.contains("SSD")) {
			
			// nand
			do {
				
				System.out.print("Input NAND type [1 - 4]: ");
				
				try {
					nand= in.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
				}
				in.nextLine();
				
			} while (nand < 1 || nand > 4);
			
			// cache
			do {
				
				System.out.print("Input cache type [cache | cacheless]: ");
				
				try {
					cache = in.nextLine();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			} while (!cache.contains("cache") && !cache.contains("cacheless"));
			
			Ssd disk = new Ssd(type, manufacturer, size, nand, cache);
			ssdList.add(disk);
			
		}
		
		System.out.println("Drive Sucessfully Added!");
		System.out.print("Press enter to continue...");
		in.nextLine();
		
	}
	
	public void view() {
		
		System.out.println("List of drives");
		System.out.println("==============");
		System.out.println();
		
		if (hddList.size() == 0 && ssdList.size() == 0) {
			System.out.println("No drive available.");
		} else {
			
			if(hddList.size() != 0) {
				
				System.out.println("(HDD)");
				System.out.println("+===+======================+==================+===============+===========+=============+");
				System.out.println("| No | Manufacturer\t| Part ID\t| Drive Size | RPM \t| Disk Plates |");
				System.out.println("+===+======================+==================+===============+===========+=============+");
				for (int i = 0; i < hddList.size(); i++) {
					System.out.println("| "+ (i+1) + "| " + hddList.get(i).getManufacturer() + "\t| " + hddList.get(i).getID() + "\t| " + hddList.get(i).getSize() + " | " + hddList.get(i).getSpeed() + "\t| " + hddList.get(i).getTotalDisk() + "|");
				}
				System.out.println("+===+======================+==================+===============+===========+=============+");
				
			}
			
			if(ssdList.size() != 0) {
				
				System.out.println("\n(SSD)");
				System.out.println("+===+======================+==================+===============+===========+=============+");
				System.out.println("| No | Manufacturer\t| Part ID\t| Drive Size | Cache | NAND Type |");
				System.out.println("+===+======================+==================+===============+===========+=============+");
				for (int i = 0; i < ssdList.size(); i++) {
					System.out.println("| "+ (i+1) + "| " + ssdList.get(i).getManufacturer() + "\t| " + ssdList.get(i).getID() + "\t| " + ssdList.get(i).getSize() + " | " + ssdList.get(i).getCache() + " | " + ssdList.get(i).getNand() + "|");
				}
				System.out.println("+===+======================+==================+===============+===========+=============+");
				
				
			}
			
		}
		
		System.out.print("Press enter to continue...");
		in.nextLine();
	}

	public void remove() {
		System.out.println("Remove Drive");
		System.out.println("============");
		
		Vector<Drive> driveList = new Vector<>();
		driveList.addAll(hddList);
		driveList.addAll(ssdList);
		
		if (driveList.size() == 0) {
			System.out.println("No drive available.");
		} else {
			System.out.println("+===+======================+==================+===============+===========+=============+");
			System.out.println("| No | Manufacturer\t| Part ID\t| Drive Size |");
			System.out.println("+===+======================+==================+===============+===========+=============+");
			for (int i = 0; i < driveList.size(); i++) {
				System.out.println("| "+ (i+1) + "| " + driveList.get(i).getManufacturer() + "\t| " + driveList.get(i).getID() + "\t| " + driveList.get(i).getSize() + " |");
			}	
			System.out.println("+===+======================+==================+===============+===========+=============+");
			
			int no = 0;
			do {
				
				System.out.print("\nChoose drive No. to be removed: ");
				
				try {
					no = in.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
				}
				in.nextLine();
				
			} while (no < 1 || no > driveList.size());
			
			no -= 1;
			
			if (driveList.get(no).getType().contains("HDD")) {
				for (int i = 0; i < hddList.size(); i++) {
					if(hddList.get(i).getID() == driveList.get(no).getID()) {
						hddList.remove(i);
						break;
					}
				}
			} else {
				for (int i = 0; i < ssdList.size(); i++) {
					if(ssdList.get(i).getID() == driveList.get(no).getID()) {
						ssdList.remove(i);
						break;
					}
				}
			}
			
			System.out.println("Drive succesfully removed!!");
		}
		
		System.out.print("Press enter to continue...");
		in.nextLine();
	}

	public void buy() {
		
		System.out.println("Buy Drive");
		System.out.println("=========");
		
		Vector<Drive> driveList = new Vector<>();
		driveList.addAll(hddList);
		driveList.addAll(ssdList);
		
		if (driveList.size() == 0) {
			System.out.println("No drive available.");
		} else {
			System.out.println("+===+======================+==================+===============+===========+=============+");
			System.out.println("| No | Manufacturer\t| Part ID\t| Drive Size |");
			System.out.println("+===+======================+==================+===============+===========+=============+");
			for (int i = 0; i < driveList.size(); i++) {
				System.out.println("| "+ (i+1) + "| " + driveList.get(i).getManufacturer() + "\t| " + driveList.get(i).getID() + "\t| " + driveList.get(i).getSize() + " |");
			}	
			System.out.println("+===+======================+==================+===============+===========+=============+");
			
			int no = 0;
			do {
				
				System.out.print("\nSelect drive No. : ");
				
				try {
					no = in.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
				}
				in.nextLine();
				
			} while (no < 1 || no > driveList.size());
			
			no -= 1;
			
			System.out.println("Drive price (USD): " + driveList.get(no).getPrice());
			
			System.out.println("Thank you for the purchase!!");
		}
		
		System.out.print("Press enter to continue...");
		in.nextLine();
	
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
