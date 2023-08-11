package com.hoangtien2k3.config;

import com.hoangtien2k3.controller.UserResource;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/boot-jersey")
public class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration() {
        register(UserResource.class);
    }
}