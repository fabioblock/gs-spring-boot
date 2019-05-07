package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.LogManager;

@RestController
public class HelloController {

    private static final Logger logger = LogManager.getLogger(HelloController.class);
    /*
    logger.trace("This is a trace statement");
    logger.debug("This is a debug statement");
    logger.info("This is a info statement");
    logger.warn("This is a warning statement");
    logger.error("This is a error statement");
    logger.fatal("This is a fatal statement");
    */
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot Friends!";
    }

}
