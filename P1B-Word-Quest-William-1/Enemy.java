import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An example of a Computer controlled AnimatedCharacter
 * 
 * @author Jordan Cohen
 * @version 2019
 */
public class Enemy extends AnimatedCharacter
{

    private MouseInfo m;
    // private boolean clickedToMove;
    private int walkSpeed;
    private int walkAnimSpeed;

    private int runSpeed;
    private int runAnimSpeed;

    private int delayActsLeft;

    private boolean alive;
    private boolean active;

    private Direction d;
    public Enemy (){
        super();

        setSpriteSheet(new GreenfootImage ("gorc.png"));
        
        animations.put ("die", Animation.createAnimation(getSpriteSheet(), 21, 1, 6, 64, 64));         
        animations.put("move", Animation.createAnimation(getSpriteSheet(), 9, 4, 9, 64, 64));
        
        Animation.trim (animations.get("move"), 12, 12, 12, 2);



        primaryAnimation = animations.get("move");

        walkSpeed = 60;
        walkAnimSpeed = 20;

        runSpeed = 100;
        runAnimSpeed = 32;


        // Variables to manage state of this enemy
        alive = true;
        active = true;

        delayActsLeft = 100;
        // Choose a random starting direction
        direction = Direction.fromInteger(Greenfoot.getRandomNumber(4));

        changeSpeed(walkSpeed, walkAnimSpeed);

        enableCollision();
        
        setImage(primaryAnimation.getOneImage(direction, 0));
    }

    public void act() 
    {
        if (active){
            delayActsLeft--;

            if (isTouching(Rock.class)){
                stepBack();
                stopMoving();
                delayActsLeft = 0;
            } 
            
           
            if (!alive){

                runTerminalAnimation ("die", true, true, direction, 0);
                active = false;
            }
            else if (delayActsLeft == 0 || isAtEdge()){
                stopMoving();

                direction = Direction.fromInteger(Greenfoot.getRandomNumber(4));
                moveInDirection (direction);
                delayActsLeft = 100;
            }
        }
        super.act(); // <==== DO NOT REMOVE
    }    

    public void killMe (){
        stopMoving();
        changeSpeed (0, 3);
        alive = false;
    }
    
    public void terminalAnimationComplete (){
        
    }
}
