package building;

import model.building.Building;
import model.entity.Person;
import org.junit.Before;
import org.junit.Test;
import utils.Vector;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BuildingTest {

    private Building building;

    @Before
    public void init(){
        this.building = new Building("B",new Vector(),new Vector(4,4)) {
            @Override
            public Optional<Person> update(long now) {
                return Optional.empty();
            }

            @Override
            protected Person createPerson() {
                return null;
            }
        };
    }

    @Test
    public void testContactTopLeft(){
        assertTrue(this.building.contact(new Vector(-1,-1),new Vector(2,2)));
    }

    @Test
    public void testContactBotLeft(){
        assertTrue(this.building.contact(new Vector(-1,3),new Vector(2,2)));
    }

    @Test
    public void testContactTopRight(){
        assertTrue(this.building.contact(new Vector(3,-1),new Vector(2,2)));
    }

    @Test
    public void testContactBotRight(){
        assertTrue(this.building.contact(new Vector(3,3),new Vector(2,2)));
    }

    @Test
    public void testContactAllArea(){
        assertTrue(this.building.contact(new Vector(),new Vector(4,4)));
    }

    @Test
    public void testContactHalfArea(){
        assertTrue(this.building.contact(new Vector(),new Vector(2,2)));
    }

    @Test
    public void testNoContact(){
        assertFalse(this.building.contact(new Vector(4,4),new Vector(4,4)));
    }

}
