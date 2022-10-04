package dad.IMC;

public enum IMC{
	Bp("Bajo peso"),
	No("Normal"),
	Sp("Sobrepeso"),
	Ob("Obeso");
	
	private String text;
	
	private IMC(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return text;
	}
	
	public static IMC getIMC(double d) {
		if(d < 18.5) {
			return IMC.Bp;
		}
		else if(d >= 18.5 && d < 25) {
			return IMC.No;
		}
		else if(d >= 25 && d < 30) {
			return IMC.Sp;
		}
		return IMC.Ob;
		
	}
}
