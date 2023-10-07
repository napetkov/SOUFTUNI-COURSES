package bg.softuni.i18n.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LangControllerSessions {
    @GetMapping("/session")
    public String langCookies(HttpSession session,
                              Model model){
        var lang = session.getAttribute("lang");

        if(lang == null){
            lang = "bg";
        }

        session.setAttribute("name","Ivan");

        model.addAttribute("lang",lang);

        return "sessions";
    }

    @PostMapping("/session")
    public String langCookies(@RequestParam("lang") String lang, HttpSession session){

        session.setAttribute("lang",lang);

        return "redirect:/session";
    }
}
