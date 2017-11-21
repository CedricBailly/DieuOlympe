package model.building;

import model.entity.Entity;
import utils.Vector;

import java.util.Optional;

public class House extends Building {

    private static final String HOUSE_NAME = "House";
    private static final int HOUSE_VACANCIES = 8;
    private static final Vector HOUSE_DIMENSION = new Vector(2,2);

    private int residents;
    private int vacancies;
    private boolean incoming;

    public House(Vector location) {
        super(HOUSE_NAME, location, HOUSE_DIMENSION);
        this.residents = 0;
        this.vacancies = HOUSE_VACANCIES;
    }

    private void newResident(int number) {
        this.residents += number;
        this.vacancies -= number;
        this.incoming = false;
    }

    @Override
    public Optional<Entity> update(long now) {
        if (this.vacancies > 0 && !this.incoming) {
            this.incoming = true;
            return Optional.of(this.createEntity());
        }
        return Optional.empty();
    }

    @Override
    protected Entity createEntity() {
        return null;
    }

}