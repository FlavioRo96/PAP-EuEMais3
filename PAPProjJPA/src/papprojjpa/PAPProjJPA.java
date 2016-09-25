/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papprojjpa;

import br.com.euemais3.dao.*;
import br.com.euemais3.model.*;
import java.util.Date;

/**
 *
 * @author Flavio
 */
public class PAPProjJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            TipoContaDAO daoTipoConta = new TipoContaDAO();
            UsuarioDAO daoUsuario = new UsuarioDAO();
            EnderecoUsuarioDAO daoEnderecoUsuario = new EnderecoUsuarioDAO();
            FilmeDAO daoFilme = new FilmeDAO();
            FornecedorDAO daoFornecedor = new FornecedorDAO();
            EnderecoFornecedorDAO daoEnderecoFornecedor = new EnderecoFornecedorDAO();
            SalaDAO daoSala = new SalaDAO();
            SessaoDAO daoSessao = new SessaoDAO();
                    
            
            TipoConta tipoConta = new TipoConta(null, "ADM-000", "Conta de administração");
            Usuario usuario = new Usuario(null, "User1", "user", "1", new Date("10/10/2010"), tipoConta);
            EnderecoUsuario enderecoUsuario = new EnderecoUsuario(null, usuario, "Rua Jão", "15A","Jardim foguete", "", "0985480", "SP", "São Benedito da Cruz");
            Filme filme = new Filme(null, "Gravidade", "Otomar no cu", new Date("10/06/2013"), "Dirigid puta que pariu", "Não sei", new Date("01/01/01"), "Ação", "sadsd", "EUA", "English", "Colorido", "Dolby");
            Fornecedor fornecedor = new Fornecedor(null, "Cinemark", "11 4375-8548");
            EnderecoFornecedor enderecoFornecedor = new EnderecoFornecedor(null, fornecedor, "Rua Jurubatuba", "52145", "Centro", null, "09886000", "SP", "São Bernardo do Campo");
            Sala sala = new Sala(null, "Sala 10", fornecedor);
            Sessao sessao = new Sessao(null, filme, sala, new Date("10/10/2016"), 25.2);
            
            
            tipoConta = daoTipoConta.salvar(tipoConta);
            usuario = daoUsuario.salvar(usuario);
            enderecoUsuario = daoEnderecoUsuario.salvar(enderecoUsuario);
            filme = daoFilme.salvar(filme);
            fornecedor = daoFornecedor.salvar(fornecedor);
            enderecoFornecedor = daoEnderecoFornecedor.salvar(enderecoFornecedor);
            sala = daoSala.salvar(sala);
            sessao = daoSessao.salvar(sessao);
            
            
            System.out.println("ID do tipo de conta salvo: " + tipoConta.getId());
            System.out.println("ID do usuario salvo: " + usuario.getId());
            System.out.println("ID do endereço do usuario salvo: " + enderecoUsuario.getId());
            System.out.println("ID do filme salvo: " + filme.getId());
            System.out.println("ID do fornecedor salvo: " + fornecedor.getId());
            System.out.println("ID do enderedo do fornecedor salvo: " + enderecoFornecedor.getId());
            System.out.println("ID da sala salvo: " + sala.getId());
            System.out.println("ID da sessão salvo: " + sessao.getId());
            
            

            /*
             * PARA FAZER - Teste a consulta, alteração 
             * e exclusão do livro.
             */
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
