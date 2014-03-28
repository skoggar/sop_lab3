package gral2demo;

import mainboard.Mainboard;

public class Main {

	public static void main(String[] args) {
		
		Mainboard gigabyte = new Mainboard(1);
		AgpGraphicCard nvidia = new AgpGraphicCard();
		nvidia.setDescription("Karta nvidia");
		HddDrive samsung = new HddDrive();
		samsung.setDescription("Dysk twardy Samsung");
		gigabyte.installAgpGraphicCard(nvidia);
		gigabyte.installIdeDevice(samsung, 0);
		
		System.out.print(gigabyte.getFullDescription());
		gigabyte.installIdeDevice(samsung, 0);
		
	}

}
