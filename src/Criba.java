import java.util.Scanner;
/**
 * Clase para sacar los números primos mediante el metodo de la criba de erastotenes
 * @version 1.0 24/02/2021
 * @author Salix
 *
 */
public class Criba {
	
	/**
	 * Este metodo sirve para generar los números primos de 1 a max
	 * @param max
	 * @return
	 */
	public static int[] generarPrimos (int max) {
		
		int i,j;
		if (max >= 2) {
			// Declaraciones
			int dim = max + 1; // Tamaño del array
			boolean[] esPrimo = new boolean[dim];
			
			i = iniciarArray(dim, esPrimo);
			
			// Eliminar el 0 y el 1, que no son primos
			esPrimo[0] = esPrimo[1] = false;
			
			i = criba(dim, esPrimo);
			
			int cuenta = cuentaPrimos(dim, esPrimo);
			
			return rellenaVector(dim, esPrimo, cuenta);
			
		} else { // max < 2
			return new int[0];
			// Vector vacío
		}
	}
	
	/**
	 * Este metodo sirve para <code>inicializar el array</cobde>
	 * @param dim  Tamaño del array
	 * @param esPrimo array de primos
	 * @return
	 */
	private static int iniciarArray(int dim, boolean[] esPrimo) {
		int i;
		for (i=0; i<dim; i++)
			esPrimo[i] = true;
		return i;
	}

	/**
	 * Este metodo sirve para <code>eliminar los que sean multiplos</code>
	 * @param dim tamaño del array
	 * @param esPrimo array de primos
	 * @return
	 */
	private static int criba(int dim, boolean[] esPrimo) {
		int i;
		int j;
		for (i=2; i<Math.sqrt(dim)+1; i++) {
			if (esPrimo[i]) {
				// Eliminar los múltiplos de i
				j = eliminarMultiplosI(i, dim, esPrimo);
			}
		}
		return i;
	}

	/**
	 * Este metodo es una extensión del metdo criba 
	 * @param i
	 * @param dim tamaño del array
	 * @param esPrimo array de primos
	 * @return 
	 */
	private static int eliminarMultiplosI(int i, int dim, boolean[] esPrimo) {
		int j;
		for (j=2*i; j<dim; j+=i)
			esPrimo[j] = false;
		return j;
	}

	/**
	 * Este metodo sirve para <code>saber cuantos primos hay</code>
	 * @param dim
	 * @param esPrimo
	 * @return devuelve el numero de primos
	 */
	private static int cuentaPrimos(int dim, boolean[] esPrimo) {
		int i;
		int cuenta = 0;
		for (i=0; i<dim; i++) {
			if (esPrimo[i])
				cuenta++;
		}
		return cuenta;
	}

	/**
	 * Este metodo sirve para <code>Rellena el array de numeros primos</code>
	 * @param dim
	 * @param esPrimo
	 * @param cuenta
	 * @return Devuelve los que son primos
	 */
	private static int[] rellenaVector(int dim, boolean[] esPrimo, int cuenta) {
		int i;
		int j;
		int[] primos = new int[cuenta];
		for (i=0, j=0; i<dim; i++) {
			if (esPrimo[i])
				primos[j++] = i;
		}
		return primos;
	}
	
	/**
	 * Este es el metodo principal y sirve para <code>cojer los datos de entrada e imprimirlos en la consola</code>
	 * @param args
	 * Aqui esta la parte que sale por pantalla y 
	 */
	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduce el número para la criba de Erastótenes:");
		int dato=teclado.nextInt();
		int vector[]=new int[dato];
		System.out.println("\nVector inicial hasta :"+dato);
		for (int i = 0; i < vector.length; i++) {
			if (i%10==0) System.out.println();
			System.out.print(i+1+"\t");
		}
		vector=generarPrimos(dato);
		System.out.println("\nVector de primos hasta:"+dato);
		for (int i = 0; i < vector.length; i++) {
			if (i%10==0) System.out.println();
			System.out.print(vector[i]+"\t");
		}
		teclado.close();
	}
}