package ufg.inf.si.estagio.presenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import ufg.inf.si.estagio.dao.VagaEstagioDao;
import ufg.inf.si.estagio.model.entidades.VagaEstagio;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class VagaEstagioPresenter {

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

    public List<VagaEstagio> consultarTodos() {
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

    public VagaEstagio salvar(VagaEstagio vagaEstagio) {
        final User usuarioAtual = getUser();
        logger.trace("Usuário com nome: `" + usuarioAtual.getUsername() + "`, " +
            "iniciou a criação da Vagas de Estagio:\n\n" + vagaEstagio.toString());

        final VagaEstagio eventoSalvo = vagaEstagioDao.save(vagaEstagio);

        logger.info("Usuário com nome `" + usuarioAtual.getUsername() + "`, " +
            "concluiu a criação da Vagas de Estagio:\n\n" + vagaEstagio.toString());

        return eventoSalvo;
    }
    
}
