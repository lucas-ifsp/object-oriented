package practical02;

import java.util.ArrayList;
import java.util.List;

public final class DeclaracaoCompleta extends Declaracao {
    private final List<Gasto> gastos;

    public DeclaracaoCompleta(long id, double ganhoTributavel, double valorPago) {
        super(id, ganhoTributavel, valorPago);
        this.gastos = new ArrayList<>();
    }

    @Override
    public double getValorImposto() {
        double valorRestante = getGanhoTributavel();
        double valorImposto = 0;

        if(valorRestante > 55_976.16){
            valorImposto += (valorRestante - 55_976.16) * 0.275;
            valorRestante = 55_976.16;
        }
        if(valorRestante > 45_012.73){
            valorImposto += (valorRestante - 45_012.73) * 0.225;
            valorRestante = 45_012.73;
        }
        if(valorRestante > 33_919.93){
            valorImposto += (valorRestante - 33_919.93) * 0.15;
            valorRestante = 33_919.93;
        }
        if(valorRestante > 22_847.88){
            valorImposto += (valorRestante - 22_847.88) * 0.075;
        }
        return valorImposto;
    }

    @Override
    public double getDespesaDedutivel() {
        final double gastoEducacao = gastos.stream()
                .filter(g -> g instanceof GastoEducacao)
                .mapToDouble(Gasto::getValor)
                .sum();

        final double gastoSaude = gastos.stream()
                .filter(g -> g instanceof GastoSaude)
                .mapToDouble(Gasto::getValor)
                .sum();

        return Math.min(gastoEducacao, GastoEducacao.MAX_GASTO_EDUCACAO) +
                Math.min(gastoSaude, GastoSaude.MAX_GASTO_SAUDE);
    }

    public void adicionarGasto(Gasto gasto) {
        gastos.add(gasto);
    }

    public void removerGasto(Long id) {
        gastos.removeIf(gasto -> gasto.getId() == id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Declaração Completa\n");
        sb.append(super.toString()).append("\n");
        gastos.forEach(g -> sb.append(g).append("\n"));
        return sb.toString();
    }
}
