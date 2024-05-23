package domain.handlers;

import domain.interfaces.ICriarCaracteristicaHandler;
import domain.DescricaoCaracteristica;
import domain.CatalogoDescricaoCaracteristicas;
import domain.CatalogoTiposSensor;
import domain.TipoSensor;
import domain.CatalogoUnidades;
import domain.UnidadeMedida;

public class CriarCaracteristicaHandler implements ICriarCaracteristicaHandler {
	
	private CatalogoDescricaoCaracteristicas catalogoDc;
	private CatalogoTiposSensor catalogoTs;
	private CatalogoUnidades catalogoU;
	private TipoSensor tipoSensor;
	private String caracteristica;
	private UnidadeMedida unidade;
	

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
		caracteristica = desig;
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
		DescricaoCaracteristica dc = catalogoDc.obtemCaracteristica(caracteristica);
		tipoSensor = ts;
		dc.associaTipoSensor(ts);
		return true;
	}

	@Override
	public Iterable<String> obterUnidadesMedida() {
		//É PRECISO FAZER A FUNCAO List<String> obtemNomesUnidades() no TipoSensor que devolve as Unidades de Medida de todos os sensores daquele tipo?
		return tipoSensor.obtemNomesUnidades();
	}

	@Override
	public boolean indicarUnidade(String abrev) {
		UnidadeMedida uni = catalogoU.obtemUnidade(abrev);
		if(uni == null) {
			return false;
		}
		DescricaoCaracteristica dc = catalogoDc.obtemCaracteristica(caracteristica);
		unidade = uni;
		dc.defineUnidadeMedida(uni);
		return true;
	}

	@Override
	public void confirmar() {
		// TODO Auto-generated method stub
		DescricaoCaracteristica dc = catalogoDc.obtemCaracteristica(caracteristica);
		catalogoDc.adicionaCaracteristica(dc);
		
	}

	@Override
	public void cancelar() {
		// TODO Auto-generated method stub
		
	}

}
