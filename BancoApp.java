import java.util.Scanner;

public class BancoApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgenciaBancaria agencia = new AgenciaBancaria(123);

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Criar nova conta");
            System.out.println("2. Realizar depósito");
            System.out.println("3. Realizar saque");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número da conta: ");
                    int numeroConta = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    System.out.print("Digite o nome do titular: ");
                    String nomeTitular = scanner.nextLine();
                    System.out.print("Digite o saldo inicial: ");
                    double saldoInicial = scanner.nextDouble();
                    ContaBancaria novaConta = new ContaBancaria(numeroConta, nomeTitular, saldoInicial);
                    agencia.adicionarConta(novaConta);
                    System.out.println("Conta criada com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o número da conta: ");
                    int numContaDeposito = scanner.nextInt();
                    ContaBancaria contaDeposito = agencia.buscarConta(numContaDeposito);
                    if (contaDeposito != null) {
                        System.out.print("Digite o valor do depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        contaDeposito.depositar(valorDeposito);
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o número da conta: ");
                    int numContaSaque = scanner.nextInt();
                    ContaBancaria contaSaque = agencia.buscarConta(numContaSaque);
                    if (contaSaque != null) {
                        System.out.print("Digite o valor do saque: ");
                        double valorSaque = scanner.nextDouble();
                        if (contaSaque.sacar(valorSaque)) {
                            System.out.println("Saque realizado com sucesso!");
                        } else {
                            System.out.println("Saldo insuficiente.");
                        }
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 4);

        scanner.close();
    }
}
