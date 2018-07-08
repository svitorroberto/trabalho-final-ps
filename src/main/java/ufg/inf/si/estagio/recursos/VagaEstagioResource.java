package ufg.inf.si.estagio.recursos;

import ufg.inf.si.estagio.model.entidades.VagaEstagio;
import ufg.inf.si.estagio.presenter.VagaEstagioPresenter;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Named
@Path("/eventos")
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
}
