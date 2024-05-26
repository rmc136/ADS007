package domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import domain.alertas.EventoAlerta;

/**
 * Classe que define CaracteristicaContexto
 * @author Nº 54600, Nº 60470, Nº 60859
 */
public class CaracteristicaContexto {
	
	private DescricaoCaracteristica carac;
	private ValoresReferencia valores = new ValoresReferencia(0, 0);
	private List<Leitura> leituras = new ArrayList<>();
	private PropertyChangeSupport support;
	
	/**
	 * Construtor
	 * @param carac
	 */
	public CaracteristicaContexto(DescricaoCaracteristica carac) {
		this.carac = carac;
		this.support = new PropertyChangeSupport(this);
		
	}
	
	/**
	 * 
	 * @param evt
	 */
	public void addPropertyChangeListener(PropertyChangeListener evt) {
        support.addPropertyChangeListener(evt);
    }

	/**
	 * 
	 * @param evt
	 */
    public void removePropertyChangeListener(PropertyChangeListener evt) {
        support.removePropertyChangeListener(evt);
    }

	public void associaSensor(Sensor sens) {
	}

	/**
	 * 
	 * @param i
	 * @param j
	 */
	public void registaValoresRef(int i, int j) {
		valores.regMin(i);
		valores.regMax(j);
	}

	/**
	 * 
	 * @return nome da Caracteristica
	 */
	public String nomeCaracteristica() {
		return carac.obtemDesignacao();
	}

	public void addObserver(Contexto contexto) {
		
	}

	/**
	 * 
	 * @param unidade
	 * @return verifica se é essa a unidade de medida
	 */
	public boolean definirUnidadeCorrenteLeitura(String unidade) {
		String abrev = carac.obtemAbrevitaturaUnidade();
		return unidade.equals(abrev);
	}
	
	/**
	 * 
	 * @return abreviatura da UnidadeMedida
	 */
	public String abreviaturaUnidade() {
		return carac.obtemAbrevitaturaUnidade();
	}
	
	/**
	 * 
	 * @return valores
	 */
	public ValoresReferencia getValores() {
		return valores;
	};
	
	/**
	 * 
	 * @param leitura
	 * adiciona leitura
	 */
	public void addLeitura(Leitura leitura) {
		leituras.add(leitura);
	}

	/**
	 * 
	 * @param ano
	 * @param mes
	 * @param dia
	 * @param valor
	 * @param contexto
	 * regista leitura
	 */
	public void registarLeitura(int ano, int mes, int dia, double valor, String contexto) {			
			
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
