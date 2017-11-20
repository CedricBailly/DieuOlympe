package viewcontroller;

import javafx.scene.Parent;
import model.GameLogic;

import java.util.ArrayList;
import java.util.List;


public class GameView extends Parent {

    private GameLogic logic;
    private List<GameNode> nodes;

    public GameView(GameLogic logic) {
        this.logic = logic;
        this.nodes = new ArrayList<>();
    }

    public void init(){
        //todo
    }

    public void update(){

    }

}
