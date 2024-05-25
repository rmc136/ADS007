package domain;


import java.util.HashMap;
import java.util.Map;

public class DescricaoCaracteristica {

	private String desig;
	private UnidadeMedida unidade;
	private TipoSensor tipo;
	
	public DescricaoCaracteristica(String desig) {
		this.desig = desig;
	}

	public void associaTipoSensor(TipoSensor ts) {
		// TODO Auto-generated method stub
		tipo = ts;
	}

	public void defineUnidadeMedida(UnidadeMedida uni) {
		// TODO Auto-generated method stub
		unidade = uni;
	}

	public String obtemDesignacao() {
		// TODO Auto-generated method stub
		return desig;
	}

	public TipoSensor obtemTipoSensor() {
		return tipo;
	}

	public String obtemAbrevitaturaUnidade() {
		return unidade.obtemAbreviatura();
		
	}
	
}
