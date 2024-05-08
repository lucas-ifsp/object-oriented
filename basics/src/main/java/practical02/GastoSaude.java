package practical02;

public class GastoSaude extends Gasto {
    public static final double MAX_GASTO_SAUDE = 1_500;
    private String registroConselho;

    public GastoSaude(long id, double valor, String descricao, String cnpj, String registroConselho) {
        super(id, valor, descricao, cnpj);
        this.registroConselho = registroConselho;
    }

    @Override
    public String toString() {
        return STR."GASTO SAÚDE: \{super.toString()} | Registro Conselho = \{registroConselho}";
    }

    public String getRegistroConselho() {
        return registroConselho;
    }
}
