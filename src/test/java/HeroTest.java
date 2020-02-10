import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
    @After
    public void tearDown() {
        Hero.retireAllHeroes();
    }

    Hero hero = new Hero("Captain Man", 30, "Indestructability", "He needs a sidekick", "Kitchen Masters");
    Hero hero2 = new Hero("Cyborg", 20, "90% robot", "water I guess", "Sous Masters");

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
    public void squadName_getSquadNameInHero_Kitchen_KitchenMasters(){
        assertEquals("Kitchen Masters", hero.getSquadName());
    }

    @Test
    public void retireAllHeroes() {

    }
}