package practical02;

import static java.util.FormatProcessor.FMT;

public abstract class Declaracao implements Entity<Long>{
    private final long id;
    private double ganhoTributavel;
    private double valorPago;

    public Declaracao(long id, double ganhoTributavel, double valorPago) {
        this.id = id;
        this.ganhoTributavel = ganhoTributavel;
        this.valorPago = valorPago;
    }

    @Override
    public Long key() {
        return getId();
    }

    public final double getValorAPagar(){
        return getValorImposto() - valorPago - getDespesaDedutivel();
    }

    public double getDespesaDedutivel(){
        return 0;
    }

    public abstract double getValorImposto();


    @Override
    public String toString() {
        return FMT."Ganho Tributável = R$\{ganhoTributavel} | Valor Pago = R$\{valorPago} | Valor Imposto = R$%.2f\{getValorImposto()} | A pagar = R$%.2f\{getValorAPagar()}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Declaracao that = (Declaracao) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

    public long getId() {
        return id;
    }

    public double getGanhoTributavel() {
        return ganhoTributavel;
    }

    public double getValorPago() {
        return valorPago;
    }
}
