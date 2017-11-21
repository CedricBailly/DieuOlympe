package model.building;

import model.entity.Entity;
import utils.Vector;

import java.util.Optional;

import static utils.ConstantModel.HOUSE_DIMENSION;
import static utils.ConstantModel.HOUSE_NAME;
import static utils.ConstantModel.HOUSE_VACANCIES;

public class House extends Building {

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
            return Optional.empty();
        }
        return Optional.empty();
    }

    @Override
    protected Entity createEntity() {
        return null;
    }

}