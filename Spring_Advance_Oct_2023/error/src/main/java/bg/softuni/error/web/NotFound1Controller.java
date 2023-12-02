package bg.softuni.error.web;

import bg.softuni.error.exception.ObjectNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NotFound1Controller {

    @GetMapping("/not-found1/{id}")
    public String notFound1(@PathVariable("id") String id){
        throw new ObjectNotFoundException("Object with id: " + id + " was not found!",id);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ModelAndView handleNotFound(ObjectNotFoundException exception){
        ModelAndView modelAndView = new ModelAndView("notfound1");
        modelAndView.addObject("id",exception.getId());
        return modelAndView;
    }
}
