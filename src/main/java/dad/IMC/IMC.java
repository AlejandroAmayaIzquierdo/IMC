package dad.IMC;

public class IMC {
	public enum Clasificacion{
		Bp("Bajo peso"),
		N("Normal"),
		Sp("Sobrepeso"),
		Ob("Obeso");
		
		private String text;
		
		private Clasificacion(String text) {
			this.text = text;
		}
		@Override
		public String toString() {
			return text;
		}
	}
	public static Double getImc(Double peso,Double altura) {
		return (peso * Math.pow(altura/100, 2));
	}
	
	public static String getClasificacion(double d) {
		if(d < 18.5) {
			return Clasificacion.Bp.toString();
		}
		else if(d >= 18.5 && d < 25) {
			return Clasificacion.N.toString();
		}
		else if(d >= 25 && d < 30) {
			return Clasificacion.Sp.toString();
		}
		return Clasificacion.Ob.toString();
		
	}
}
