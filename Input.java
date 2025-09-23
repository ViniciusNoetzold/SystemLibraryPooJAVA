import java.util.Scanner;

public class Input {
    public static String lerString(String prompt, Scanner leitor) {
        while (true) {
            System.out.print(prompt);
            String entrada = leitor.nextLine();
            entrada = entrada.trim();

            if (entrada.isEmpty())
                System.out.println("Entrada inválida! O campo não pode ser vazio.");
            else
                return entrada;
        }
    }

    public static int lerInt(String prompt, Scanner leitor) {
        while (true) {
            try {
                System.out.print(prompt);
                int valor = leitor.nextInt();
                return valor;
            } catch (Exception e) {
                System.out.println("Entrada inválida! Por favor, digite um número inteiro.");
            } finally {
                leitor.nextLine();
            }
        }
    }

    public static double lerDouble(String prompt, Scanner leitor) {
        while (true) {
            try {
                System.out.print(prompt);
                double valor = leitor.nextDouble();
                return valor;
            } catch (Exception e) {
                System.out.println("Entrada inválida! Por favor, digite um número.");
            } finally {
                leitor.nextLine();
            }
        }
    }
}