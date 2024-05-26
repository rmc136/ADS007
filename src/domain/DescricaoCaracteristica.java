package domain;


import java.util.HashMap;
import java.util.Map;

/**
 * Classe que define DescricaoCaracteristica
 * @author Nº 54600, Nº 60470, Nº 60859
 */

public class DescricaoCaracteristica {

	private String desig;
	private UnidadeMedida unidade;
	private TipoSensor tipo;
	
	/**
	 * Construtor
	 * @param desig
	 */
	public DescricaoCaracteristica(String desig) {
		this.desig = desig;
	}
	
	/**
	 *
	 * @param ts
	 * Associa TipoSensor
	 */
	public void associaTipoSensor(TipoSensor ts) {
		// TODO Auto-generated method stub
		tipo = ts;
	}
	
	/**
	 * 
	 * @param uni
	 * Define UnidadeMedida
	 */
	public void defineUnidadeMedida(UnidadeMedida uni) {
		// TODO Auto-generated method stub
		unidade = uni;
	}
	
	/**
	 * 
	 * @return nome da Caracteristica
	 */
	public String obtemDesignacao() {
		// TODO Auto-generated method stub
		return desig;
	}

	/**
	 * 
	 * @return TipoSensor
	 */
	public TipoSensor obtemTipoSensor() {
		return tipo;
	}

	/**
	 * 
	 * @return Abreviacao da unidade de medida
	 */
	public String obtemAbrevitaturaUnidade() {
		return unidade.obtemAbreviatura();
		
	}
	
}
