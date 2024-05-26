package domain.handlers;

import domain.interfaces.ILogoutHandler;
import services.SessionManager;

/**
 * Classe que define LogoutHandler
 * @authors Nº 54600, Nº 60470, Nº 60859
 */
public class LogoutHandler implements ILogoutHandler{

	@Override
	public void logout() {
		SessionManager.getInstance().deleteSession();
		
	}

}
