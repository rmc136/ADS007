package domain.handlers;

import domain.CatalogoUtilizadores;
import domain.Utilizador;
import domain.interfaces.ILoginHandler;
import services.SessionManager;

/**
 * Classe que define LoginHandler
 * @author Nº 54600, Nº 60470, Nº 60859
 */
public class LoginHandler implements ILoginHandler{
	
	private CatalogoUtilizadores usersC = new CatalogoUtilizadores();
	
	@Override
	public boolean login(String nome, String pwd) {
		
		Utilizador u = usersC.obtemUtilizador(nome);
		if(u == null) {
			return false;
		}else {
			boolean b = u.pwdCorreta(pwd);
			if(b) {
				SessionManager.getInstance().createSession(nome);
				return b;
			}
		}
		return false;
	}

}
