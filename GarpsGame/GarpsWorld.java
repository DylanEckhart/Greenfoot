import greenfoot.Greenfoot;
import greenfoot.GreenfootSound;
import greenfoot.World;

/**
 * @author (Dylan Eckhart) 
 * @version (1-11-20120)
**/

public class GarpsWorld extends World {
    public static int score = 0;
    private GreenfootSound sound;
    private EndScore endScore;
    String ScoreTekst = "Score: ";
    public GarpsWorld() {
        super(700, 500, 1);
        populateTheWorld();
    }
    public void act() {
        showText(ScoreTekst + score, 50, 475);
    }
    protected void populateTheWorld() {
        addObject(new Garp(), 350, 250);
        addObject(new Gnomus(), Greenfoot.getRandomNumber(670) + 15, Greenfoot.getRandomNumber(470) + 15);
        sound = new GreenfootSound("Zelda.mp3");

        int teller;
        for(teller = 0; teller < 4; ++teller) {
            addObject(new Bomb(), Greenfoot.getRandomNumber(700), Greenfoot.getRandomNumber(500));
        }

        for(teller = 0; teller < 6; ++teller) {
            addObject(new Rock(), Greenfoot.getRandomNumber(700), Greenfoot.getRandomNumber(500));
        }

        for(teller = 0; teller < 10; ++teller) {
            addObject(new Diamond(), Greenfoot.getRandomNumber(700), Greenfoot.getRandomNumber(500));
        }

        setPaintOrder(new Class[]{EndScore.class, Garp.class, Gnomus.class, Diamond.class, Bomb.class, Rock.class});
    }
    public void started() {
        sound.playLoop();
        endScore = new EndScore();
    }
    public void stopped() {
        endScore.setEndImage();
        addObject(endScore, getWidth() / 2, getHeight() / 2);
        sound.stop();
        score = 0;
        showText("", 50, 475);
    }
}