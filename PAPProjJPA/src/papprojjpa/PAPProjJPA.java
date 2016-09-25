/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papprojjpa;

import br.com.euemais3.dao.EnderecoUsuarioDAO;
import br.com.euemais3.dao.FilmeDAO;
import br.com.euemais3.dao.TipoContaDAO;
import br.com.euemais3.dao.UsuarioDAO;
import br.com.euemais3.model.EnderecoUsuario;
import br.com.euemais3.model.Filme;
import br.com.euemais3.model.TipoConta;
import br.com.euemais3.model.Usuario;
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
            
            
            TipoConta tipoConta = new TipoConta(null, "ADM-000", "Conta de administração");
            Usuario usuario = new Usuario(null, "User1", "user", "1", new Date("10/10/2010"), tipoConta);
            EnderecoUsuario enderecoUsuario = new EnderecoUsuario(null, usuario, "Rua Jão", "15A","Jardim foguete", "", "0985480", "SP", "São Benedito da Cruz");
            Filme filme = new Filme(null, "Gravidade", "Otomar no cu", new Date("10/06/2013"), "Dirigid puta que pariu", "Não sei", new Date("01/01/01"), "Ação", "sadsd", "EUA", "English", "Colorido", "Dolby");
                        
            
            tipoConta = daoTipoConta.salvar(tipoConta);
            usuario = daoUsuario.salvar(usuario);
            enderecoUsuario = daoEnderecoUsuario.salvar(enderecoUsuario);
            filme = daoFilme.salvar(filme);

            
            System.out.println("ID do tipo de conta salvo: " + tipoConta.getId());
            System.out.println("ID do usuario salvo: " + usuario.getId());
            System.out.println("ID do endereço do usuario salvo: " + enderecoUsuario.getId());
            System.out.println("ID do filme salvo: " + filme.getId());
            

            /*
             * PARA FAZER - Teste a consulta, alteração 
             * e exclusão do livro.
             */
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
