public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco("abcd");
        Conta cc = new ContaCorrente(new Cliente("Maria", "55525689803"));
        banco.criarconta(cc);
        Conta cp = new ContaPoupanca(new Cliente("Joana", "12345678900"));
        banco.criarconta(cp);

        cc.depositar(100);
        cc.transferir(50, cp);
        cc.imprimirextrato();
        cp.imprimirextrato();
        System.out.println(banco.getContas());
    }
}
