import javax.swing.ImageIcon;
import java.awt.Graphics;

public class yCharacters {
 

    private int x;
    private int y;
    private int w;
    private int h;
    private int dx;
    private int dy;
    private ImageIcon pic; 
    private int health;
    private int CE;
    private int damage;
    private String name;
    private String eName;
    



    

    public yCharacters() {

        x=0;
        y=0;
        w=0;
        h=0;
        dx=0;
        dy=0;
        pic = new ImageIcon("pic.jpg");
        health=100;
        CE=100;
        damage = 5;
        name = "thukuna";
        eName = "gotho";

    }

    public yCharacters(ImageIcon pic, int x, int y, int w, int h, int dy, int health, int CE, int damage, String name, String eName) {
        this.pic = pic;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.dy = dy;
        this.health = health;
        this.CE = CE;
        this.damage = damage;
        this.name = name;
        this.eName = eName;

    }

    public void drawChar(Graphics g2d) {
        g2d.drawImage(pic.getImage(),x,y,w,h, null);
    }

   

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public ImageIcon getPic() {
        return pic;
    }

    public int getHealth() {
        return health;
    }

    public int getCE() {
        return CE;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setPic(ImageIcon pic) {
        this.pic = pic;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setCE(int cE) {
        CE = cE;
    }

        public String getName() {
        return name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void moveCharacter() {

        y+=dy;
        if (y < 0) y = 0;
        if (y + h > 900) y = 900 - h;

    }



}
