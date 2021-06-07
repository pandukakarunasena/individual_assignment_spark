package com.panduka.ncms;

import static com.panduka.ncms.utils.Constants.PACKAGE_NAME_FOR_RESOURCES;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;


@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages( PACKAGE_NAME_FOR_RESOURCES);
        register(new LoggingFeature( Logger.getLogger(
                LoggingFeature.DEFAULT_LOGGER_NAME),
                Level.INFO,
                LoggingFeature.Verbosity.PAYLOAD_ANY,
                10000));
    }

    /**
     *  change the default java.util.logging to log4j logging. Jersey is using the default logging.
     */
//    @PostConstruct
//    public void init() {
//        String cn = "org.apache.logging.log4j.jul.LogManager";
//        System.setProperty("java.util.logging.manager", cn);
//        LogManager lm = LogManager.getLogManager();
//        if (!cn.equals(lm.getClass().getName())) {
//            try {
//                ClassLoader.getSystemClassLoader().loadClass(cn);
//            } catch (ClassNotFoundException cnfe) {
//                throw new IllegalStateException("Jars not in system class path.", cnfe);
//            }
//            throw new IllegalStateException("Found " + lm.getClass().getName() + " set as launch param instead.");
//        }
//    }
}