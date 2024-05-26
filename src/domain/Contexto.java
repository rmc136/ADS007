package domain;

import java.util.HashMap;
import java.util.List;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Map;

import domain.alertas.IEventoAlerta;

public class Contexto implements PropertyChangeListener{
	
	private String designacao;
	private Map<String,CaracteristicaContexto> carcons;
	private CaracteristicaContexto corrente;
	private PropertyChangeSupport change;
	private PropertyChangeEvent property;
	private PropertyChangeSupport support;
    // ...

	public Contexto(String desig) {
		carcons = new HashMap<>();
		designacao = desig;
		this.support = new PropertyChangeSupport(this);
		// ...
	}

	public void adicionaCaracteristica(CaracteristicaContexto carCont) {
		carcons.put(carCont.nomeCaracteristica(), carCont);
		carCont.addObserver(this);
	}

	public String obtemDesignacao() {
		return designacao;
	}

	public void addObserver(Utilizador utilizador) {
		// TODO Auto-generated method stub
		
	}
	
	//PROVAVELMENTE TÁ MAL
	public Map<CaracteristicaContexto, Object> definirCaractUniCorrente(String nome, String unidade) {
		CaracteristicaContexto cc = null;
		boolean b1 = false;
		Map<CaracteristicaContexto, Object> result = new HashMap<>();
		
		for(String key: carcons.keySet()) {
			if(key.equals(nome)) {
				cc = carcons.get(key);
				corrente = cc;
				change = new PropertyChangeSupport(corrente);
			}
		}
		if(cc == null) {
			result.put(null, b1);
            
		}else {
			b1 = cc.definirUnidadeCorrenteLeitura(unidade);
			result.put(cc, b1);

		}		
		return result;
	}

	public List<Par<String, String>> ObtemCaracteristcaUnidade() {
		
		List<Par<String, String>> carUniList = new ArrayList<Par<String, String>>(); 
		for(String key: carcons.keySet()) {
			CaracteristicaContexto cc = carcons.get(key);
			if(cc == null) {
				return null;
			}else {
				
			String desig = cc.nomeCaracteristica();
			String uni = cc.abreviaturaUnidade();
			Par<String, String> desigUni = new Par<>(desig,uni);
			carUniList.add(desigUni);
			}
		}
		return carUniList;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener evt) {
        support.addPropertyChangeListener(evt);
    }

    public void removePropertyChangeListener(PropertyChangeListener evt) {
        support.removePropertyChangeListener(evt);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof IEventoAlerta) {
            IEventoAlerta evento = (IEventoAlerta) evt.getNewValue();
            evento.adicionaContexto(designacao);
            support.firePropertyChange("alertaContexto", null, evento);
        }
    }

	public void registarLeitura(int ano, int mes, int dia, double valor, String designacao) {
		
		corrente.registarLeitura(ano, mes, dia,valor, designacao);
		
	}
}
