/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Controller;

import Dao.Class.Venda;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Conexao;

/**
 *
 * @author Leandro Baroni
 */
public class VendaControlador {
    private Venda V;
    private Conexao C;
    String erroConexao;

    public VendaControlador() {
        C = new Conexao("jdbc:mysql://localhost:3306/db_svp", "root", "");
        erroConexao = C.getMensagemErro();
    }

    public String getMensagemErro() {
        return erroConexao;
    }
    
    public boolean inserir(Venda novo) {
        System.out.println("inserir cadastro");
        int resp = C.manipular("INSERT INTO venda (cliente_id, valor, nome, documento, documento2, num_poltrona, linha_id, servico_codigo, funcionario_codigo, estado, disp_poltrona, dataV, horaV, telefone) VALUES ('"+novo.getIdCliente()+"', '"+novo.getValor()+"','"+novo.getNomeCliente()+"', '"+novo.getRg()+"', '"+novo.getCpfCnpj()+"', '"+novo.getNumPoltrona()+"', '"+novo.getLinhaId()+"', '"+novo.getServico()+"', '"+novo.getIdFuncionario()+"', '"+novo.getEstadoBilhete()+"','"+novo.getDispPolt()+"', '"+novo.getDataVenda()+"', '"+novo.getHoraVenda()+"', '"+novo.getTelefone()+"')");
        String sql = "INSERT INTO venda (cliente_id, valor, nome, documento, documento2, num_poltrona, linha_id, servico_codigo, funcionario_codigo, estado, disp_poltrona, dataV, horaV, telefone) VALUES ('"+novo.getIdCliente()+"', '"+novo.getValor()+"','"+novo.getNomeCliente()+"', '"+novo.getRg()+"', '"+novo.getCpfCnpj()+"', '"+novo.getNumPoltrona()+"', '"+novo.getLinhaId()+"', '"+novo.getServico()+"', '"+novo.getIdFuncionario()+"', '"+novo.getEstadoBilhete()+"','"+novo.getDispPolt()+"', '"+novo.getDataVenda()+"', '"+novo.getHoraVenda()+"', '"+novo.getTelefone()+"')";
        System.out.println(sql);
        if (resp == 0) {
            System.out.println("Erro de inserção");
            erroConexao = C.getMensagemErro();
            return false;
        } 
        System.out.println("deu certo");
        return true;
    }

    public List<Venda> buscarServico(String dataVenda, int bilhete) {
        System.out.println("xixixxi");
        List<Venda> servicos = new ArrayList<>();
        System.out.println("SELECT * FROM venda WHERE dataV = '"+dataVenda+"' AND estado = 'V' AND codigo_bilhete = '"+bilhete+"' ORDER BY codigo_bilhete");

        String sql = "SELECT * FROM venda WHERE dataV = '"+dataVenda+"' AND estado = 'V' AND codigo_bilhete = '"+bilhete+"' ORDER BY codigo_bilhete";
        ResultSet res = C.consultar(sql);
        if (res!= null) {
            try {
                while ( res.next() ) {
                    int codigo = res.getInt("codigo_bilhete");
                    int clienteId = res.getInt("cliente_id");
                    double valor = res.getDouble("valor");
                    String nome = res.getString("nome");
                    String rg = res.getString("documento");
                    String cpfCnpj = res.getString("documento2");
                    int numPoltrona = res.getInt("num_poltrona");
                    int linhaId = res.getInt("linha_id");
                    int servicoId = res.getInt("servico_codigo");
                    int codFunc = res.getInt("funcionario_codigo");
                    String estBilhete = res.getString("estado");
                    String dispPoltrona = res.getString("disp_poltrona");
                    String dataViagem = res.getString("dataV");
                    String horaViagem = res.getString("horaV");
                    String telefone = res.getString("telefone");
                    Venda l = new Venda(codigo, clienteId, valor, nome, rg, cpfCnpj, numPoltrona, linhaId, servicoId, codFunc, estBilhete, dispPoltrona, dataViagem, horaViagem, telefone);
                    System.out.println("saiu");
                    servicos.add(l);
                }
                return servicos;
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar cidade: "+sqlex.getMessage();
            }
        }
        return null;
    }

