public class ContaCorrente extends Conta{
    private double limiteExtra;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        this.limiteExtra = 200;
    }

    @Override
    public void sacar(double valor) {
        if (super.saldo >= valor || this.limiteExtra <= valor){
            saldo -= valor;
        }else{
            System.out.println("--Saldo indisponível\n");
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (super.saldo >= valor || this.limiteExtra<= valor){
            this.sacar(valor);
            contaDestino.depositar(valor);
        }else{
            System.out.println("--Saldo indisponível\n");
        }
    }

    public double getLimiteExtra() {
        return limiteExtra;
    }

    public void setLimiteExtra(double limiteExtra) {
        this.limiteExtra = limiteExtra;
    }

    @Override
    public void imprimirextrato() {
        System.out.println("*** Extrato Conta Corrente ***");
        imprimirInfosConta();
    }
}
