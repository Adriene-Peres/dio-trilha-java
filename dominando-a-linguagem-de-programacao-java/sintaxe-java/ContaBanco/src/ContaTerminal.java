import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
       Scanner entrada = new Scanner(System.in).useLocale(Locale.US);
             
        System.out.print("Por favor, digite o número da Agência: ");
        String agencia = entrada.nextLine();
        System.out.println();

        System.out.print("Por favor, digite o nome do cliente: ");
        String nome = entrada.nextLine();
        System.out.println();

        System.out.print("Por favor, digite o número da conta: ");
        int numero = entrada.nextInt();
        System.out.println();
        
        System.out.print("Por favor, digite o saldo da conta: ");
        double saldo = entrada.nextDouble();
        System.out.println();

        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque", nome, agencia, numero, saldo);

        entrada.close();

    }
}
