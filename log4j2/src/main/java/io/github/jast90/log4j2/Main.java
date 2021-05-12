package io.github.jast90.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jast90 on 2021/5/12
 */
public class Main {

    private final static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.debug("log in kafka");
    }

}
