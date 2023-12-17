package strings.pack;

public class Main {

	private static final int NUMERO_ITERACIONES = 100000;
	
	public static void main(String[]args) {
		
		concatenaStringBuilder();
		concatenaString();
		
		
	}
	
	//Sin StringBuilder es mucho más lento
	private static void concatenaString() {
		
		System.out.println("INICIO 1");
		String valor = "";
		
		int contador = 0;
		while(contador < NUMERO_ITERACIONES) {
			
			valor = valor + ", " + contador;
			contador++;
		}
		System.out.println("fin 1: "+contador);
		
	}
	
	
	//Con StringBuilder es muchisimo más rápido. 
private static void concatenaStringBuilder() {
		
		System.out.println("INICIO 2");
		StringBuilder valor = new StringBuilder();
		
		int contador = 0;
		while(contador < NUMERO_ITERACIONES) {
			
			valor.append(", "+ contador);
			contador++;
		}
		System.out.println("fin 2: "+contador);
		
	}
	
}
