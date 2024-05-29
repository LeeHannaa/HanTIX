import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ConcertIO {
    Concert[] concerts;

    public ConcertIO() {
        //opens images and calls constructors to initalize concert classes
        try {
            Image picture = ImageIO.read(new File("../images/neo.png"));
            concerts[0] = new Concert("NEO", "05/30/2024", "8:00PM", picture);
            picture = ImageIO.read(new File("../images/zizzy.png"));
            concerts[1] = new Concert("ZIZZY", "05/30/2024", "8:00PM", picture);
            picture = ImageIO.read(new File("../images/mic.png"));
            concerts[2] = new Concert("MIC", "05/30/2024", "8:00PM", picture);
        } catch (IOException e) {
            String workingDir = System.getProperty("user.dir");
            System.out.println("Current working directory : " + workingDir);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Image picture = ImageIO.read(new File("picture.png"));
        } catch (IOException e) {
            String workingDir = System.getProperty("user.dir");
            System.out.println("Current working directory : " + workingDir);
            e.printStackTrace();
        }
    }
}
