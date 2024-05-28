import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/*
concert name = name;
concert date = date;
concert time = time;
image representation;
 */
class Concert {
    String name;
    String date;
    String time;
    Image image;

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