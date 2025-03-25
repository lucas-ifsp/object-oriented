package practical02;

public class RegistraDeclaracoesService {
    private DeclaracaoRepository repo;

    public RegistraDeclaracoesService(DeclaracaoRepository repo) {
        this.repo = repo;
    }

    public void register(double ganhoTributavel, double valorPago){
        if(ganhoTributavel < 0) throw new IllegalArgumentException("Ganho tributável inválido: " + ganhoTributavel);
        if(valorPago < 0) throw new IllegalArgumentException("Valor pago inválido: " + valorPago);

        var completa = new DeclaracaoCompleta(1, ganhoTributavel, valorPago);
        var simplificada = new DeclaracaoSimplificada(2, ganhoTributavel, valorPago);

        repo.save(completa);
        repo.save(simplificada);
    }
}
