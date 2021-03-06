package com.panduka.ncms;

import static com.panduka.ncms.utils.Constants.PACKAGE_NAME_FOR_RESOURCES;

import com.panduka.ncms.auth.AuthenticationFilter;
import com.panduka.ncms.utils.CORSFilter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api") public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages(PACKAGE_NAME_FOR_RESOURCES);
        register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), Level.INFO,
                LoggingFeature.Verbosity.PAYLOAD_ANY, 10000));
        register(AuthenticationFilter.class);
        register(CORSFilter.class);
    }

}