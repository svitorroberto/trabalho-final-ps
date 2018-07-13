package ufg.inf.si.estagio.presenter;

import ufg.inf.si.estagio.model.entidades.VagaEstagio;

import java.util.HashMap;

public interface IVagaEstagioPresenter {

    HashMap<String, Object> fazerConsulta();

    HashMap<String, Object> salvarVaga(final VagaEstagio vagaEstagio);

    HashMap<String, Object> fazerConsultaPorId(final Long id);

    HashMap<String, Object> editarVaga(final VagaEstagio vagaEstagio);

    HashMap<String, Object> apagarVaga(final Long id);
}
