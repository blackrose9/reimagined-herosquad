import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        Squad squad = new Squad("Kitchen Masters", "Good Cooking", 10, "info");
        Squad squad2 = new Squad("Spice Masters", "Good Cooking", 10, "warning");
        Squad squad3 = new Squad("Sous Masters", "Good Cooking", 10, "success");
        Squad squad4 = new Squad("Meat Masters", "Good Cooking", 10, "danger");

        Map<String, Object> model = new HashMap<String, Object>();

        post("/session", (request, response) -> {
            String username = request.queryParams("username");
            request.session().attribute("username", username);
            model.put("username", username);
            return  new ModelAndView(model, "squads_gallore.hbs");
        }, new HandlebarsTemplateEngine());

        post("/create_hero/new", (request, response) -> {
            String alias = request.queryParams("alias");
            String strAge = request.queryParams("age");
            Integer age = Integer.parseInt(strAge);
            String power = request.queryParams("power");
            String kryptonite = request.queryParams("kryptonite");

            Hero newHero = new Hero(alias,age,power,kryptonite);
            model.put("newHero",newHero);
            return new ModelAndView(model, "heroes_gallore.hbs");
        }, new HandlebarsTemplateEngine());

        get("/", (request, response) -> {
            model.put("username", request.session().attribute("username"));
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/view_squad/:id", (request, response) -> {
            int idOfSquadToFind = Integer.parseInt(request.params(":id"));
            Squad foundSquad = Squad.findById(idOfSquadToFind);
            model.put("squad", foundSquad);
            return new ModelAndView(model, "squad_view.hbs");
        }, new HandlebarsTemplateEngine());

        get("/create_hero", (request, response) -> {
            return new ModelAndView(model, "create_hero.hbs");
        }, new HandlebarsTemplateEngine());

        get("/view_hero", (request, response) -> {
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes", heroes);
            return new ModelAndView(model, "heroes_gallore.hbs");
        }, new HandlebarsTemplateEngine());

        get("/view_squa", (request, response) -> {
            ArrayList<Squad> squads = Squad.getAll();
            model.put("squads", squads);
            return new ModelAndView(model, "squads_gallore.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
