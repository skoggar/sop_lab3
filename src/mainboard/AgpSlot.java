package mainboard;

import gral2demo.AgpGraphicCard;

public class AgpSlot {

	private String description;
	private Mainboard mainboard;
	private boolean avaible = true;
	private AgpGraphicCard card;
	public AgpSlot(Mainboard mainboard) {
		
		this.mainboard = mainboard;
	}

	public void installDevice(AgpGraphicCard card)
	{
		card.setMainboard(mainboard);
		description=card.getDescription();
		this.card=card;
		this.avaible=false;
	}

	public void unInstallDevice()
	{
		card.setMainboard(null);
		description=null;
		this.avaible=true;
	}

	public String getDescription() {
		return description;
	}

	public boolean isAvaible() {
		return avaible;
	}

	
	
	
	
}
