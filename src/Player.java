import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player extends GameObject{
    
    private int speed = 200;
    
    public Player(double x, double y){

        super((int) x, (int) y, 50, 50, "assets/ship.png");
    }
    public void move(double deltaTime) {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            X= getX() - (speed*deltaTime);
        
    }
}
