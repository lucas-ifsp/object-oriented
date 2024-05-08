package practical02;

public class DeclaracaoSimplificada extends Declaracao {

    public DeclaracaoSimplificada(long id, double ganhoTributavel, double valorPago) {
        super(id, ganhoTributavel, valorPago);
    }

    @Override
    public double getValorImposto() {

        return (Math.max(0, getGanhoTributavel() - 22_847.88)) * 0.2;
    }

    @Override
    public String toString() {
        return STR."""
                    DECLARAÇÃO SIMPLIFICADA
                    \{super.toString()}""";
    }
}
