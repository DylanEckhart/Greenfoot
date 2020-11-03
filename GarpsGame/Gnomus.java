    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
     * Write a description of class Gnomus here.
     * 
     * @author (Dylan Eckhart) 
     * @version (1-11-2020)
     */
    import greenfoot.Actor;
    import greenfoot.Greenfoot;
    
    public class Gnomus extends Actor {
        public Gnomus() {
            setRotation();
        }
        public void act() {
            move(5);
            if (atWorldEdge()) {
                move(-5);
                setRotation();
            } else {
                int random = Greenfoot.getRandomNumber(100);
                if (random < 2) {
                    setRotation(getRotation() + Greenfoot.getRandomNumber(180));
                }
                if (random > 98) {
                    setRotation(getRotation() - Greenfoot.getRandomNumber(180));
                }
            }
        }
        private boolean atWorldEdge() {
            int x = getX();
            int y = getY();
            int i = getImage().getWidth() / 2;
            int wx = getWorld().getWidth() - i;
            int wy = getWorld().getHeight() - i;
            if (x <= i) {
                return true;
            } else if (y <= i) {
                return true;
            } else {
                if (x >= wx) {
                    return true;
                } else {
                    return y >= wy;
                }                  
            }
        }
        protected void setRotation() {
            if (Greenfoot.getRandomNumber(100) < 50) {
                setRotation(getRotation() + Greenfoot.getRandomNumber(180));
            } else {
                setRotation(getRotation() - Greenfoot.getRandomNumber(180));
            }
        }
    }
