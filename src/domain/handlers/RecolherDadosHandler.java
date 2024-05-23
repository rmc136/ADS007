package domain.handlers;

import domain.interfaces.IRecolherDadosHandler;
import java.util.List;
import domain.CatalogoContextos;
import domain.Contexto;
import domain.Utilizador;

public class RecolherDadosHandler implements IRecolherDadosHandler{

	private CatalogoContextos catalogoC;
	private Iterable<String> listaContexto;
	private Utilizador utilizador;
	private Contexto ctx;
	
	public RecolherDadosHandler(Utilizador utilizador, CatalogoContextos catalogoC) {
		
		this.catalogoC = catalogoC;
		this.utilizador = utilizador;
	}
	@Override
	public Iterable<String> iniciarRecolha() {
		// TODO Auto-generated method stub
		listaContexto = utilizador.nomesContextosAssociados();
		return listaContexto;
	}

	@Override
	public boolean indicarContexto(String nome) {
		ctx = catalogoC.obtemContexto(nome);
		if(ctx == null){
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean indicarCaracteristica(String nome, String unidade) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Iterable<String> obtemCaracteristicasUnidades() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void indicarLeitura(int ano, int mes, int dia, double valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelar() {
		// TODO Auto-generated method stub
		
	}

}
