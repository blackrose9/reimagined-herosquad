import definitions.Hero;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Map<String, Object> model = new HashMap<String, Object>();
        ArrayList<Hero> heroes = Hero.getAll();

        get("/", (request, response) -> {
            request.session().attribute("username");
            return new ModelAndView(model, "squads_gallore.hbs");
        }, new HandlebarsTemplateEngine());

        post("/session", (request, response) -> {
            String username = request.queryParams("username");
            request.session().attribute("username", username);
            model.put("username", username);
            return  new ModelAndView(model, "squads_gallore.hbs");
        }, new HandlebarsTemplateEngine());

        post("/view_squad/new", (request, response) -> {
            String alias = request.queryParams("alias");
//            get string age and parse it
            String strAge = request.queryParams("age");
            Integer age = Integer.parseInt(strAge);

            String power = request.queryParams("power");
            String kryptonite = request.queryParams("kryptonite");
            Hero newHero = new Hero(alias,age,power,kryptonite);

            return new ModelAndView(model, "squad_view.hbs");
        }, new HandlebarsTemplateEngine());

        get("/view_squad", (request, response) -> {
            model.put("heroes", heroes);
            return new ModelAndView(model, "squad_view.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
