package Projeto;

import java.util.Scanner;

public class MenuCalculadora {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Calculadora calc = new Calculadora();
        boolean continuar = true;

        while (continuar) {
            // Menu visual formatado como uma caixa
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("|                             |");
            System.out.println("|=-=-=-=- CALCULADORA -=-=-=-=|");
            System.out.println("|                             |");
            System.out.println("|Escolha a Operação:          |");
            System.out.println("|                             |");
            System.out.println("|1 - SOMAR                    |");
            System.out.println("|2 - SUBTRAIR                 |");
            System.out.println("|3 - MULTIPLICAR              |");
            System.out.println("|4 - DIVIDIR                  |");
            System.out.println("|0 - SAIR                     |");
            System.out.println("|                             |");
            System.out.println("|=-=-=-=-=-=-=-=-=-=-=-=-=-=-=|");
            System.out.println("|                             |");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println();

            int opcao = -1;
            while (true) {
                System.out.print("Digite a Opção (1/2/3/4/0): ");
                if (scanner.hasNextInt()) {
                    opcao = scanner.nextInt();
                    if (opcao >= 0 && opcao <= 4) {
                        break;
                    } else {
                        System.out.println();
                        System.out.println("Opção Inválida! Por favor, Escolha Entre 1 e 4.");
                    }
                } else {
                    System.out.println();
                    System.out.println("Entrada Inválida! Digite um Número de 1 a 4.");
                    scanner.next(); // limpa entrada inválida
                }
            }

            // Sair se a opção for 0
            if (opcao == 0) {
                System.out.println();
                System.out.println("Programa Encerrado. Obrigado!");
                break;
            }

            // Mostra a opção escolhida
            String nomeOperacao = switch (opcao) {
                case 1 -> "SOMAR";
                case 2 -> "SUBTRAIR";
                case 3 -> "MULTIPLICAR";
                case 4 -> "DIVIDIR";
                default -> "";
            };

            System.out.println();
            System.out.println("Opção Escolhida: " + opcao + " - " + nomeOperacao);
            System.out.println();

            // ===== VALIDAÇÃO DO PRIMEIRO NÚMERO =====
            System.out.print("Digite o Primeiro Número: ");
            double num1 = 0;
            while (true) {
                String inputNum1 = scanner.next();
                inputNum1 = inputNum1.replace(',', '.');
                try {
                    num1 = Double.parseDouble(inputNum1);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println();
                    System.out.println("Entrada Inválida! Por favor, Digite um Número.");
                    System.out.print("Digite o Primeiro Número: ");
                }
            }

            // ===== VALIDAÇÃO DO SEGUNDO NÚMERO =====
            System.out.print("Digite o Segundo Número: ");
            double num2 = 0;
            while (true) {
                String inputNum2 = scanner.next();
                inputNum2 = inputNum2.replace(',', '.');
                try {
                    num2 = Double.parseDouble(inputNum2);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println();
                    System.out.println("Entrada Inválida! Por favor, Digite um Número.");
                    System.out.print("Digite o Segundo Número: ");
                }
            }

            System.out.println();

            double resultado = 0;

            try {
                switch (opcao) {
                    case 1:
                        resultado = calc.somar(num1, num2);
                        System.out.println("Você Escolheu SOMAR: " + formatNumero(num1) + " + " + formatNumero(num2));
                        break;
                    case 2:
                        resultado = calc.subtrair(num1, num2);
                        System.out.println("Você Escolheu SUBTRAIR: " + formatNumero(num1) + " - " + formatNumero(num2));
                        break;
                    case 3:
                        resultado = calc.multiplicar(num1, num2);
                        System.out.println("Você Escolheu MULTIPLICAR: " + formatNumero(num1) + " * " + formatNumero(num2));
                        break;
                    case 4:
                        resultado = calc.dividir(num1, num2);
                        System.out.println("Você Escolheu DIVIDIR: " + formatNumero(num1) + " / " + formatNumero(num2));
                        break;
                }

                System.out.println("Resultado: " + formatNumero(resultado));
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }

            String resposta;
            do {
                System.out.print("Deseja Realizar Outra Operação? (S/N): ");
                resposta = scanner.next();
                System.out.println(); // pula linha após digitar

                if (!resposta.equalsIgnoreCase("S") && !resposta.equalsIgnoreCase("N")) {
                    System.out.println("Opção Inválida! Por favor, Digite 'S' para Sim ou 'N' para Não.");
                    System.out.println();
                }
            } while (!resposta.equalsIgnoreCase("S") && !resposta.equalsIgnoreCase("N"));

            if (resposta.equalsIgnoreCase("N")) {
                continuar = false;
                System.out.println("Programa Encerrado. Obrigado!");
            }
        }

        scanner.close();
    }

    private static String formatNumero(double num) {
        if (num == (long) num) {
            return String.format("%d", (long) num);
        } else {
            return String.format("%s", num);
        }
    }
}