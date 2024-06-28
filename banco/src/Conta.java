public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;

    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;

    public Conta() {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
    }

    protected void imprimirExtrato() {
        System.out.println(String.format("Agencia: %d", this.agencia));

        System.out.println(String.format("Conta: %d", this.numero));

        System.out.println(String.format("Saldo: %2.f", this.saldo));
    }
    

    public void sacar(double valor) {
            saldo -= valor;
        }

    
    
    public void depositar(double valor) {
        saldo += valor;
    }
    
    public void transferir(double valor, Conta contaDestino) {
        contaDestino.depositar(valor);
    }

    public double getSaldo() {
        return saldo;
    }

    public int getAgencia() {
        return agencia;
    } 

    public int getNumeroConta() {
        return numero;
    }



}
