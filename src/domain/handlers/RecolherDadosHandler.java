package domain.handlers;

import domain.interfaces.IRecolherDadosHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import domain.CaracteristicaContexto;
import domain.CatalogoContextos;
import domain.Contexto;
import domain.Utilizador;
import domain.Par;

/**
 * Classe que define RecolherDadosHandler
 * @author Nº 54600, Nº 60470, Nº 60859
 */
public class RecolherDadosHandler implements IRecolherDadosHandler{

	private CatalogoContextos catalogoC = new CatalogoContextos();
	private Iterable<String> listaContexto;
	private Utilizador utilizador;
	private Contexto ctx;
	private CaracteristicaContexto cc;
	private List<String> carUni;
	
	/**
	 * Construtor
	 * @param utilizador
	 * @param catalogoC
	 */
	public RecolherDadosHandler(Utilizador utilizador, CatalogoContextos catalogoC) {
		
		this.catalogoC = catalogoC;
		this.utilizador = utilizador;
	}
	@Override
	public Iterable<String> iniciarRecolha() {
		listaContexto = utilizador.nomesContextosAssociados();
		return listaContexto;
	}

	@Override
	public boolean indicarContexto(String nome) {
		ctx = catalogoC.obtemContexto(nome);
		if(ctx == null){
			return false;
		}
		return utilizador.estaAssociado(ctx);
	}
	
	@Override
	public boolean indicarCaracteristica(String nome, String unidade) {
		
		Map<CaracteristicaContexto, Object> b = ctx.definirCaractUniCorrente(nome, unidade);
	    
	    if (b != null && !b.isEmpty()) {
	        Map.Entry<CaracteristicaContexto, Object> entry = b.entrySet().iterator().next();
	        cc = entry.getKey();
	        Object value = entry.getValue();
	        
	        return value instanceof Boolean && (Boolean) value;
	    }
	    
	    return false;
	}
	
	@Override
	public Iterable<String> obtemCaracteristicasUnidades() {
		List<Par<String,String>> carUniList = ctx.ObtemCaracteristcaUnidade();
		List<String> resultList = new ArrayList<>();
		
		for (Par<String, String> pair : carUniList) {
	        String concatenated = pair.primeiro() + " - " + pair.segundo();
	        resultList.add(concatenated);
	    }
		carUni = resultList;
		return resultList;
	}


	@Override
	public void indicarLeitura(int ano, int mes, int dia, double valor) {		
		ctx.registarLeitura(ano, mes, dia, valor, ctx.obtemDesignacao());
		
	}

	@Override
	public void cancelar() {
		
	}

}
