import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Score extends Actor
{
    public static int score = 0;

    
    public Score(){

        setImage(new GreenfootImage("Score : " + score, 80, Color.BLACK, Color.WHITE));

    }
    
    public void addScore(int amount){
        

        // Shows the score you have in AssembleWorld
        // null for the colour so it stays the same colour as background
        score += amount;
        setImage(new GreenfootImage("Score : " + score, 80, null, null));
 
        
        
        
    }
    
    public void act(){
        setImage(new GreenfootImage("Score : " + score, 80, null, null));
    }
    
    

}
