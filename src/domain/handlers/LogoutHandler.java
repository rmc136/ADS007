package domain.handlers;

import domain.interfaces.ILogoutHandler;
import services.SessionManager;

public class LogoutHandler implements ILogoutHandler{

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		SessionManager.getInstance().deleteSession();
		
	}

}
