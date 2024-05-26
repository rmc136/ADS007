package domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import domain.alertas.EventoAlerta;

public class CaracteristicaContexto {
	
	private DescricaoCaracteristica carac;
	private ValoresReferencia valores = new ValoresReferencia(0, 0);
	private List<Leitura> leituras = new ArrayList<>();
	private PropertyChangeSupport support;
	
	public CaracteristicaContexto(DescricaoCaracteristica carac) {
		this.carac = carac;
		this.support = new PropertyChangeSupport(this);
		
	}
	
	public void addPropertyChangeListener(PropertyChangeListener evt) {
        support.addPropertyChangeListener(evt);
    }

    public void removePropertyChangeListener(PropertyChangeListener evt) {
        support.removePropertyChangeListener(evt);
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

	public void registarLeitura(int ano, int mes, int dia, double valor, String contexto) {
		// TODO Auto-generated method stub
			
			
			String uni = abreviaturaUnidade(); 
			Leitura l = new Leitura(ano,mes,dia,valor,uni);
			ValoresReferencia valores = getValores();
			
			addLeitura(l);
			boolean k = valores.estahNoIntervalo(valor) == 0;

		if(!k) {
			int i = valores.estahNoIntervalo(valor);
			double min = valores.getMin();
			double max = valores.getMax();
			if(i>0 || i<0) {
				String mensagem = valor < min ? "Valor abaixo do mínimo" : "Valor acima do máximo";
	            EventoAlerta evento = new EventoAlerta(ano, mes, dia, valor, uni, nomeCaracteristica(), contexto, mensagem);
	            support.firePropertyChange("alerta", null, evento);
			}
		}
		
	}
}
