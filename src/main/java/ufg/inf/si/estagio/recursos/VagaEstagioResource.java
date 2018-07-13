package ufg.inf.si.estagio.recursos;

import ufg.inf.si.estagio.model.entidades.VagaEstagio;
import ufg.inf.si.estagio.presenter.VagaEstagioPresenter;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Named
@Path("/vagasEstagio")
@Produces(MediaType.APPLICATION_JSON)
public class VagaEstagioResource {

    private final VagaEstagioPresenter vagaEstagioPresenter;

    @Inject
    public VagaEstagioResource(final VagaEstagioPresenter vagaEstagioPresenter) {
        this.vagaEstagioPresenter = vagaEstagioPresenter;
    }

    @GET
    public List<VagaEstagio> consultaTodos() {
        return vagaEstagioPresenter.consultarTodos();
    }

    @POST
    public VagaEstagio criarNovo(final VagaEstagio evento) {
        return vagaEstagioPresenter.salvar(evento);
    }

    @GET
    @Path("/{id}")
    public VagaEstagio consultarPorId(@PathParam("id") final Long id) {
        return vagaEstagioPresenter.consultarPorId(id);
    }
    @POST
    @Path("/editar")
    public VagaEstagio editarVaga(final VagaEstagio evento) {
        return vagaEstagioPresenter.editar(evento);
    }
}
