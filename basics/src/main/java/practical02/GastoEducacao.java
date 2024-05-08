package practical02;

public class GastoEducacao extends Gasto{
    public static final double MAX_GASTO_EDUCACAO = 2_000;
    private String nomeInstituicao;

    public GastoEducacao(long id, double valor, String descricao, String cnpj, String nomeInstituicao) {
        super(id, valor, descricao, cnpj);
        this.nomeInstituicao = nomeInstituicao;
    }

    @Override
    public String toString() {
        return STR."GASTO EDUCAÇÃO: \{super.toString()} | Nome instituição = \{nomeInstituicao}";
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }
}
