package domain.alertas;

import domain.Utilizador;

/**
 * Classe que define IAlertaAdapter
 * @author Nº 54600, Nº 60470, Nº 60859
 */
public interface IAlertaAdapter {
	
	/**
	 * 
	 * @param u
	 * @param ev
	 * envia Alerta
	 */
	void enviaAlerta (Utilizador u, IEventoAlerta ev);

}
