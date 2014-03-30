package mainboard;


import gral2demo.Ram;

 class RamPort {

	 private String description;
		private Mainboard mainboard;
		private boolean avaible = true;
		private Ram modul;
		public RamPort(Mainboard mainboard) {
			
			this.mainboard = mainboard;
		}

		public void installDevice(Ram modul)
		{
			modul.setMainboard(mainboard);
			description=modul.getDescription();
			this.modul=modul;
			this.avaible=false;
		}

		public void unInstallDevice()
		{
			modul.setMainboard(null);
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
