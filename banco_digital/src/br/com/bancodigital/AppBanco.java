package br.com.bancodigital;

import java.util.ArrayList;

public class AppBanco {
    public static void main(String[] args) {

        Cliente paulo = new Cliente();
        paulo.setNomeCliente("Paulo Roberto");
        Conta corrente = new ContaCorrente(paulo);
        Conta poupanca = new ContaPoupanca(paulo);
        corrente.depositar(1000.00);
        corrente.transferir(400.00, poupanca);
        corrente.imprimirExtrato();
        poupanca.imprimirExtrato();

        Cliente renata = new Cliente();
        renata.setNomeCliente("Renata Rocha");
        Conta correnteR = new ContaCorrente(renata);
        Conta poupancaR = new ContaPoupanca(renata);
        correnteR.depositar(1800.00);
        correnteR.transferir(630.00, poupancaR);
        correnteR.imprimirExtrato();
        poupancaR.imprimirExtrato();

        Cliente empresa = new Cliente();
        empresa.setNomeCliente("Empresa Fictícia Ltda.");
        Conta correnteE = new ContaCorrente(empresa);
        Conta poupancaE = new ContaPoupanca(empresa);
        correnteE.depositar(180000.00);
        correnteE.imprimirExtrato();

        //Lista dos clientes:
        ArrayList<Banco> bancos = new ArrayList<>();
        Banco cliente1 = new Banco(renata, "Rua Ada - nº: 14 - SP-SP", "11-99999-9999"
                , "renata@gmail.com", "444.855.771.00");
            bancos.add(cliente1);

        Banco cliente2 = new Banco(paulo, "Rua Aves - nº: 144 - SP-SP", "11-9 5555-1234"
                , "paulo@gmail.com", "411.355.971.20");
            bancos.add(cliente2);

        Banco cliente3 = new Banco(empresa, "Rua Ararapes - nº: 3144 - SP-SP", "11-97755-4999"
                , "empresafic@hotmail.com", "88.333.111/0001-06");
        bancos.add(cliente3);

        for (int i = 0; i < bancos.size(); i++){
           System.out.println(bancos.get(i).dadosCliente());
        }
    }
}