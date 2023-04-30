package ru.home.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private final static Logger LOGGER = LoggerFactory.getLogger(MyController.class);

    @GetMapping
    public void test() {
        LOGGER.info("Test");
    }

}
