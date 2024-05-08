package practical02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DeclaracaoCompleta extends Declaracao{

    private final List<Gasto> gastos = new ArrayList<>();

    public DeclaracaoCompleta(long id, double ganhoTributavel, double valorPago) {
        super(id, ganhoTributavel, valorPago);
    }

    @Override
    public double getDespesaDedutivel() {
        final double gastosEducacao = gastos.stream()
                .filter(g -> g instanceof GastoEducacao)
                .mapToDouble(Gasto::getValor)
                .sum();
        final double gastosSaude = gastos.stream()
                .filter(g -> g instanceof GastoSaude)
                .mapToDouble(Gasto::getValor)
                .sum();
        return Math.min(gastosEducacao, GastoEducacao.MAX_GASTO_EDUCACAO)
                + Math.min(gastosSaude, GastoSaude.MAX_GASTO_SAUDE);
    }

    @Override
    public double getValorImposto() {
        double ganho = getGanhoTributavel();
        double imposto = 0;
        if(ganho > 55_976.16){
            imposto = (ganho - 55_976.16) * 0.275;
            ganho = 55_976.16;
        }
        if(ganho >= 45_012.73){
            imposto += (ganho - 45_012.73) * 0.225;
            ganho = 45_012.72;
        }
        if(ganho >= 33_919.93){
            imposto += (ganho - 33_919.93) * 0.15;
            ganho = 33_919.92;
        }
        if(ganho >= 22_847.88){
            imposto += (ganho - 22_847.88) * 0.075;
        }
        return imposto;
    }

    public void addGasto(Gasto gasto) {
        Objects.requireNonNull(gasto, "Gasto não pode ser nulo.");
        gastos.add(gasto);
    }

    public void removeGasto(Gasto gasto) {
        gastos.remove(gasto);
    }

    @Override
    public String toString() {
        final String dedutiveis = gastos.stream().map(Gasto::toString).collect(Collectors.joining("\n"));
        final double somaGastosDedutiveis = gastos.stream().mapToDouble(Gasto::getValor).sum();
        return STR."""
                DECLARAÇÃO COMPLETA
                Gastos Dedutíveis:
                \{dedutiveis}
                -----------------------------
                Total Dedutível = R$ \{somaGastosDedutiveis}
                -----------------------------
                \{super.toString()}
                """;
    }
}
