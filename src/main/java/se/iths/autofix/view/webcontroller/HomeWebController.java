package se.iths.autofix.view.webcontroller;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

public class HomeWebController implements IAutofixWebController{

    public HomeWebController(){
        super();
    }

    public void process(
            final HttpServletRequest request, final HttpServletResponse response,
            final ServletContext servletContext, final ITemplateEngine templateEngine)
            throws Exception {

        WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
        //ctx.setVariable("today", Calendar.getInstance());         //FRÅGAN om vi ska ha en klocka/kalender.

        templateEngine.process("home", ctx, response.getWriter());

    }
}
