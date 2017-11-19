import model.GameMap;
import model.building.Building;
import model.entity.Person;
import org.junit.Before;
import org.junit.Test;
import utils.Vector;

import java.util.Optional;

import static org.junit.Assert.*;

public class GameMapTest {

    private GameMap map;

    @Before
    public void init() {
        this.map = new GameMap(10);
    }

    @Test
    public void testIsClear() {
        assertTrue(this.map.isClear(new Vector(), new Vector(4, 4)));
        this.map.create(new Building("B", new Vector(), new Vector(4, 4)) {
            @Override
            public Optional<Person> update(long now) {
                return Optional.empty();
            }

            @Override
            protected Person createPerson() {
                return null;
            }
        });
        assertFalse(this.map.isClear(new Vector(), new Vector(4, 4)));
    }

    @Test
    public void testCreate() {
        assertEquals(0, this.map.getBuildings().size());
        this.map.create(new Building("B", new Vector(), new Vector()) {
            @Override
            public Optional<Person> update(long now) {
                return Optional.empty();
            }

            @Override
            protected Person createPerson() {
                return null;
            }
        });
        assertEquals(1, this.map.getBuildings().size());
    }

}