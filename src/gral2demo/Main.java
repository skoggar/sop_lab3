package gral2demo;

import mainboard.Mainboard;

public class Main {

	public static void main(String[] args) {
		
		Mainboard gigabyte = new Mainboard(1,1,1);
		AgpGraphicCard nvidia = new AgpGraphicCard();
		nvidia.setDescription("Karta nvidia");
		HddDrive samsung = new HddDrive();
		samsung.setDescription("Dysk twardy Samsung");
		PciExpressGraphicCard ati = new PciExpressGraphicCard();
		ati.setDescription("Karta pci-e ATI");
		LanCard intel = new LanCard();
		intel.setDescription("Intel Ethernet Adapter");
		Ram patriot = new Ram();
		patriot.setDescription("Patriot DDR3 RAM");
		gigabyte.installAgpGraphicCard(nvidia);
		gigabyte.installIdeDevice(samsung, 0);
		gigabyte.installPciExpressGraphicCard(ati);
		gigabyte.installLanCard(intel);
		gigabyte.installRam(patriot, 0);
		
		System.out.print(gigabyte.getFullDescription());
		//gigabyte.installIdeDevice(samsung, 0);
		
	}

}
