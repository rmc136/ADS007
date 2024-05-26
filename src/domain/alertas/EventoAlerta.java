package domain.alertas;

public class EventoAlerta implements IEventoAlerta {
    private int ano;
    private int mes;
    private int dia;
    private double valor;
    private String unidade;
    private String caracteristica;
    private String contexto;
    private String mensagem;

    public EventoAlerta(int ano, int mes, int dia, double valor, String unidade, String caracteristica, String contexto, String mensagem) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.valor = valor;
        this.unidade = unidade;
        this.caracteristica = caracteristica;
        this.contexto = contexto;
        this.mensagem = mensagem;
    }

    @Override
    public int ano() {
        return ano;
    }

    @Override
    public int mes() {
        return mes;
    }

    @Override
    public int dia() {
        return dia;
    }

    @Override
    public double valor() {
        return valor;
    }

    @Override
    public String unidade() {
        return unidade;
    }

    @Override
    public String caracteristica() {
        return caracteristica;
    }

    @Override
    public String contexto() {
        return contexto;
    }

    @Override
    public String mensagem() {
        return mensagem;
    }

    @Override
    public void adicionaContexto(String contexto) {
        this.contexto = contexto;
    }
}
