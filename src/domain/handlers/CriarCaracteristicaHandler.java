package domain.handlers;

import domain.interfaces.ICriarCaracteristicaHandler;
import domain.DescricaoCaracteristica;
import domain.CatalogoDescricaoCaracteristicas;
import domain.CatalogoTiposSensor;
import domain.TipoSensor;
import domain.CatalogoUnidades;
import domain.UnidadeMedida;

/**
 * Classe que define CriarCaracteristicaHandler
 * @author Nº 54600, Nº 60470, Nº 60859
 */
public class CriarCaracteristicaHandler implements ICriarCaracteristicaHandler {
	
	private CatalogoDescricaoCaracteristicas catalogoDc = new CatalogoDescricaoCaracteristicas();
	private CatalogoTiposSensor catalogoTs = new CatalogoTiposSensor();
	private CatalogoUnidades catalogoU = new CatalogoUnidades();
	private TipoSensor tipoSensor;
	private DescricaoCaracteristica caracteristica;
	private UnidadeMedida unidade;
	
	/**
	 * Construtor
	 * @param catalogoDc
	 * @param catalogoTs
	 * @param catalogoU
	 */
    public CriarCaracteristicaHandler(CatalogoDescricaoCaracteristicas catalogoDc, CatalogoTiposSensor catalogoTs, CatalogoUnidades catalogoU) {
        this.catalogoDc = catalogoDc;
        this.catalogoTs = catalogoTs;
        this.catalogoU = catalogoU;

    }
	@Override
	public boolean criarCaracteristica(String desig) {
		
		if (catalogoDc.existeCaracteristica(desig)) {
			return false;
		}
		DescricaoCaracteristica dc = new DescricaoCaracteristica(desig);
		caracteristica = dc;
		return true;
	}

	@Override
	public Iterable<String> obterTiposSensor() {
		
		return catalogoTs.nomesTiposSensor();
	}

	@Override
	public boolean indicarTipoSensor(String tipo) {
		TipoSensor ts = catalogoTs.obtemTipoSensor(tipo);
		if(ts == null) {
			return false;
		}
		tipoSensor = ts;
		caracteristica.associaTipoSensor(ts);
		return true;
	}

	@Override
	public Iterable<String> obterUnidadesMedida() {
		return tipoSensor.obtemNomesUnidades();
	}

	@Override
	public boolean indicarUnidade(String abrev) {
		UnidadeMedida uni = catalogoU.obtemUnidade(abrev);
		if(uni == null) {
			return false;
		}
		unidade = uni;
		caracteristica.defineUnidadeMedida(uni);
		return true;
	}

	@Override
	public void confirmar() {
		catalogoDc.adicionaCaracteristica(caracteristica);
		
	}

	@Override
	public void cancelar() {		
		
	}

}
