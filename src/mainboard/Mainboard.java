package mainboard;

import gral2demo.AgpGraphicCard;
import gral2demo.HddDrive;
import gral2demo.PciExpressGraphicCard; 
import gral2demo.LanCard;
import gral2demo.Ram;
import gral2demo.CdRom;

public class Mainboard {

	private IdePort[] idePorts;
	private AgpSlot agpSlot;
	private PciExpressSlot pciExpressSlot;
	private PciSlot pciSlot;
	private RamPort[] ramPorts;
	private SataPort[] sataPorts;

	public Mainboard(int idePorts, int ramPorts, int sataPorts )
	{
		this.idePorts=new IdePort[idePorts];
		for(int i=0;i<idePorts;i++)
			this.idePorts[i]=new IdePort(this);
		this.agpSlot=new AgpSlot(this);
		this.pciExpressSlot=new PciExpressSlot(this); 
		this.pciSlot=new PciSlot(this);
		this.ramPorts=new RamPort[ramPorts];
		for(int i=0;i<ramPorts;i++)
			this.ramPorts[i]=new RamPort(this);
		this.sataPorts=new SataPort[sataPorts];
		for(int i=0;i<sataPorts;i++)
			this.sataPorts[i]=new SataPort(this);
	
		
	}

	
	public void installIdeDevice(HddDrive drive, int portNumber)
	{
		if(portNumber<0 || portNumber>= idePorts.length)
		{
			System.out.println("\nNie ma takiego numeru portu.");
			return;
		}
		if(idePorts[portNumber].isAvaible())
			idePorts[portNumber].installDevice(drive);
		else
			System.out.println("\nSlot "+portNumber+" is not avaible.");
	}
	
	public void installAgpGraphicCard(AgpGraphicCard agpGraphicCard)
	{
		if(agpSlot.isAvaible())
			agpSlot.installDevice(agpGraphicCard);
		else
			System.out.println("\nGraphic card is already installed.");
		
	}
	
	public void installPciExpressGraphicCard(PciExpressGraphicCard pciExpressGraphicCard)
	{
		if(pciExpressSlot.isAvaible())
			pciExpressSlot.installDevice(pciExpressGraphicCard);
		else
			System.out.println("\nGraphic card is already installed.");
	}
	
	public void installLanCard(LanCard lanCard)
	{
		if(pciSlot.isAvaible())
			pciSlot.installDevice(lanCard);
		else
			System.out.println("\nLan card is already installed.");
	}
	
	public void installRam(Ram ram, int portNumber)
	{
		if(ramPorts[portNumber].isAvaible())
			ramPorts[portNumber].installDevice(ram);
		else
			System.out.println("\nSlot "+portNumber+" is not avaible.");
	}
	
	public void installCdRom(CdRom cdRom, int portNumber)
	{
		if(sataPorts[portNumber].isAvaible())
			sataPorts[portNumber].installDevice(cdRom);
		else
			System.out.println("\nSlot "+portNumber+" is not avaible.");
	}
	
	public String getFullDescription()
	{
		String result;
		result="----------------------------\n";
		result=result + "Ide Devices: \n";
		for(int i=0;i<idePorts.length;i++)
		{
			result=result+"Port "+i+"\n"+idePorts[i].getDescription();
		}
		result=result+"\n----------------------------\n";
		result=result + "Graphic Card: \n";
		result+=agpSlot.getDescription();
		result=result +"\nkolejna karta:\n";
		result+=pciExpressSlot.getDescription(); 
		result+="\n-----------------------\n";
		result+=pciSlot.getDescription();
		result+="\n-----------------------\n";
		result+="RAM:";
		for(int i=0;i<ramPorts.length;i++)
		{
			result=result+"Port "+i+"\n"+ramPorts[i].getDescription();
		}
		result+="\n-----------------\n";
		result+="CD-ROM:";
		for(int i=0;i<sataPorts.length;i++)
		{
			result=result+"Port "+i+"\n"+sataPorts[i].getDescription();
		}
		
		return result;
	}
}
