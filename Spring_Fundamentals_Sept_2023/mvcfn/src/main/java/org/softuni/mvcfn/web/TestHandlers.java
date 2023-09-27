package org.softuni.mvcfn.web;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.Map;

@Component
public class TestHandlers {

    public ServerResponse test(ServerRequest serverRequest){
        return ServerResponse.ok().render("test",
                Map.of("massage", "Hello Pesho!!!"));
    }

}
