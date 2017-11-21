package model.building;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.entity.Entity;
import model.map.Terrain;
import utils.Vector;

import java.util.Optional;

import static utils.ConstantModel.HOUSE_DIMENSION;
import static utils.ConstantModel.HOUSE_NAME;
import static utils.ConstantModel.HOUSE_VACANCIES;

public class House extends Building {

    private Image image;
    private int residents;
    private int vacancies;
    private boolean incoming;

    public House(Vector location) {
        super(HOUSE_NAME, location, HOUSE_DIMENSION);
        this.image = new Image(House.class.getResource("house.png").toExternalForm());
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

    @Override
    public ImageView getView() {
        return new ImageView(this.image);
    }
}