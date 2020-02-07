package definitions;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
    Hero hero = new Hero("Captain Man", 30, "Indestructability", "He needs a sidekick");
    Hero hero2 = new Hero("Cyborg", 20, "90% robot", "water I guess");
    @After
    public void tearDown() {
        Hero.retireAllHeroes();
    }

    @Test
    public void getAllHeroesCorrectly_true() {
        assertEquals(2, Hero.getAll().size());
    }

    @Test
    public void allHeroesContainsHeroDetails_true(){
        assertTrue(Hero.getAll().contains(hero));
        assertTrue(Hero.getAll().contains(hero2));
    }

    @Test
    public void retireAllHeroes() {

    }
}