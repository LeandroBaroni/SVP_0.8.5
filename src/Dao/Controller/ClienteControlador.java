/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.Controller;

import Dao.Class.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import javax.swing.JOptionPane;
import model.Conexao;

/**
 *
 * @author Leandro Baroni
 */
public class ClienteControlador {
    private Cliente CLI;
    private Conexao C;
    String erroConexao;

    public ClienteControlador() {
        C = new Conexao("jdbc:mysql://localhost:3306/db_svp", "root", "");
        erroConexao = C.getMensagemErro();
    }

    public String getMensagemErro() {
        return erroConexao;
    }
    
    public boolean inserir(Cliente novo) {
        System.out.println("inserir cadastro");
        int resp = C.manipular("INSERT INTO cliente (nome, rg, cpf_cnpj, telefone, email, cep, endereco, numero, bairro, cidade, estado) VALUES ('"+novo.getNome()+"', '"+novo.getRg()+"','"+novo.getCpf_cnpj()+"', '"+novo.getTelefone()+"', '"+novo.getEmail()+"', '"+novo.getCep()+"', '"+novo.getEndereco()+"', '"+novo.getNumero()+"', '"+novo.getBairro()+"', '"+novo.getCidade()+"','"+novo.getEstado()+"')");
        String sql = "INSERT INTO cliente (nome, rg, cpf_cnpj, telefone, email, cep, endereco, numero, bairro, cidade, estado) VALUES ('"+novo.getNome()+"', '"+novo.getRg()+"','"+novo.getCpf_cnpj()+"', '"+novo.getTelefone()+"', '"+novo.getEmail()+"', '"+novo.getCep()+"', '"+novo.getEndereco()+"', '"+novo.getNumero()+"', '"+novo.getBairro()+"', '"+novo.getCidade()+"','"+novo.getEstado()+"')";
        System.out.println(sql);
        if (resp == 0) {
            System.out.println("Erro de inserção");
            erroConexao = C.getMensagemErro();
            return false;
        } 
        System.out.println("deu certo");
        return true;
    }
    
