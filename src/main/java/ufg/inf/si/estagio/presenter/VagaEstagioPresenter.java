package ufg.inf.si.estagio.presenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import ufg.inf.si.estagio.dao.VagaEstagioDao;
import ufg.inf.si.estagio.model.entidades.VagaEstagio;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Named
public class VagaEstagioPresenter implements IVagaEstagioPresenter {

    private static final Logger logger = LoggerFactory.getLogger(VagaEstagioPresenter.class);

    private final VagaEstagioDao vagaEstagioDao;

    @Inject
    public VagaEstagioPresenter(final VagaEstagioDao eventosDao) {
        this.vagaEstagioDao = eventosDao;
    }

    private User getUser() {
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User) {
            return (User) principal;
        } else {
            throw new IllegalStateException("Não existe usuário presente no contexto atual");
        }
    }

    public HashMap<String, Object> fazerConsulta() {
        HashMap<String, Object> resposta = new HashMap<>();
        resposta.put("vagaEstagio", consultarTodos());
        resposta.put("acao", "ficaNaPagina");

        return resposta;
    }

    public HashMap<String, Object> salvarVaga(final VagaEstagio vagaEstagio) {
        HashMap<String, Object> resposta = new HashMap<>();
        resposta.put("vagaEstagio", salvar(vagaEstagio));
        resposta.put("acao", "detalhe-vaga-estagio.html?id=" + vagaEstagio.getId());

        return resposta;
    }

    public HashMap<String, Object> fazerConsultaPorId(final Long id) {
        HashMap<String, Object> resposta = new HashMap<>();
        resposta.put("vagaEstagio", consultarPorId(id));
        resposta.put("acao", "ficaNaPagina");

        return resposta;
    }

    public HashMap<String, Object> editarVaga(final VagaEstagio vagaEstagio) {
        HashMap<String, Object> resposta = new HashMap<>();
        resposta.put("vagaEstagio", editar(vagaEstagio));
        resposta.put("acao", "detalhe-vaga-estagio.html?id=" + vagaEstagio.getId());

        return resposta;
    }

    private List<VagaEstagio> consultarTodos() {
        final User usuarioAtual = getUser();
        logger.trace("Usuário com nome: `" + usuarioAtual.getUsername() + "`, " +
            "iniciou uma consulta de todas Vagas de Estagios do sistema");

        List<VagaEstagio> lista = new ArrayList<>();

        for (VagaEstagio evento : vagaEstagioDao.findAll()) {
            lista.add(evento);
        }

        logger.info("Usuário com nome: `" + usuarioAtual.getUsername() + "`, " +
            "concluiu uma consulta de todas Vagas de Estagios do sistema");

        return lista;
    }

    private VagaEstagio salvar(final VagaEstagio vagaEstagio) {
        final User usuarioAtual = getUser();
        logger.trace("Usuário com nome: `" + usuarioAtual.getUsername() + "`, " +
            "iniciou a criação da Vagas de Estagio:\n\n" + vagaEstagio.toString());

        final VagaEstagio eventoSalvo = vagaEstagioDao.save(vagaEstagio);

        logger.info("Usuário com nome `" + usuarioAtual.getUsername() + "`, " +
            "concluiu a criação da Vagas de Estagio:\n\n" + vagaEstagio.toString());

        return eventoSalvo;
    }

    private VagaEstagio consultarPorId(final Long id) {
        final User usuarioAtual = getUser();
        logger.trace("Usuário com nome: `" + usuarioAtual.getUsername() + "`, " +
            "iniciou uma consulta de Vagas de Estagio com identificador: " + id);

        if (!vagaEstagioDao.exists(id)) {
            logger.error("Vaga de Estagio com identificador: " + id + ", pesquisado pelo " +
                "usuário: `" + usuarioAtual.getUsername() + "` não foi encontrado");

            throw new NotFoundException("Vaga de Estagio com identificador `" + id + "`, não foi encontrado");
        }

        final VagaEstagio eventoEncontrado = vagaEstagioDao.findOne(id);

        logger.info("Usuário com nome: `" + usuarioAtual.getUsername() + "`, " +
            "concluiu com sucesso uma consulta da Vaga de Estagio com identificador: " + id);

        return eventoEncontrado;
    }

    private VagaEstagio editar(final VagaEstagio vagaEstagio) {
        final User usuarioAtual = getUser();
        logger.trace("Usuário com nome: `" + usuarioAtual.getUsername() + "`, " +
            "iniciou a edição de Vaga de Estagio:\n\n" + vagaEstagio.toString());

        final VagaEstagio eventoSalvo = vagaEstagioDao.save(vagaEstagio);

        logger.info("Usuário com nome `" + usuarioAtual.getUsername() + "`, " +
            "concluiu a edição de Vaga de Estagio:\n\n" + vagaEstagio.toString());

        return eventoSalvo;
    }

    public void apagarPorId(final Long id) {
        final User usuarioAtual = getUser();
        logger.trace("Usuário com nome: `" + usuarioAtual.getUsername() + "`, " +
            "iniciou a exclusão de Vaga de Estagio:\n\n" + id);

        vagaEstagioDao.delete(id);

        logger.info("Usuário com nome `" + usuarioAtual.getUsername() + "`, " +
            "concluiu a exclusão de Vaga de Estagio:\n\n" + id);
    }
}
