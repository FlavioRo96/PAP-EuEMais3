package br.com.euemais3.ws;

import br.com.euemais3.ejbproj.bo.Fornecedor;
import br.com.euemais3.ejbproj.ejb.interfaces.FornecedorRemote;
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

@Path("cinemas")
public class CinemasResource {
    @Context
    private UriInfo context;
    
    @EJB
    private FornecedorRemote ejb;
    
    private Gson gson = new Gson();
    
    public CinemasResource() {
        
    }

    @GET
    @Produces("application/json")
    public String consultarTodos() {
        List<Fornecedor> fornecedores = ejb.consultarFornecedores();
        return gson.toJson(fornecedores.toString());
    }
    
    @Path("{id}")
    @GET
    @Produces("application/json")
    public String consultarCinema(@PathParam("id") String idCinema) {
        Long id = Long.valueOf(idCinema);
        Fornecedor c = ejb.consultarPorId(id);
        return gson.toJson(c);
    }
    
    @POST
    @Consumes("application/json")
    public void salvarCinema(String json) {
        Fornecedor c = gson.fromJson(json, Fornecedor.class);
        ejb.salvar(c);
    }
    
    @Path("{id}")
    @DELETE
    public void remover(@PathParam("id") String idCinema) {
        Long id = Long.valueOf(idCinema);
        ejb.remover(id);
    }

}
