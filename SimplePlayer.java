import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A test player to demonstrate how to use AnimatedCharacter.
 * 
 * 
 * @author Jordan Cohen 
 * @since v0.2.2a Nov. 19, 2018
 * @version 0.7.0 - stable beta
 */
public class SimplePlayer extends AnimatedCharacter
{
    private MouseInfo m;
    private String key;

    private int walkSpeed;
    private int walkAnimSpeed;

    private int runSpeed;
    private int runAnimSpeed;

    private boolean attacking;

    // An image to hold my sprite sheet graphic
    private GreenfootImage spriteSheet;

    // create two animations - one for walking, one for swinging a weapon
    private Animation playerWalk, playerSwing;

    private int moveX, moveY;
    private int xFacing, yFacing; // direction for attacking

    public SimplePlayer (){
        super(); // DO NOT REMOVE - Call the constructor for AnimatedCharacter first

        spriteSheet = new GreenfootImage("simplePlayer.png");

        // Create one Animation for walking (and running) and one Animation for swinging
        playerWalk = Animation.createWalkingAnimation (spriteSheet);
        playerSwing = Animation.createAnimation(spriteSheet, 13, 4, 6, 64, 64);

        Animation.trim (playerWalk, 12, 12, 12, 2);
        Animation.trim (playerSwing, 12, 12, 12, 2);

        // Add this to our collection of animations, which are loaded and ready to trigger
        animations.put ("move", playerWalk);
        animations.put ("swing", playerSwing);

        //animations.put("stab", new Animation(importDirectionalSprites ("TS", Direction.size, 6)));

        // The primary animation is the one that will be used when no terminal animation is playing
        // This should be your base movement sprites. 
        setPrimaryAnimation("move");

        // Set walking speed
        walkSpeed = 60; // pixels to move per SECOND (not per act)
        walkAnimSpeed = 20; // number of animation frames per SECOND 

        // set the speed to start
        changeSpeed(walkSpeed, walkAnimSpeed);

        // Start the player off facing downward
        direction = Direction.DOWN;

        // Used to control my player's status / actions:
        attacking = false;
        xFacing = 0;
        yFacing = 0;

        // Once you have loaded a Primary Animation, this method
        // is an easy way to get a starting image.  You can put
        // any image you like here, but this is a convenient way
        // to grab the first frame from the animation and use it as
        // the starting image.
        setImage(getStartingImage());

    }

    /**
     * Your act method should perform your logic and THEN call
     * the superclass' act() method to do the actual animation.
     * See the last line of this method - it calls the act()
     * method of AnimatedCharacter, which MUST be called here
     * or nothing will happen.
     */
    public void act() 
    {

        // Keyboard iput for pressed keys and Mouse Info:
        // Note: In a real project, consider putting getKey() and/or getMouseInfo() 
        // in your world, because there can only be ONE getKey() and getMouseInfo() 
        // call per act for the whole simulation, and it's not usually ideal 
        // to put it in your Player class. This is intended as a demonstration.
        key = Greenfoot.getKey();

        if (key != null){ 
            if (key.equals("space")){
                // A terminal animation will run and then return to the original animation
                // when it's finished running. 
                runTerminalAnimation ("swing", false, false, direction, 1);
                attacking = true;               
            }
        }

        // If I'm currently attacking, see if I hit an Enemy
        if (attacking){
            attack();
        }

        // == Simple keyboard reading controls: ==
        // The facing part is for the attack method (see below) and could
        // be left out if you don't need that. 
        
        if (Greenfoot.isKeyDown("right")){
            moveInDirection (1, 0); // set direction by calling moveInDirection method. Note that this will KEEP MOVING until you call stopMoving()
            // These are used for "attacking" below - to easily track which direction the player is facing.
            xFacing = 1;
            yFacing = 0;
        }
        else if (Greenfoot.isKeyDown("left")){
            moveInDirection (-1, 0);
            xFacing = -1;
            yFacing = 0;
        }
        else if (Greenfoot.isKeyDown("up")){
            moveInDirection (0, -1);
            xFacing = 0;
            yFacing = -1;
        }
        else if (Greenfoot.isKeyDown("down")){
            moveInDirection (0, 1);
            xFacing = 0;
            yFacing = 1;
        }
        else { // if I'm not pressing an arrow key, stop moving
            xFacing = 0;
            yFacing = 0;
            stopMoving();
        }

        // Simple collision detection using Greenfoot's isTouching method along with
        // the provided stepBack(Actor) method (which steps away from an Actor) as well as
        // the stopMoving() method (which stops the current movement and sets animation to idle frame).
        if (isTouching(Rock.class)){
            Actor a = getOneIntersectingObject(Rock.class);
            stepBack(a); // step back from the specified object
            stopMoving();
        }

        // Call superclass' act() to perform animations and movement
        super.act(); // <<== DO NOT REMOVE: MUST BE INCLUDED 
        //      IN ALL ANIMATED CHARACTERS
    }    

    private void attack (){
        // Look for an enemy 1 pixel away in the direction that I'm facing

        // Since an Actor's coordinate represent it's center point, in order to find it's
        // edge, we need to find half of it's height and width (The distance between the center
        // of the Actor and the edge, horizontally and vertically).
        int halfMyWidth = getImage().getWidth()/2 + 1;
        int halfMyHeight = getImage().getWidth()/2 + 1;
        
        // Check if there is an Enemy directly beside me in the direction that I'm facing
        // In a real game, you would probably want to check more than one single pixel.
        Enemy e = (Enemy)getOneObjectAtOffset(xFacing * halfMyHeight, yFacing * halfMyHeight, Enemy.class);
        if (e != null){
            // "kill" any Enemy I hit
            e.killMe();
        }
    }

    // OPTIONAL include this method if you want to be notified when an animation is complete. 
    protected void terminalAnimationComplete(){
        attacking = false;
        //currentAnimation = primaryAnimation;
    }
}
