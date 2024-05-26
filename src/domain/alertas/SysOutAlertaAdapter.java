package domain.alertas;

import domain.Utilizador;

/**
 * Classe que define SysOutAlertaAdapter
 * @author Nº 54600, Nº 60470, Nº 60859
 */
public class SysOutAlertaAdapter implements IAlertaAdapter{

	@Override
	public void enviaAlerta(Utilizador u, IEventoAlerta ev) {		
	        System.out.println("Alerta para o utilizador: " + u.obtemNome());
	        System.out.println("Data: " + ev.dia() + "/" + ev.mes() + "/" + ev.ano());
	        System.out.println("Valor: " + ev.valor() + " " + ev.unidade());
	        System.out.println("Característica: " + ev.caracteristica());
	        System.out.println("Contexto: " + ev.contexto());
	        System.out.println("Mensagem: " + ev.mensagem());
		
	}

}
