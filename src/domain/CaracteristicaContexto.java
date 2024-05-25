package domain;

import java.util.ArrayList;
import java.util.List;

public class CaracteristicaContexto {
	
	private DescricaoCaracteristica carac;
	private ValoresReferencia valores = new ValoresReferencia(0, 0);
	private List<Leitura> leituras = new ArrayList<>();
	
	public CaracteristicaContexto(DescricaoCaracteristica carac) {
		this.carac = carac;
		
	}

	public void associaSensor(Sensor sens) {
		// TODO Auto-generated method stub
		
	}

	public void registaValoresRef(int i, int j) {
		valores.regMin(i);
		valores.regMax(j);
	}

	public String nomeCaracteristica() {
		// TODO Auto-generated method stub
		return carac.obtemDesignacao();
	}

	public void addObserver(Contexto contexto) {
		// TODO Auto-generated method stub
		
	}

	public boolean definirUnidadeCorrenteLeitura(String unidade) {
		// TODO Auto-generated method stub
		String abrev = carac.obtemAbrevitaturaUnidade();
		System.out.println(unidade);
		System.out.println(abrev);
		return unidade.equals(abrev);
	}

	public String abreviaturaUnidade() {
		// TODO Auto-generated method stub
		return carac.obtemAbrevitaturaUnidade();
	}
	
	public ValoresReferencia getValores() {
		return valores;
	};
	
	public void addLeitura(Leitura leitura) {
		leituras.add(leitura);
	}
		
	
}
