import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {
        Squad squad = new Squad("Kitchen Masters", "Fantastic Cooking", 10, "info");
        Squad squad2 = new Squad("Meat Masters", "Nyams is life", 10, "danger");
        Squad squad3 = new Squad("Spice Masters", "Flavourful Cooking", 10, "warning");
        Squad squad4 = new Squad("Sous Masters", "Speedy Cooking", 10, "success");

        Hero hero = new Hero("Kitchen Warrior", 23, "Master knife handler", "tends to cut himself very often", "Kitchen Masters");
        Hero hero2 = new Hero("Spice Master", 19, "can perfectly blend any spice", "all that aroma makes him sneeze, way too often", "Spice Masters");

        Map<String, Object> model = new HashMap<String, Object>();
        staticFileLocation("/public");
        port(getHerokuAssignedPort());

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
            String squadName = request.queryParams("squa");

            Hero newHero = new Hero(alias,age,power,kryptonite,squadName);
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