    public Cliente buscar(int valor){
        System.out.println("iniciou metodo buscar");
        String sql = "SELECT * FROM cliente WHERE id = '"+valor+"'";
        System.out.println(sql);
        ResultSet rs = C.consultar(sql);
        if (rs != null) {
            try {
                if ( rs.next() ) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String rg = rs.getString("rg");
                    String cpf_cnpj = rs.getString("cpf_cnpj");
                    String telefone = rs.getString("telefone");
                    String email = rs.getString("email");
                    String cep = rs.getString("cep");
                    String endereco = rs.getString("endereco");
                    String numero = rs.getString("numero");
                    String bairro = rs.getString("bairro");
                    String cidade = rs.getString("cidade");
                    String estado = rs.getString("estado");
                    Cliente CLI = new Cliente(id, nome, rg, cpf_cnpj, telefone, email, cep, endereco, numero, bairro, cidade, estado);
                    return CLI;
                } 
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar usuário";
            }
        } 
        return null;
    }
    
    public List<Cliente> buscarNomeParcial(String busca) {
        List<Cliente> clientes = new ArrayList<>(); 
        String sql = "SELECT * FROM cliente WHERE nome LIKE '%"+busca+"%'";
        System.out.println(sql);
        ResultSet res = C.consultar(sql);
        if (res!= null) {
            try {
                while ( res.next() ) {
                    int id = res.getInt("id");
                    String nome = res.getString("nome");
                    String rg = res.getString("rg");
                    String cpf_cnpj = res.getString("cpf_cnpj");
                    String telefone = res.getString("telefone");
                    String cep = res.getString("cep");
                    String endereco = res.getString("endereco");
                    String numero = res.getString("numero");
                    String bairro = res.getString("bairro");
                    String cidade = res.getString("cidade");
                    String estado = res.getString("estado");
                    
                    Cliente c = new Cliente(id, nome, rg, cpf_cnpj, telefone);
                    clientes.add(c);
                }
                return clientes;
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar usuário: "+sqlex.getMessage();
            }
        }
        return null;
    }

    public List<Cliente> buscarNomeEDoc(String valor1, String valor2) {
        List<Cliente> clientes = new ArrayList<>(); 
        String sql = "SELECT * FROM cliente WHERE nome LIKE '%"+valor1+"%' AND cpf_cnpj = '"+valor2+"'";
        System.out.println(sql);
        ResultSet res = C.consultar(sql);
        if (res!= null) {
            try {
                while ( res.next() ) {
                    int id = res.getInt("id");
                    String nome = res.getString("nome");
                    String rg = res.getString("rg");
                    String cpf_cnpj = res.getString("cpf_cnpj");
                    String telefone = res.getString("telefone");
                    String cep = res.getString("cep");
                    String endereco = res.getString("endereco");
                    String numero = res.getString("numero");
                    String bairro = res.getString("bairro");
                    String cidade = res.getString("cidade");
                    String estado = res.getString("estado");
                    
                    Cliente c = new Cliente(id, nome, rg, cpf_cnpj, telefone);
                    clientes.add(c);
                }
                return clientes;
            }
            catch (SQLException sqlex) {
                erroConexao = "Erro ao buscar usuário: "+sqlex.getMessage();
            }
        }
        return null;
    }

    public boolean excluir(int identified) {
        System.out.println("chegou na string");
        String sql = "DELETE FROM cliente WHERE id = '"+identified+"'";
        System.out.println(sql);
        System.out.println("passou da sql");
        int i = C.manipular(sql);
        if (i > 0) {
            System.out.println("Deu certo!!!");
            return true;
        }
        return false;
    }
    
    public boolean alterar(Cliente Cli) {
        System.out.println("entrou no metodo 'alterar'");
        String sql = "UPDATE cliente SET nome = '"+Cli.getNome()+"', "
                + "rg = '"+Cli.getRg()+"', cpf_cnpj = '"+Cli.getCpf_cnpj()+"', telefone = '"+Cli.getTelefone()+"', "
                + "email = '"+Cli.getEmail()+"', cep = '"+Cli.getCep()+"', endereco = '"+Cli.getEndereco()+"', "
                + "numero = '"+Cli.getNumero()+"', bairro = '"+Cli.getBairro()+"', "
                + "cidade = '"+Cli.getCidade()+"', estado = '"+Cli.getEstado()+"' where id = '"+Cli.getId()+"'";
        System.out.println(sql);
        int i = C.manipular(sql);
        if (i > 0) {
            return true;
        }
        return false;
    }

    public static boolean isCNPJ(String CNPJ) {
        // considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||
            CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
            CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
            CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
            CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
            (CNPJ.length() != 14))
            return(false);
 
        char dig13, dig14;
        int sm, i, r, num, peso;

        // "try" - protege o código para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i=11; i>=0; i--) {
            // converte o i-ésimo caractere do CNPJ em um número:
            // por exemplo, transforma o caractere '0' no inteiro 0
            // (48 eh a posição de '0' na tabela ASCII)
                num = (int)(CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                   peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
               dig13 = '0';
            else dig13 = (char)((11-r) + 48);

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i=12; i>=0; i--) {
                num = (int)(CNPJ.charAt(i)- 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10){
                    peso = 2;
                }
            }
            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig14 = '0';
            else{
                dig14 = (char)((11-r) + 48);
            }
            // Verifica se os dígitos calculados conferem com os dígitos informados.
            if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
                return(true);
            else{
                return(false);
            }
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

    public static String imprimeCNPJ(String CNPJ) {
        // máscara do CNPJ: 99.999.999.9999-99
        return(CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "." +
        CNPJ.substring(5, 8) + "." + CNPJ.substring(8, 12) + "-" +
        CNPJ.substring(12, 14));
    }
    
    public static boolean isCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);
        
        char dig10, dig11;
        int sm, i, r, num, peso;  
        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {              
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0         
        // (48 eh a posicao de '0' na tabela ASCII)         
                num = (int)(CPF.charAt(i) - 48); 
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else {
                dig10 = (char)(r + 48);
            } // converte no respectivo caractere numerico
          
        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
          
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else {
                dig11 = (char)(r + 48);
            }
          
        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else{
                return(false);
            }
        } catch (InputMismatchException erro) {
            return(false);
        }
    }
    
    public static String imprimeCPF(String CPF) {
        return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
        CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }
}