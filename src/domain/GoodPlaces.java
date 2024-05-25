package domain;


import domain.handlers.CriarCaracteristicaHandler;
import domain.handlers.LoginHandler;
import domain.handlers.LogoutHandler;
import domain.handlers.RecolherDadosHandler;
import domain.interfaces.ICriarCaracteristicaHandler;
import domain.interfaces.IGoodPlaces;
import domain.interfaces.ILoginHandler;
import domain.interfaces.ILogoutHandler;
import domain.interfaces.IRecolherDadosHandler;
import services.SessionManager;

/**
 * Classe que define o objeto inicial da aplicacao
 * 
 * @author ADS
 */
public class GoodPlaces implements IGoodPlaces {
	private CatalogoDescricaoCaracteristicas catDescrCaract;
	private CatalogoContextos catContexts;
	private CatalogoUtilizadores catUser;
	private CatalogoTiposSensor catTiposSensor;
	private CatalogoUnidades catUnidades;

    /**
     * Construtor
     */
	public GoodPlaces() {
    	catUser = new CatalogoUtilizadores();       // Ja' sao criados alguns utilizadore
    	catUnidades = new CatalogoUnidades();       // Ja' sao criadas algumas unidades
    	catTiposSensor = new CatalogoTiposSensor();
    	catDescrCaract = new CatalogoDescricaoCaracteristicas();
    	catContexts = new CatalogoContextos();
    	// Criar alguns objetos necessarios para testar os casos de uso UC6
    	// e UC11 porque os outros casos de uso não estao ainda implementados:
    	catTiposSensor.loadSomeTipoSensor(catUnidades); // Cria 4 Tipos de sensor e sensores associados
    	catDescrCaract.loadSomeDescCar(catTiposSensor, catUnidades);  // Cria 2 caracteristicas
    	catContexts.loadSomeContexts(catDescrCaract, catUser);   // Cria dois contextos
    }
    
	@Override
	public String obtemTipoUserAutenticado() {
		return getAuthenticatedUser().getClass().getName().substring(7);
	}

	private Utilizador getAuthenticatedUser() {
		String nome = SessionManager.getInstance().getAuthenticatedUser();
		Utilizador uAut = catUser.obtemUtilizador(nome);
		
		return uAut;
	}

	@Override
	public ILoginHandler obtemLoginHandler() {
		LoginHandler h = new LoginHandler();
		return h;
	}

	@Override
	public ICriarCaracteristicaHandler obtemCriarCaracteristicaHandler() {
		Utilizador uAut = getAuthenticatedUser();
		CriarCaracteristicaHandler h = new CriarCaracteristicaHandler(catDescrCaract, catTiposSensor, catUnidades);
		
		return h;
	}

	@Override
	public IRecolherDadosHandler obtemRecolherDadosHandler() {
		Utilizador uAut = getAuthenticatedUser();
		RecolherDadosHandler h = new RecolherDadosHandler(uAut, catContexts);
		
		return h;
	}

	@Override
	public ILogoutHandler obtemLogoutHandler() {
		LogoutHandler h = new LogoutHandler();
		return h;
	}

	public CatalogoUnidades obtemCatalogoUnidades() {
		// TODO Auto-generated method stub
		return catUnidades;
	}

}
