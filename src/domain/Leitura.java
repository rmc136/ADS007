package domain;

/**
 * Classe que define Leitura
 * @author Nº 54600, Nº 60470, Nº 60859
 */
public class Leitura {

	private int ano;
	private int mes;
	private int dia;
	private double valor;
	private String uni;
	
	/**
	 * Construtor
	 * @param ano
	 * @param mes
	 * @param dia
	 * @param valor
	 * @param uni
	 */
	public Leitura(int ano, int mes, int dia, double valor, String uni) {
		
		this.ano = ano;
		this.mes = mes;
		this.dia = dia;
		this.valor = valor;
		this.uni =uni;
	}
}
