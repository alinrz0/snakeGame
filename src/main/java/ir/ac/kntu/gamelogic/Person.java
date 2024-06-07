package ir.ac.kntu.gamelogic;

public class Person {
    private Life life=new Life();

    private int x=0;

    private int y=0;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLife( int life) {
        this.life.setLife(life);
    }

    public int getLife() {
        return life.getLife();
    }
}
