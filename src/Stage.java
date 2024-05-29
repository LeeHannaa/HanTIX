import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class Stage {
    private ArrayList<Seat> s;
    private String filename;

    private void loadFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        String[] split;
        Seat temp;
        s = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            split = line.split(",");
            temp = new Seat(split[0], split[1], split[2] ,split[3]);
            s.add(temp);
        }
        reader.close();
    }

    public void init(String filename) {
        this.filename = filename;
        try{
            loadFile();
        }
        catch (IOException e)
        {
            System.out.println("Can't find open file");
        }

    }

    public void print()
    {
        System.out.println(s.get(0).getName());
    }
}
