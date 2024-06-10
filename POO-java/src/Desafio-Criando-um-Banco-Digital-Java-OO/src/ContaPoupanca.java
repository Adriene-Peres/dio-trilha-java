public class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }
    @Override
    public void sacar(double valor) {
        if (super.saldo >= valor){
            saldo -= valor;
        }else{
            System.out.println("--Saldo indisponível\n");
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (super.saldo >= valor){
            this.sacar(valor);
            contaDestino.depositar(valor);
        }else{
            System.out.println("--Saldo indisponível\n");
        }
    }

    @Override
    public void imprimirextrato() {
        System.out.println("*** Extrato Conta Poupança ***");
        imprimirInfosConta();;
    }
}
