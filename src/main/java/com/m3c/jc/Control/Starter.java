package com.m3c.jc.Control;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Starter {

    static final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    static Logger log = Logger.getLogger(Starter.class.getName());

    public static void main(String[] args) {
        initialiseLogging();
        WordCounterManager wordCounterManager = new WordCounterManager();
        wordCounterManager.findTopThree();
    }

    public static void initialiseLogging() {
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
        log.info("Logging initialised");
    }
}
