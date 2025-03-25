package practical02;

public final class GastoEducacao extends Gasto {
    public static final double MAX_GASTO_EDUCACAO = 2_000.0;
    private String nomeInstituicao;

    public GastoEducacao(long id, String descricao, String cnpj, double valor, String nomeInstituicao) {
        super(id, descricao, cnpj, valor);
        this.nomeInstituicao = nomeInstituicao;
    }

    @Override
    public String toString() {
        return "Gasto com Educação | " + super.toString() + " | " + this.nomeInstituicao;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }
}
