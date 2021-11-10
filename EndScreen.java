import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{

    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    //Creates a new GreenfootSound for music.
    private GreenfootSound end=new GreenfootSound("[Arknights OST] shop.mp3");
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        //Plays music at 50% volume.
        super(800, 600, 1); 
        end.playLoop();
        end.setVolume(50);
        GreenfootImage image = new GreenfootImage("Background.png");
        image.scale(image.getWidth()*8/5, image.getHeight()*6/5);
        getBackground().drawImage(image, 0, 0);
        
        getBackground().drawImage(new GreenfootImage("Thanks for Playing!" ,32, null, null), 275, 100);
        getBackground().drawImage(new GreenfootImage("Your Score:" ,32, null, null), 325, 200);
        //Score
        // getBackground().drawImage(new GreenfootImage(score ,32, null, null), 350, 350);
        
        getBackground().drawImage(new GreenfootImage("Our Personal High Scores!" ,32, null, null), 250, 450);
        
    }
}
