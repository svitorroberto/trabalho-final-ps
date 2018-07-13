package ufg.inf.si.estagio.recursos;

import ufg.inf.si.estagio.model.entidades.VagaEstagio;
import ufg.inf.si.estagio.presenter.VagaEstagioPresenter;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;

@Named
@Path("/vagasEstagio")
@Produces(MediaType.APPLICATION_JSON)
public class VagaEstagioResource {

    //DESIGN PATTERN: SINGLETON
    private final VagaEstagioPresenter vagaEstagioPresenter;

    @Inject
    public VagaEstagioResource(final VagaEstagioPresenter vagaEstagioPresenter) {
        this.vagaEstagioPresenter = vagaEstagioPresenter;
    }

    @GET
    public HashMap<String, Object> consultaTodos() {
        return vagaEstagioPresenter.fazerConsulta();
    }

    @POST
    public HashMap<String, Object> criarNovo(final VagaEstagio evento) {
        return vagaEstagioPresenter.salvarVaga(evento);
    }

    @GET
    @Path("/{id}")
    public HashMap<String, Object> consultarPorId(@PathParam("id") final Long id) {
        return vagaEstagioPresenter.fazerConsultaPorId(id);
    }
    @POST
    @Path("/editar")
    public HashMap<String, Object> editarVaga(final VagaEstagio evento) {
        return vagaEstagioPresenter.editarVaga(evento);
    }

    @POST
    @Path("/delete")
    public HashMap<String, Object> apagarPorId(final Long id) {
        return vagaEstagioPresenter.apagarVaga(id);
    }

}
