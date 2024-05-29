import java.awt.Image;

//stores all data for a single concert that is taking place 
class Concert {
    private final String name;
    private final String date;
    private final String time;
    private final String filename;
    private final Image image;

    public Concert(String name, String date, String time, String filename, Image image) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.filename = filename;
        this.image = image;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getFilename() {
        return filename;
    }

    public Image getImage() {
        return image;
    }
}
