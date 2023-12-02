package bg.softuni.error.web;

import bg.softuni.error.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class NotFound2Controller {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping("/not-found2/{id}")
    public String notFound1(@PathVariable("id") String id){
        throw new ObjectNotFoundException("Object with id: " + id + " was not found!",id);
    }


}
