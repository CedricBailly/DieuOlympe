import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.GameLogic;
import viewcontroller.GameView;

public class Game extends Application {

    private GameLogic logic;
    private GameView view;

    @Override
    public void start(Stage stage) throws Exception {

        this.logic = new GameLogic();
        this.view = new GameView(this.logic);
        stage.setScene(new Scene(this.view));
        stage.show();

        this.createTimer().start();

    }


    private AnimationTimer createTimer() {
        return new AnimationTimer() {

            private long time;

            @Override
            public void handle(long now) {
                logic.update(now - this.time);
                view.update();
                this.time = now;
            }
        };
    }
}
