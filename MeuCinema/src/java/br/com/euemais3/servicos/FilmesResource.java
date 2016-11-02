package br.com.euemais3.servicos;

import br.com.euemais3.ejbproj.bo.Filme;
import br.com.euemais3.ejbproj.ejb.interfaces.FilmeRemote;
import com.google.gson.Gson;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("filmes")
public class FilmesResource {
    @Context
    private UriInfo context;
    
    @EJB
    private FilmeRemote ejb;
    
    private Gson gson = new Gson();
    
    public FilmesResource() {
      
        
    }

    @GET
    @Produces("application/json")
    public String consultarTodos() {
        List<Filme> filmes = ejb.consultarFilmes();
        return gson.toJson(filmes);
    }
    
    @Path("{id}")
    @GET
    @Produces("application/json")
    public String consultarFilme(@PathParam("id") String idFilme) {
        Long id = Long.valueOf(idFilme);
        Filme f = ejb.consultarPorId(id);
        return gson.toJson(f);
    }
    
    @POST
    @Consumes("application/json")
    public void salvarProduto(String json) {
        Filme f = gson.fromJson(json, Filme.class);
        ejb.salvar(f);
    }
    
    @Path("{id}")
    @DELETE
    public void remover(@PathParam("id") String idFilme) {
        Long id = Long.valueOf(idFilme);
        ejb.remover(id);
    }

}