    public List<Venda> buscarServico(int cBilhete, String cNome, int codServico) {
        System.out.println("xixixxi");
        List<Venda> servicos = new ArrayList<>();
        System.out.println("SELECT * FROM venda WHERE estado = 'V' AND codigo_bilhete = '"+cBilhete+"' AND nome = '" + cNome + "' AND servico_codigo = '" +codServico+ "' ORDER BY codigo_bilhete");
        String sql = "SELECT * FROM venda WHERE estado = 'V' AND codigo_bilhete = '"+cBilhete+"' AND nome = '" + cNome + "' AND servico_codigo = '" +codServico+ "' ORDER BY codigo_bilhete";
        ResultSet res = C.consultar(sql);
        if (res!= null) {
            try {
                while ( res.next() ) {
                    int codigo = res.getInt("codigo_bilhete");
                    int clienteId = res.getInt("cliente_id");
                    double valor = res.getDouble("valor");
                    String nome = res.getString("nome");
                    String rg = res.getString("documento");
                    String cpfCnpj = res.getString("documento2");
                    int numPoltrona = res.getInt("num_poltrona");
                    int linhaId = res.getInt("linha_id");
                    int servicoId = res.getInt("servico_codigo");
                    int codFunc = res.getInt("funcionario_codigo");
                    String estBilhete = res.getString("estado");
                    String dispPoltrona = res.getString("disp_poltrona");
                    String dataViagem = res.getString("dataV");
                    String horaViagem = res.getString("horaV");
                    String telefone = res.getString("telefone");
                    Venda l = new Venda(codigo, clienteId, valor, nome, rg, cpfCnpj, numPoltrona, linhaId, servicoId, codFunc, estBilhete, dispPoltrona, dataViagem, horaViagem, telefone);
                    System.out.println("saiu");
                    servicos.add(l);
                }
                return servicos;
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar cidade: "+sqlex.getMessage();
            }
        }
        return null;
    }

    public List<Venda> buscarServico(String dataVenda, String nomeBusca) {
        System.out.println("xixixxi");
        List<Venda> servicos = new ArrayList<>();
        System.out.println("SELECT * FROM venda WHERE dataV = '"+dataVenda+"' AND estado = 'V' AND nome LIKE '"+nomeBusca+"' ORDER BY codigo_bilhete");

        String sql = "SELECT * FROM venda WHERE dataV = '"+dataVenda+"' AND estado = 'V' AND nome LIKE '%"+nomeBusca+"%' ORDER BY codigo_bilhete";
        ResultSet res = C.consultar(sql);
        if (res!= null) {
            try {
                while ( res.next() ) {
                    int codigo = res.getInt("codigo_bilhete");
                    int clienteId = res.getInt("cliente_id");
                    double valor = res.getDouble("valor");
                    String nome = res.getString("nome");
                    String rg = res.getString("documento");
                    String cpfCnpj = res.getString("documento2");
                    int numPoltrona = res.getInt("num_poltrona");
                    int linhaId = res.getInt("linha_id");
                    int servicoId = res.getInt("servico_codigo");
                    int codFunc = res.getInt("funcionario_codigo");
                    String estBilhete = res.getString("estado");
                    String dispPoltrona = res.getString("disp_poltrona");
                    String dataViagem = res.getString("dataV");
                    String horaViagem = res.getString("horaV");
                    String telefone = res.getString("telefone");
                    Venda l = new Venda(codigo, clienteId, valor, nome, rg, cpfCnpj, numPoltrona, linhaId, servicoId, codFunc, estBilhete, dispPoltrona, dataViagem, horaViagem, telefone);
                    System.out.println("saiu");
                    servicos.add(l);
                }
                return servicos;
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar cidade: "+sqlex.getMessage();
            }
        }
        return null;
    }

