import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

public class MyGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private ArrayList<GameObject> activeObjects;
    int x = 100;
    // enemy bad;


    @Override
    public void create() {
        batch = new SpriteBatch();
        
        activeObjects = new ArrayList<GameObject>();

        // TODO 3: Instantiate your Player subclass and add it to activeObjects.
        Player p = new Player(50,100);
        activeObjects.add(p);
        // TODO 4: Write a for-loop to instantiate 5 Enemy objects at different 
        //         starting Y-coordinates and add them to activeObjects.

        for(int i = 0 ; i < 5 ; i ++){
            enemy bad = new enemy(400,x);
            x += 60;
            activeObjects.add(bad); 
               }
    }

    //render() is the game loop, called approx 60 times per second
    @Override
    public void render() {
        // Boilerplate: Clear the screen to black each frame
        Gdx.gl.glClearColor(.25f, .25f, .25f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // --- AP REVIEW: CASTING ---
        // Gdx.graphics.getDeltaTime() returns a float. 
        // We cast it to a double to stay strictly within the AP CSA Java standards.
        double deltaTime = (double) Gdx.graphics.getDeltaTime();

        // --- AP REVIEW: POLYMORPHISM ---
        // TODO 5: Write a standard or enhanced for-loop to iterate through activeObjects.
        // For each object, call its move() method.
        for(int i = 0 ; i < activeObjects.size() ; i++){
            activeObjects.get(i).move(1.0);
        }
        
        //Note: Anything drawn must be between .begin() and .end()
        batch.begin();
        // TODO 6: Write a loop to iterate through activeObjects and call draw(batch).
        for(int i = 0 ; i < activeObjects.size() ; i++){
            activeObjects.get(i).draw(batch);
        }

        batch.end();

        // --- AP REVIEW: ARRAYLIST TRAVERSAL & REMOVAL ---
        // TODO 7: Write collision logic. 
        // You must iterate through the list to check if the player overlaps with enemies.
        // See the cheat sheet for the overlap method!
        // NOTE: If you are removing items from an ArrayList, how must you structure 
        // your for-loop to avoid skipping elements?
        Player p = new Player(50,100);
      
        for(int i = 0 ; i < activeObjects.size() ; i++){
            GameObject obj = activeObjects.get(i);
           
            if(obj instanceof enemy && p.getHitbox().overlaps(obj.getHitbox())){
                activeObjects.remove(i);
                i--;
                System.out.println("check has ate");
            }
        }
    }
    
    @Override
    public void dispose() {
        batch.dispose();
    }
}