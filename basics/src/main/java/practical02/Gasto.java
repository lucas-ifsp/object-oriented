package practical02;

public abstract class Gasto implements Entity<Long>{
    private long id;
    private double valor;
    private String descricao;
    private String cnpj;

    public Gasto(long id, double valor, String descricao, String cnpj) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.cnpj = cnpj;
    }

    @Override
    public Long key() {
        return getId();
    }

    public long getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public String toString() {
        return STR."""
            Id = \{id} | Valor= \{valor} | Descricao= \{descricao} | CNPJ = \{cnpj}""";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gasto gasto = (Gasto) o;
        return id == gasto.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }
}
