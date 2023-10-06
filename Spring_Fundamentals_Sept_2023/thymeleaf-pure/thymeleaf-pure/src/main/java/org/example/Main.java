package org.example;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class Main {
    public static void main(String[] args) {
        ITemplateEngine templateEngine = createThymeleafTemplateEngine();

        Context context = new Context();

        context.setVariable("name","Softuni");

        String html = templateEngine.process("test.html",context);

        System.out.println(html) ;


    }
    private static ITemplateEngine createThymeleafTemplateEngine(){
        TemplateEngine engin = new TemplateEngine();

        engin.setTemplateResolver(new ClassLoaderTemplateResolver());

        return engin;
    }
}