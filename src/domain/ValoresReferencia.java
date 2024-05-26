package domain;

/**
 * Classe que define intervalos de valores
 * @author ADS
 */
public class ValoresReferencia {
	
	private double max, min;
	
	/**
	 * Construtor
	 * @param minimo - Limite inferior do intervalo
	 * @param maximo - Limite superior do intervalo
	 */
	public ValoresReferencia (double minimo, double maximo) {
		max = maximo;
		min = minimo;
	}

	/**
	 * Um dado valor pertence a este intervalo?
	 * @param valor - O valor
	 * @return
	 */
	public int estahNoIntervalo(double valor) {
		int result = 0;
		if (valor < min)
			result = -1;
		else if (valor > max)
			result = 1;
		return result;
	}
	
	/**
	 * @author Nº 54600, Nº 60470, Nº 60859
	 * @param minimo
	 * @return minimo
	 */
	public double regMin(double minimo) {
		min = minimo;
		return min;
	}
	
	/**
	 * 
	 * @return minimo
	 */
	public double getMin() {
		return min;
	}
	
	/**
	 * 
	 * @return maximo
	 */
	public double getMax() {
		return max;
	}
	
	/**
	 * 
	 * @param maximo
	 * @return maximo
	 */
	public double regMax(double maximo) {
		max = maximo;
		return max;
	}
}
