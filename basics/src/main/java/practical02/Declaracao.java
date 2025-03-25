package practical02;

import java.util.Objects;

public sealed abstract class Declaracao permits DeclaracaoCompleta, DeclaracaoSimplificada{
    private long id;
    private double valorPago;
    private double ganhoTributavel;

    public Declaracao(long id, double ganhoTributavel, double valorPago) {
        this.id = id;
        this.valorPago = valorPago;
        this.ganhoTributavel = ganhoTributavel;
    }

    public final double getValorAPagar(){
        return getValorImposto() - valorPago - getDespesaDedutivel();
    }

    public abstract double getValorImposto() ;

    public double getDespesaDedutivel() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Ganho tributável = %.2f | Valor pago = %.2f | Valor a pagar = %.2f",
                ganhoTributavel, valorPago, getValorAPagar());
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
        return Objects.hashCode(id);
    }

    public long getId() {
        return id;
    }

    public double getValorPago() {
        return valorPago;
    }

    public double getGanhoTributavel() {
        return ganhoTributavel;
    }
}
