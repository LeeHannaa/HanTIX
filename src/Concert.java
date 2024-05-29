import java.awt.Image;
/*
concert name = name;
concert date = date;
concert time = time;
image representation;
 */
class Concert {
    private final String name;
    private final String date;
    private final String time;
    private final Image image;

    public Concert(String name, String date, String time, Image image)
    {
        this.name = name;
        this.date = date;
        this.time = time;
        this.image = image;
    }

    
}