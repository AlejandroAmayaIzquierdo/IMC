package dad.IMC;

public class IMC {
	public enum values{
		Bp("Bajo peso"),
		N("Normal"),
		Sp("Sobrepeso"),
		Ob("Obeso");
		
		String text;
		
		private values(String text) {
			this.text = text;
		}
	}
	public static Double getImc(Double peso,Double altura) {
		return (peso * Math.pow(altura/100, 2));
	}
	
	public static String getClasificacion(double d) {
		String toReturn = "";
		if(d > 0) {
			toReturn = values.Bp.text;
		}
		if(d >= 18.5 && d < 25) {
			toReturn = values.N.text;
		}
		if(d >= 25 && d < 30) {
			toReturn = values.Sp.text;
		}
		if(d >= 30) {
			toReturn = values.Ob.text;
		}
		
		return toReturn;
	}
}
