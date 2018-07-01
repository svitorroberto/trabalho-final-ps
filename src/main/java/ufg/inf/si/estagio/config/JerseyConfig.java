package ufg.inf.si.estagio.config;


import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Named;

@Named
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        super();
        packages("ufg.inf.si.estagio.recursos", "ufg.inf.si.estagio.config");
    }

}
