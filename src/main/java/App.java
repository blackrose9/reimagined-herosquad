import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Map<String, Object> model = new HashMap<String, Object>();
        get("/", (request, response) -> {
            return new ModelAndView(model, "squads_gallore.hbs");
        }, new HandlebarsTemplateEngine());

        get("/create_hero", (request, response) -> {

            return new ModelAndView(model, "create_hero.hbs");
        }, new HandlebarsTemplateEngine());

        post("/view_squad", (request, response) -> {
            String alias = request.queryParams("alias");
            String age = request.queryParams("name");
            String power = request.queryParams("name");
            String kryptonite = request.queryParams("name");
            return new ModelAndView(model, "squad_view.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
