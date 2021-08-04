package com.example.demo.bean;


public class TipusTreball {
	public enum TipusTreballEnum {
		APRENENT(0,900.0), OPERARI(1, 1500.0), DIRECTIU(2, 3000.0);
		
		private final int id;
		private final double sou;
		
		TipusTreballEnum(int id, double sou) { 
			this.id=id;
			this.sou=sou;
		}
		
		public int id() {
			return id;
		}
		
		public double Sou() {
			return sou;
		}
		
		public static TipusTreballEnum GetTipusTreball(String treball){
			TipusTreballEnum ret=null;
			if (treball.equalsIgnoreCase("Aprenent"))
				ret=APRENENT;
			else if (treball.equalsIgnoreCase("Operari"))
				ret=OPERARI;
			else if (treball.equalsIgnoreCase("Directiu"))
				ret=DIRECTIU;
			
			return ret;
		}
		
		public static String GetTipusTreballNom(TipusTreballEnum treball){
			String nom="";
			switch (treball) {
			case APRENENT:
				nom="Aprenent";
				break;
			case OPERARI:
				nom="Operari";
				break;
			case DIRECTIU:
				nom="Directiu";
				break;
			}
			
			return nom;
		}
		
	}

}
