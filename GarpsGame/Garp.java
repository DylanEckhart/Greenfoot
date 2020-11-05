import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Dylan Eckhart) 
 * @version (1-11-20120)
**/

public class Garp extends Actor {
    private GreenfootImage imageLeft;
    private GreenfootImage imageRight;
    GarpsWorld thisGame;
    public Garp() {
        imageLeft = new GreenfootImage("GarpLeft.png");
        imageRight = new GreenfootImage("GarpRight.png");
        setImage(imageRight);
    }
    /**
     * Act - do whatever the Garp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        movingAndTurning();
        collectingDiamonds();
        foundBomb();
    }
    protected void collectingDiamonds() {
        World world;
        Actor diamond;
        diamond = getOneObjectAtOffset(0, 0, Diamond.class);
        if(diamond != null) {
            world = getWorld();
            world.removeObject(diamond);
            thisGame.score++;
            if (thisGame.score == 10) {
                Greenfoot.stop();
            }
        }   
    }
    protected void movingAndTurning() {
        if(Greenfoot.isKeyDown("left")) {
            if(getImage() == imageRight) {
                setImage(imageLeft);
            }
            setRotation(0);
            move(-5);
        }
        if(Greenfoot.isKeyDown("right")) {
            if(getImage() == imageLeft) {
                setImage(imageRight);
            }
            setRotation(0);
            move(5);
        }
        if(Greenfoot.isKeyDown("up")) {
            if(getImage() == imageLeft) {
                setImage(imageRight);
            }
            setRotation(-90);
            move(5);
        }
        if(Greenfoot.isKeyDown("down")) {
            if(getImage() == imageLeft) {
                setImage(imageRight);
            }   
            setRotation(90);
            move(5);
        }
        if (foundRock()) {
            move(-5);
        }
    }
    protected boolean foundRock() {
        Actor rock;
        rock = getOneObjectAtOffset(0, 0, Rock.class);
        if (rock != null) {
            return true;
        }
        return false;
    }
    public void foundBomb() {
        Actor bomb;
        bomb = getOneObjectAtOffset(0, 0, Bomb.class);
        if (bomb != null) {
            getWorld().removeObject(bomb);
            getWorld().addObject(new Explosion(), getX(), getY());
            getWorld().removeObject(this);
        }
    }
}
   

    
   
