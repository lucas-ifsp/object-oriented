package practical02;

public final class GastoSaude extends Gasto{
    public static final double MAX_GASTO_SAUDE = 1_500.0;
    private String registroConselho;

    public GastoSaude(long id, String descricao, String cnpj, double valor, String registroConselho) {
        super(id, descricao, cnpj, valor);
        this.registroConselho = registroConselho;
    }

    @Override
    public String toString() {
        return "Gasto com Saúde | " + super.toString() + " | " + this.registroConselho;
    }
}
