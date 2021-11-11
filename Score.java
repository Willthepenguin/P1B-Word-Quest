import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Score extends Actor
{
    public static int score = 0;

    
    public Score(){

        setImage(new GreenfootImage("Score : " + score, 80, Color.BLACK, Color.WHITE));

    }
    
    public void addScore(int amount){
        

        
        score += amount;
        setImage(new GreenfootImage("Score : " + score, 80, null, null));
 
        
        
        
    }
    
    public void act(){
        setImage(new GreenfootImage("Score : " + score, 80, null, null));
    }
    
    

}
