import java.util.concurrent.ConcurrentHashMap;

public class Segretaria {
    private ConcurrentHashMap<String, Paziente> pazientiMap =
            new ConcurrentHashMap<>();
    public void comunicaPaziente(String nomePaziente, EsitoEsame esitoEsame){
        Paziente paziente = pazientiMap.get(nomePaziente);
        synchronized (paziente) {
            paziente.setEsito(esitoEsame);
            paziente.notify();
        }
    }

    public void registraPerEsito(Paziente paziente) {
        pazientiMap.put(paziente.getName(), paziente);
    }
}
