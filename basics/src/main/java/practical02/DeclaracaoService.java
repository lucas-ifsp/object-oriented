package practical02;

public class DeclaracaoService {
    private final DeclaracaoRepository repository;

    public DeclaracaoService(DeclaracaoRepository repository) {
        this.repository = repository;
    }

    public void iniciarDeclaracao(double rendaTributavel, double valorPago){
        final Declaracao simplificada = new DeclaracaoSimplificada(1, rendaTributavel, valorPago);
        final Declaracao completa = new DeclaracaoCompleta(2, rendaTributavel, valorPago);

        repository.salvar(simplificada);
        repository.salvar(completa);
    }

    public String getInformacaoImposto(){
        String result = "";
        result += repository.buscar(1).map(Declaracao::toString).orElse("") + "\n";
        result += repository.buscar(2).map(Declaracao::toString).orElse("") + "\n";

        return result;
    }
}
