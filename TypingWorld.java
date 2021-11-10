import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class TypingWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TypingWorld extends World
{

    ArrayList<String> answerList = new ArrayList<String>();
    
    public TypingWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
    }
    
    public void act()
    {
        String input = Greenfoot.ask("Enter a verb with the letters you chose: (Type DONE when finished) ");
        
            
        answerList.add(input);
        
        
        for(String p : answerList)
        {
            char[] chars = p.toCharArray();
            //for(int i=0; i<chars.size(); i++)
            //{
                
                
            //}
        }
        
        
        if (input.equals("DONE"))
        {
            Greenfoot.setWorld(new EndScreen());
        }
        
    }
}
