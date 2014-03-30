package mainboard;

import gral2demo.CdRom; 


 class SataPort {

	 private String description;
		private Mainboard mainboard;
		private boolean avaible = true;
		private CdRom drive;
		public SataPort(Mainboard mainboard) {
			
			this.mainboard = mainboard;
		}

		public void installDevice(CdRom drive)
		{
			drive.setMainboard(mainboard);
			description=drive.getDescription();
			this.drive=drive;
			this.avaible=false;
		}

		public void unInstallDevice()
		{
			drive.setMainboard(null);
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
