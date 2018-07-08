package ufg.inf.si.estagio.recursos;

import org.springframework.boot.info.BuildProperties;
import ufg.inf.si.estagio.model.ApplicationInfo;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Named
@Path("/healthcheck")
@Produces(MediaType.APPLICATION_JSON)
public class HealthCheckResource {

    private final BuildProperties buildProperties;

    @Inject
    public HealthCheckResource(final BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }

    /**
     * Retorna informações da versão e informações da aplicação.
     * Útil para checagens de saúde da API
     *
     * @return objeto do tipo ApplicationInfo - objeto contendo o nome e versão da aplicação.
     */
    @GET
    public ApplicationInfo getInfo() {
        return new ApplicationInfo(buildProperties.getName(), buildProperties.getVersion());
    }

}
