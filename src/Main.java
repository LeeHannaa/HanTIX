import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Use the event dispatch thread to create and show the GUI
        ConcertIO cio = new ConcertIO();
        Slide1 window = new Slide1(cio.getConcert());
        window.setVisible(true);
    }
}
