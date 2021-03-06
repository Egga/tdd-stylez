package de.egga.chicago;

import de.egga.common.Character;
import de.egga.common.Planet;
import org.junit.Test;

import java.util.List;

import static de.egga.common.CharacterFactory.*;
import static de.egga.common.PlanetFactory.planetWith;
import static org.assertj.core.api.Assertions.assertThat;

public class ResistanceAppTest {

    Character luke = luke();
    Character chewie = chewie();
    Character han = hanSolo();

    ResistanceApp resistanceApp = new ResistanceApp();

    @Test
    public void it_should_find_luke() {
        Planet planet = planetWith(luke);
        List<Character> candidates = resistanceApp.searchForLuke(planet);
        assertThat(candidates).contains(luke);
    }

    @Test
    public void it_should_not_find_wookies() {
        Planet planet = planetWith(chewie);
        List<Character> candidates = resistanceApp.searchForLuke(planet);
        assertThat(candidates).isEmpty();
    }

    @Test
    public void it_should_not_find_non_jedi_character() {
        Planet planet = planetWith(han);
        List<Character> candidates = resistanceApp.searchForLuke(planet);
        assertThat(candidates).isEmpty();
    }
}