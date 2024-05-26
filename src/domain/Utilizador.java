package domain;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.alertas.AlertaAdapterFactory;
import domain.alertas.IAlertaAdapter;
import domain.alertas.IEventoAlerta;

/**
 * Classe que define Utilizador
 * @author Nº 54600, Nº 60470, Nº 60859
 */
public abstract class Utilizador implements PropertyChangeListener{
	
	private String nome, pwd, email;
	private Map<String,Contexto> contextosAssociado;

	/**
	 * Construtor
	 * @param nome
	 */
	public Utilizador (String nome) {
		contextosAssociado = new HashMap<>();
		this.nome = nome;		
	}
	
	/**
	 * 
	 * @param pwd2
	 * define a password
	 */
	public void definirPassword(String pwd2) {
		pwd = pwd2;		
	}

	/**
	 * 
	 * @return nome
	 */
	public String obtemNome() {
		return nome;
	}
	
	/**
	 * 
	 * @return password
	 */
	public String obtemPassword() {
		return pwd;
	}
 
	/**
	 * 
	 * @param pwd2
	 * @return verifica se a password esta correta
	 */
	public boolean pwdCorreta(String pwd2) {
       return pwd2.equals(pwd);
	}
	
	/**
	 * 
	 * @param contCorr
	 * associa ao contexto
	 */
	public void ficasAssociado(Contexto contCorr) {
		contextosAssociado.put(contCorr.obtemDesignacao(), contCorr);
		contCorr.addObserver(this);		
	}
	
	/**
	 * 
	 * @return lista de contextos associados
	 */
	public Iterable<String>nomesContextosAssociados(){
		
		List<String> listaNomes = new ArrayList<>();
        if (contextosAssociado.size() == 0) {
        	return null;
        }
        for (String key : contextosAssociado.keySet()) {
            listaNomes.add(key);
        }
        return listaNomes;
		
	}

	/**
	 * 
	 * @param ctx
	 * @return verifica se esta associado
	 */
	public boolean estaAssociado(Contexto ctx) {
		// TODO Auto-generated method stub
		for (Contexto contexto : contextosAssociado.values()) {
            if (contexto.equals(ctx)) {
                return true;
            }
        }
        return false;
	}
	
	@Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof IEventoAlerta) {
            IEventoAlerta evento = (IEventoAlerta) evt.getNewValue();
            IAlertaAdapter alertaAdapter = AlertaAdapterFactory.getInstance().getAlertaAdapter();
            alertaAdapter.enviaAlerta(this, evento);
        }
    }
}
