package model.building;

import model.entity.Person;
import utils.Vector;

import java.util.Optional;

/**
 *
 */
public class House extends Building {

	/*todo : private State state;*/

    /**
     * the number of residents in the house
     */
    private int residents;
    /**
     * the amount of vacancies in the house
     */
    private int vacancies;

    public House(String name, Vector location, Vector dimension, int vacancies) {
        super(name, location, dimension);
        this.residents = 0;
        this.vacancies = vacancies;//todo
    }

    /**
     * method to call when  new residents are coming into the house
     *
     * @param number the number of new resident
     */
    private void newResident(int number) {
        // TODO implement here
    }

    @Override
    public Optional<Person> update(long now) {
        //todo
        return Optional.empty();
    }

    @Override
    protected Person createPerson() {
        //todo
        return null;
    }
}