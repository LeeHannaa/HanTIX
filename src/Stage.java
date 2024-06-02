import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

//stage class will load from a csv file into an arraylist that uses Seat class
public class Stage {
    private ArrayList<Seat> s;
    private String filename;
    private String seatLabel;
    private String id;
    private String name;
    private String phoneNumber;

    private void loadFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        String[] split;
        s = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            split = line.split(",");
            seatLabel = "";
            id = "";
            name = "";
            phoneNumber = "";
    
            if (split.length >= 1) {
                seatLabel = split[0].trim();
            }
            if (split.length >= 2) {
                id = split[1].trim();
            }
            if (split.length >= 3) {
                name = split[2].trim();
            }
            if (split.length >= 4) {
                phoneNumber = split[3].trim();
            }
    
            Seat temp = new Seat(seatLabel, id, name, phoneNumber);
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

    public ArrayList<Seat> getterSeatList(){
        return s;
    }
    public String getFilename(){
        return filename;
    }
    public String getName(){
        return name;
    }
    public String getSeatLabel(){
        return seatLabel;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getId(){
        return id;
    }
}
