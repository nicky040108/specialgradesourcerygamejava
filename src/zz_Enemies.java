import javax.swing.ImageIcon;
import java.awt.Graphics;

public class zz_Enemies {
    
    private int x;
    private int y;
    private int w;
    private int h;
    private int dy;
    private int health;
    private int damage;
    private ImageIcon enemyPic;

    public zz_Enemies () {

       x=0;
       y=0;
       w=100;
       h=100;
       dy=0;
       health=100;
       damage=10;
       enemyPic = new ImageIcon("curse.png");

    }

    public zz_Enemies (int x, int y, int w, int h, int dy, int health, int damage, ImageIcon enemyPic) {

    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.dy = dy;
    this.health = health;
    this.damage = damage;
    this.enemyPic = enemyPic;

    }

    public void drawEnemy(Graphics g2d) {
        g2d.drawImage(enemyPic.getImage(),x,y,w,h, null);
    }

    public void moveEnemy() {

        y+=dy;
        if (y < 0) y = 0;
        if (y + h > 900) y = 900 - h;

    }
    
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

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public ImageIcon getEnemyPic() {
        return enemyPic;
    }

    public void setEnemyPic(ImageIcon enemyPic) {
        this.enemyPic = enemyPic;
    }

    


}
