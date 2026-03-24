import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class phit extends GameObject{
    
    private int speed = 10;
    
    public phit(double x, double y){

        super((int) x, (int) y, 50, 50, "assets/fish_red.png");
    }
    public void move(double deltaTime) {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            setX(getX() - (speed*deltaTime)) ;
        
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            setX(getX() + (speed*deltaTime)) ;
        
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            setY(getY() + (speed*deltaTime)) ;
        
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            setY(getY() - (speed*deltaTime)) ;
        
        }
    }
}