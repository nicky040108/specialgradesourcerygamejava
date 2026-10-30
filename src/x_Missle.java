import javax.swing.ImageIcon;

public class x_Missle {

    private int x;
    private int y;
    private int width;
    private int height;
    private ImageIcon pic;

    public x_Missle() {
        x = 50;
        y = 50;
        width = 50;
        height = 50;
        pic = new ImageIcon();
    }

    public x_Missle(ImageIcon p, int xV, int yV, int w, int h) {
        pic = p;
        x = xV;
        y = yV;
        width = w;
        height = h;
    }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public ImageIcon getPic() { return pic; }
    public void setPic(ImageIcon pic) { this.pic = pic; }

    public void setdx(int dx2) {
        x += dx2;
    }

    public void setdy(int dy2) {
        y += dy2;
    }
}
