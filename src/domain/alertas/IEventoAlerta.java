package domain.alertas;

/**
 * Classe que define IEventoAlerta
 * @author Nº 54600, Nº 60470, Nº 60859
 */
public interface IEventoAlerta {
	
	/**
	 * 
	 * @return ano
	 */
	int ano();
	
	/**
	 * 
	 * @return mes
	 */
	int mes();
	
	/**
	 * 
	 * @return dia
	 */
	int dia();
	
	/**
	 * 
	 * @return valor
	 */
	double valor();
	
	/**
	 * 
	 * @return unidade
	 */
	String unidade();
	
	/**
	 * 
	 * @return caracteristica
	 */
	String caracteristica();
	
	/**
	 * 
	 * @return contexto
	 */
	String contexto();
	
	/**
	 * 
	 * @return mensagem
	 */
	String mensagem();
	
	/**
	 * 
	 * @param contexto
	 * adiciona o Contexto
	 */
	void adicionaContexto(String contexto);
	
	
}
