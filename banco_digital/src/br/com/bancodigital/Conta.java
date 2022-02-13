package br.com.bancodigital;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Conta implements IConta{
    private static final String AGENCIA_PADRAO = "Banco Boa Sorte";
    private static final String SAC = "0800 134 1515";
    private static final String OUVIDORIA = "0800 134 8080";
    private static int SEQUENCIAL = 1;
    protected String agencia;
    protected String sac;
    protected String ouvi;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.sac = Conta.SAC;
        this.ouvi = Conta.OUVIDORIA;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Agencia: %s", this.agencia));
        System.out.println(String.format("\n\tSAC: %s", this.sac));
        System.out.println(String.format("\tOuvidoria: %s", this.ouvi));
        System.out.println(String.format("\n\n\t\t\tNúmero do Cliente: %d", this.numero));
        System.out.println(String.format("\nSaldo-R$ %.2f", this.saldo));
        System.out.println(String.format("\nTitular da Conta: %s", this.cliente.getNomeCliente()));
        System.out.println("===================================================\n");


    }
}