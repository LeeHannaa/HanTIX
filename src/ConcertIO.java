import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


//This class will initalize all concert classes with the correct information
//getConcert will pass the concerts array to be used
public class ConcertIO {
    private Concert[] concerts;

    public ConcertIO() {
        //opens images and calls constructors to initalize concert classes
        concerts = new Concert[3];
        try {
            Image picture = ImageIO.read(new File("./images/neo.png"));
            concerts[0] = new Concert("NEO", "06/10/2024", "9:00PM", "./data/neo.csv", picture);
            picture = ImageIO.read(new File("./images/zizzy.png"));
            concerts[1] = new Concert("ZIZZY", "06/15/2024", "8:00PM","./data/zizzy.csv", picture);
            picture = ImageIO.read(new File("./images/mic.png"));
            concerts[2] = new Concert("MIC", "06/20/2024", "10:00PM", "./data/mic.csv", picture);
        } catch (IOException e) {
            String workingDir = System.getProperty("user.dir");
            System.out.println("Current working directory : " + workingDir);
            e.printStackTrace();
        }

       
    }

    public Concert[] getConcert()
    {
        return concerts;
    }


    // public static void main(String[] args) {
    //     try {
    //         Image picture = ImageIO.read(new File("picture.png"));
    //     } catch (IOException e) {
    //         String workingDir = System.getProperty("user.dir");
    //         System.out.println("Current working directory : " + workingDir);
    //         e.printStackTrace();
    //     }
    // }
}