    public List<Venda> buscarServico(String dataVenda, int cod, String nomeBusca) {
        System.out.println("xixixxi");
        List<Venda> servicos = new ArrayList<>();
        System.out.println("SELECT * FROM venda WHERE dataV = '"+dataVenda+"' AND estado = 'V' AND codigo_bilhete = '"+cod+"' AND nome LIKE '"+nomeBusca+"' ORDER BY codigo_bilhete");

        String sql = "SELECT * FROM venda WHERE dataV = '"+dataVenda+"' AND estado = 'V' AND codigo_bilhete = '"+cod+"' AND nome LIKE '%"+nomeBusca+"%' ORDER BY codigo_bilhete";
        ResultSet res = C.consultar(sql);
        if (res!= null) {
            try {
                while ( res.next() ) {
                    int codigo = res.getInt("codigo_bilhete");
                    int clienteId = res.getInt("cliente_id");
                    double valor = res.getDouble("valor");
                    String nome = res.getString("nome");
                    String rg = res.getString("documento");
                    String cpfCnpj = res.getString("documento2");
                    int numPoltrona = res.getInt("num_poltrona");
                    int linhaId = res.getInt("linha_id");
                    int servicoId = res.getInt("servico_codigo");
                    int codFunc = res.getInt("funcionario_codigo");
                    String estBilhete = res.getString("estado");
                    String dispPoltrona = res.getString("disp_poltrona");
                    String dataViagem = res.getString("dataV");
                    String horaViagem = res.getString("horaV");
                    String telefone = res.getString("telefone");
                    Venda l = new Venda(codigo, clienteId, valor, nome, rg, cpfCnpj, numPoltrona, linhaId, servicoId, codFunc, estBilhete, dispPoltrona, dataViagem, horaViagem, telefone);
                    System.out.println("saiu");
                    servicos.add(l);
                }
                return servicos;
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar cidade: "+sqlex.getMessage();
            }
        }
        return null;
    }

    public List<Venda> buscarPoltOcupada(String dataViagem, int codServico) {
        System.out.println("xixixxi");
        List<Venda> servicos = new ArrayList<>();
        System.out.println("SELECT v.codigo_bilhete, v.num_poltrona FROM venda v, servico s WHERE s.data_viagem = '"+dataViagem+"' AND v.estado = 'V' AND s.codigo = '"+codServico+"' ORDER BY v.num_poltrona");

        String sql = "SELECT v.codigo_bilhete, v.num_poltrona"
                + " FROM venda v, servico s"
                + " WHERE s.data_viagem = '"+dataViagem+"' AND v.estado = 'V' AND s.codigo = '"+codServico+"' AND s.codigo = v.servico_codigo"
                + " ORDER BY v.num_poltrona";
        ResultSet res = C.consultar(sql);
        if (res!= null) {
            try {
                while ( res.next() ) {
                    int codigo = res.getInt("v.codigo_bilhete");
                    int numPoltrona = res.getInt("v.num_poltrona");

                    Venda l = new Venda(codigo, numPoltrona);
                    servicos.add(l);
                }
                return servicos;
            }catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar cidade: "+sqlex.getMessage();
            }
        }
        return null;
    }

    public boolean cancelarBilhete(Venda venda) {
        System.out.println("entrou no metodo 'alterar'");
        String sql = "UPDATE venda SET estado = 'C' WHERE codigo_bilhete = '"+venda.getCodBilhete()+"' AND nome = '"+venda.getNomeCliente()+"' AND num_poltrona = '"+venda.getNumPoltrona()+"' AND estado = 'V'";
        System.out.println(sql);
        int i = C.manipular(sql);
        if (i > 0) {
            return true;
        }
        return false;
    }

    public boolean devolverBilhete(Venda venda) {
        System.out.println("entrou no metodo 'alterar'");
        String sql = "UPDATE venda SET valor = '" + venda.getValor() + "', estado = 'D' WHERE codigo_bilhete = '"+venda.getCodBilhete()+"' AND nome = '"+venda.getNomeCliente()+"' AND num_poltrona = '" + venda.getNumPoltrona() + "' AND estado = 'V'";
        System.out.println(sql);
        int i = C.manipular(sql);
        if (i > 0) {
            return true;
        }
        return false;
    }

    public List<Venda> remarcarBilhete(int codBilhete, String nomeCliente, int numPoltrona) {
        List<Venda> servicos = new ArrayList<>();
        System.out.println("entrou no metodo 'alterar'");
        String sql = "UPDATE venda SET estado = 'T'"
                + " WHERE codigo_bilhete = '" + codBilhete + "' AND nome = '" + nomeCliente + "' AND num_poltrona = '" + numPoltrona + "' AND estado = 'V'";
        System.out.println(sql);
        int i = C.manipular(sql);
        if (i > 0) {
            return servicos;
        }
        return null;
    }
}