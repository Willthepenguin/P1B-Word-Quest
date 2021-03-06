import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Timer extends Actor
{
  private int timer = 55*60; //about 60 seconds
 
  public Timer()
  {
      updateImage();
    }
 
    public void act()
    {
        timer--;
        // Every 60 ticks(1 second), it refreshes the time.
        if (timer % 55 == 0) { 
            updateImage();
        }
        if (timer < 1) {
            Greenfoot.stop();
        }
    }
 
    private void updateImage()
    {
        setImage(new GreenfootImage(" " + timer/55, 80, null, null));
        
    }
}