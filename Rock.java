import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A dumb obstacle that just sits there and does nothing, to
 * demonstrate collision detection in movement.
 * 
 * This same object is used for collision detection in both SimplePlayer
 * and ComplexPlayer. 
 * 
 * In SimplePlayer, this acts just like any other Greenfoot Actor - just by
 * being in the World, collision can be checked against it (see Actor API).
 * 
 * In ComplexPlayer, the Collider collider will be used for collision. This means that
 * you could optionally:
 * - Make the collision smaller or larger than the Actor object's image
 * - Disable and enable collision for this object dynamically
 * - Offset the collision from the Actor object
 * 
 * The additional benefit is that this can be used by the directional collision detection
 * that comes with AnimatedCharacter.
 * 
 * In this case, the Collider's size is set to the same size as the Actor.
 */
public class Rock extends Actor
{
    private GreenfootImage myImage;
    
    private Collider collider;
    
    public Rock (){
     myImage = new GreenfootImage(50,50);
     myImage.setColor(Color.RED);
     myImage.fill();
     setImage(myImage);
     
     collider = new Collider (getImage().getWidth(), getImage().getHeight(), 0, 0, this);     
    }
    
    public void addedToWorld (World w){
        w.addObject(collider, getX(), getY());
    }
    
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
