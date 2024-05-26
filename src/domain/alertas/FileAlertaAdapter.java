package domain.alertas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import domain.Utilizador;

public class FileAlertaAdapter implements IAlertaAdapter{

	@Override
	public void enviaAlerta(Utilizador u, IEventoAlerta ev) {
		// TODO Auto-generated method stub
		String fileName = u.obtemNome() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Alerta para o utilizador: " + u.obtemNome() + "\n");
            writer.write("Data: " + ev.dia() + "/" + ev.mes() + "/" + ev.ano() + "\n");
            writer.write("Valor: " + ev.valor() + " " + ev.unidade() + "\n");
            writer.write("Característica: " + ev.caracteristica() + "\n");
            writer.write("Contexto: " + ev.contexto() + "\n");
            writer.write("Mensagem: " + ev.mensagem() + "\n");
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

}
