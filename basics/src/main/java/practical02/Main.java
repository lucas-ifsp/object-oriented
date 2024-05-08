package practical02;

import java.util.Optional;
import java.util.Scanner;

import static practical02.GastoRepository.nextId;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    void main() {


        Main main = new Main();

        while (true) {
            try {
                final int opcao = main.obterOpcao();
                if (opcao == 5) break;
                switch (opcao) {
                    case 1 -> main.iniciaDeclaracao();
                    case 2 -> main.adicionaGasto();
                    case 3 -> main.removeGasto();
                    case 4 -> main.calculaImposto();
                    default -> throw new IllegalStateException(STR."Unexpected value: \{opcao}");
                }
            } catch (Exception e) {
                System.out.println(e.getClass().getSimpleName());
                System.out.println(e.getMessage());
            }
        }
    }

    private void iniciaDeclaracao() {
        System.out.print("Ganho tributável: ");
        final double ganho = Double.parseDouble(scanner.nextLine());
        System.out.print("Valor já pago: ");
        final double pago = Double.parseDouble(scanner.nextLine());

        DeclaracaoService service = new DeclaracaoService(new InMemoryDeclaracaoRepository());
        service.iniciarDeclaracao(ganho, pago);
    }

    private void adicionaGasto() {

        InMemoryDeclaracaoRepository declaracaoRepository = new InMemoryDeclaracaoRepository();
        final Optional<Declaracao> declaracao = declaracaoRepository.buscar(2);

        if (declaracao.isEmpty()) {
            System.out.println("Declacação não encontrada. Selecione opção 1.");
            return;
        }

        DeclaracaoCompleta completa = (DeclaracaoCompleta) declaracao.get();

        System.out.print("Descrição: ");
        final String descricao = scanner.nextLine();

        System.out.print("CNPJ: ");
        final String cnpj = scanner.nextLine();

        System.out.print("Valor: ");
        final double valor = Double.parseDouble(scanner.nextLine());

        System.out.print("[1] Saúde | [2] Educação: ");
        final int tipo = Integer.parseInt(scanner.nextLine());

        Gasto gasto;
        if (tipo == 1) {
            System.out.print("Registro Conselho: ");
            final String conselho = scanner.nextLine();
            gasto = new GastoSaude(nextId(), valor, descricao, cnpj, conselho);
        } else if (tipo == 2) {
            System.out.print("Nome Instituição: ");
            final String instituicao = scanner.nextLine();
            gasto = new GastoEducacao(nextId(), valor, descricao, cnpj, instituicao);
        } else {
            System.out.println("Tipo inválido!");
            return;
        }
        GastoRepository2 repository = new GastoRepository2();
        repository.save(gasto);

        completa.addGasto(gasto);
    }

    private void removeGasto() {
        InMemoryDeclaracaoRepository declaracaoRepository = new InMemoryDeclaracaoRepository();
        final Optional<Declaracao> declaracao = declaracaoRepository.buscar(2);

        if (declaracao.isEmpty()) {
            System.out.println("Declacação não encontrada. Selecione opção 1.");
            return;
        }

        DeclaracaoCompleta completa = (DeclaracaoCompleta) declaracao.get();

        System.out.print("ID: ");
        final long id = Long.parseLong(scanner.nextLine());

        GastoRepository2 repository = new GastoRepository2();
        final Optional<Gasto> possivelGasto = repository.findById(id);
        if (possivelGasto.isEmpty()) {
            System.out.println(STR."Gasto não encontrado: \{id}");
            return;
        }
        repository.deleteByKey(id);

        completa.removeGasto(possivelGasto.get());
    }

    private void calculaImposto() {
        DeclaracaoService service = new DeclaracaoService(new InMemoryDeclaracaoRepository());
        final String result = service.getInformacaoImposto();

        if (result.isEmpty()){
            System.out.println("Declacação não encontrada. Selecione opção 1.");
        }else{
            System.out.println(result);
        }

    }

    private int obterOpcao() {
        int opcao = 0;
        do {
            System.out.println("==========================================");
            System.out.println("1. Iniciar declaração");
            System.out.println("2. Adicionar gasto");
            System.out.println("3. Remover gasto");
            System.out.println("4. Calcular imposto");
            System.out.println("5. Sair");
            System.out.println("==========================================");
            System.out.print("Opção > ");
            opcao = Integer.parseInt(scanner.nextLine());
        } while (opcao < 1 || opcao > 5);
        return opcao;
    }
}
