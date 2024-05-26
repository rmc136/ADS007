package domain;


/**
 * Classe que define UnidadeMedida
 * @authors Nº 54600, Nº 60470, Nº 60859
 */
public class UnidadeMedida {

	private String designacao;
	private String abreviatura;
	
	/**
	 * Construtor
	 * @param nome
	 * @param abrev
	 */
	public UnidadeMedida(String nome, String abrev) {
		designacao = nome;
		abreviatura = abrev;
	}
	
	/**
	 * 
	 * @return Abreviatura da unidade de medida
	 */
	public String obtemAbreviatura() {
		return abreviatura;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(designacao + "     " + abreviatura + "\n");
		return sb.toString();
	}
}
