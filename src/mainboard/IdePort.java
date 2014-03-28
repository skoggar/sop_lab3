package mainboard;

import gral2demo.HddDrive;

 class IdePort {

	 private String description;
		private Mainboard mainboard;
		private boolean avaible = true;
		private HddDrive drive;
		public IdePort(Mainboard mainboard) {
			
			this.mainboard = mainboard;
		}

		public void installDevice(HddDrive drive)
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
