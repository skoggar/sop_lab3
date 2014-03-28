package mainboard;

import gral2demo.AgpGraphicCard;
import gral2demo.HddDrive;

public class Mainboard {

	private IdePort[] idePorts;
	private AgpSlot agpSlot;

	public Mainboard(int idePorts )
	{
		this.idePorts=new IdePort[idePorts];
		for(int i=0;i<idePorts;i++)
			this.idePorts[i]=new IdePort(this);
		this.agpSlot=new AgpSlot(this);
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
		return result;
	}
}
