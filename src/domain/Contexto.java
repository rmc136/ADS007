package domain;

import java.util.HashMap;
import java.util.List;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Map;

public class Contexto {
	
	private String designacao;
	private Map<String,CaracteristicaContexto> carcons;
	private CaracteristicaContexto corrente;
	private PropertyChangeSupport change;
    // ...

	public Contexto(String desig) {
		carcons = new HashMap<>();
		designacao = desig;
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
			}
		}
		if(cc == null) {
			result.put(null, b1);
            
		}else {
			b1 = cc.definirUnidadeCorrenteLeitura(unidade);
			System.out.println(b1);
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

	public void registarLeitura(int ano, int mes, int dia, double valor) {
		
		String uni = corrente.abreviaturaUnidade(); 
		Leitura l = new Leitura(ano,mes,dia,valor,uni);
		ValoresReferencia valores = corrente.getValores();
		corrente.addLeitura(l);
		boolean k = valores.estahNoIntervalo(valor) == 0;
		
		if(k) {
			int i = valores.estahNoIntervalo(valor);
			if(i>0) {
				change.firePropertyChange("acima", k, l);
			}else {
				change.firePropertyChange("abaixo", k, l);
			}
		}
	}
}
