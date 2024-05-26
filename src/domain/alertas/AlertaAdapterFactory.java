package domain.alertas;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AlertaAdapterFactory {
    private static AlertaAdapterFactory instance;
    private IAlertaAdapter alertaAdapter;

    private AlertaAdapterFactory() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("configuracao.properties")) {
            if (input == null) {
                System.out.println("Desculpe, não foi possível encontrar o arquivo configuracao.properties");
                alertaAdapter = new SysOutAlertaAdapter();
                return;
            }
            properties.load(input);
            String adapterClassName = properties.getProperty("alertaAdapter");
            try {
                Class<?> adapterClass = Class.forName(adapterClassName);
                alertaAdapter = (IAlertaAdapter) adapterClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                alertaAdapter = new SysOutAlertaAdapter();
            }
        } catch (IOException e) {
            e.printStackTrace();
            alertaAdapter = new SysOutAlertaAdapter();
        }
    }

    public static AlertaAdapterFactory getInstance() {
        if (instance == null) {
            instance = new AlertaAdapterFactory();
        }
        return instance;
    }

    public IAlertaAdapter getAlertaAdapter() {
        return alertaAdapter;
    }
}