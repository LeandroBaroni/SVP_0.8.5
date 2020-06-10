/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Class;

/**
 *
 * @author Leandro Baroni
 */
public class BilhetePdf {
    private Venda codBilhete;
    private Venda nomeCliente;
    private Venda rgCliente;
    private Venda cpfCnpjCliente;
    private Venda telefoneCliente;
    private Venda numPoltrona;
    private Venda dataVenda;
    private Venda horaVenda;

    private Servico codServico;
    private Servico dataViagem;
    private Servico horaViagem;

    private Linha codPrefixo;
    private Linha cidadeOrigemCod;
    private Linha cidadeDestinoCod;
    private Linha valorTarifa;
    private Linha valorTaxaRod;
    private Linha valorPedagio;
    private Linha valorTotal;

    private Cidade cidadeOrigemNome;
    private Cidade cidadeDestinoNome;

    public Venda getCodBilhete() {
        return codBilhete;
    }

    public void setCodBilhete(Venda codBilhete) {
        this.codBilhete = codBilhete;
    }

    public Venda getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(Venda nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Venda getRgCliente() {
        return rgCliente;
    }

    public void setRgCliente(Venda rgCliente) {
        this.rgCliente = rgCliente;
    }

    public Venda getCpfCnpjCliente() {
        return cpfCnpjCliente;
    }

    public void setCpfCnpjCliente(Venda cpfCnpjCliente) {
        this.cpfCnpjCliente = cpfCnpjCliente;
    }

    public Venda getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(Venda telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public Venda getNumPoltrona() {
        return numPoltrona;
    }

    public void setNumPoltrona(Venda numPoltrona) {
        this.numPoltrona = numPoltrona;
    }

    public Venda getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Venda dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Venda getHoraVenda() {
        return horaVenda;
    }

    public void setHoraVenda(Venda horaVenda) {
        this.horaVenda = horaVenda;
    }

    public Servico getCodServico() {
        return codServico;
    }

    public void setCodServico(Servico codServico) {
        this.codServico = codServico;
    }

    public Servico getDataViagem() {
        return dataViagem;
    }

    public void setDataViagem(Servico dataViagem) {
        this.dataViagem = dataViagem;
    }

    public Servico getHoraViagem() {
        return horaViagem;
    }

    public void setHoraViagem(Servico horaViagem) {
        this.horaViagem = horaViagem;
    }

    public Linha getCodPrefixo() {
        return codPrefixo;
    }

    public void setCodPrefixo(Linha codPrefixo) {
        this.codPrefixo = codPrefixo;
    }

    public Linha getCidadeOrigemCod() {
        return cidadeOrigemCod;
    }

    public void setCidadeOrigemCod(Linha cidadeOrigemCod) {
        this.cidadeOrigemCod = cidadeOrigemCod;
    }

    public Linha getCidadeDestinoCod() {
        return cidadeDestinoCod;
    }

    public void setCidadeDestinoCod(Linha cidadeDestinoCod) {
        this.cidadeDestinoCod = cidadeDestinoCod;
    }

    public Linha getValorTarifa() {
        return valorTarifa;
    }

    public void setValorTarifa(Linha valorTarifa) {
        this.valorTarifa = valorTarifa;
    }

    public Linha getValorTaxaRod() {
        return valorTaxaRod;
    }

    public void setValorTaxaRod(Linha valorTaxaRod) {
        this.valorTaxaRod = valorTaxaRod;
    }

    public Linha getValorPedagio() {
        return valorPedagio;
    }

    public void setValorPedagio(Linha valorPedagio) {
        this.valorPedagio = valorPedagio;
    }

    public Linha getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Linha valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cidade getCidadeOrigemNome() {
        return cidadeOrigemNome;
    }

    public void setCidadeOrigemNome(Cidade cidadeOrigemNome) {
        this.cidadeOrigemNome = cidadeOrigemNome;
    }

    public Cidade getCidadeDestinoNome() {
        return cidadeDestinoNome;
    }

    public void setCidadeDestinoNome(Cidade cidadeDestinoNome) {
        this.cidadeDestinoNome = cidadeDestinoNome;
    }

    public BilhetePdf() {
    }

    public BilhetePdf(int codBilhete, int codServico, String dataViagem){
        this.codBilhete = new Venda(codBilhete);
        this.codServico = new Servico(codServico);
        this.dataViagem = new  Servico(dataViagem);
    }

    public BilhetePdf(int codBilhete, String nomeCliente, int codServico, String dataViagem){
        this.codBilhete = new Venda(codBilhete);
        this.nomeCliente = new Venda(nomeCliente);
        this.codServico = new Servico(codServico);
        this.dataViagem = new  Servico(dataViagem);
    }

    public BilhetePdf(String nomeCliente, int numPoltrona, int codServico, String dataVenda, String horaVenda) {
        this.nomeCliente = new Venda(nomeCliente);
        this.numPoltrona = new Venda(numPoltrona);
        this.codServico = new Servico(codServico);
        this.dataVenda = new Venda(dataVenda);
        this.horaVenda = new Venda(horaVenda);
    }
    public BilhetePdf(int codBilhete, String nomeCliente, String rgCliente, String cpfCnpjCliente, String telefoneCliente, int numPoltrona, String dataVenda, String horaVenda, int codServico, String dataViagem, String horaViagem, int codPrefixo, int cidadeOrigemCod, int cidadeDestinoCod, Double valorTarifa, Double valorTaxaRod, Double valorPedagio, Double valorTotal, String cidadeOrigemNome, String cidadeDestinoNome) {
        this.codBilhete = new Venda(codBilhete);
        this.nomeCliente = new Venda(nomeCliente);
        this.rgCliente = new Venda(rgCliente);
        this.cpfCnpjCliente = new Venda(cpfCnpjCliente);
        this.telefoneCliente = new Venda(telefoneCliente);
        this.numPoltrona = new Venda(numPoltrona);
        this.dataVenda = new Venda(dataVenda);
        this.horaVenda = new Venda(horaVenda);
        this.codServico = new Servico(codServico);
        this.dataViagem = new Servico(dataViagem);
        this.horaViagem = new Servico(horaViagem);
        this.codPrefixo = new Linha(codPrefixo);
        this.cidadeOrigemCod = new Linha(cidadeOrigemCod);
        this.cidadeDestinoCod = new Linha(cidadeDestinoCod);
        this.valorTarifa = new Linha(valorTarifa);
        this.valorTaxaRod = new Linha(valorTaxaRod);
        this.valorPedagio = new Linha(valorPedagio);
        this.valorTotal = new Linha(valorTotal);
        this.cidadeOrigemNome = new Cidade(cidadeOrigemNome);
        this.cidadeDestinoNome = new Cidade(cidadeDestinoNome);
    }
}
