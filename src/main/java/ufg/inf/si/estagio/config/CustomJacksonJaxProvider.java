package ufg.inf.si.estagio.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@Component
public class CustomJacksonJaxProvider extends JacksonJaxbJsonProvider {

    @Inject
    public CustomJacksonJaxProvider(@Named("customDefaultMapper") final ObjectMapper mapper) {
        super();
        setMapper(mapper);
    }
}
