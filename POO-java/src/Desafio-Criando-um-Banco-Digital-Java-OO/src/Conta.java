public abstract class Conta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public abstract void sacar(double valor);

    public void depositar(double valor){
        saldo += valor;
    }

    public abstract void transferir(double valor, Conta contaDestino);

    public abstract void imprimirextrato();

    protected void imprimirInfosConta() {
        System.out.printf("Cliente: %s%n", this.cliente.getNome());
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Conta: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n%n", this.saldo);
    }


    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "{" + "agencia:" + agencia +
                ", cliente:" + cliente +
                ", número da conta:" + numero +
                ", saldo:" + saldo +
                '}';
    }
}
