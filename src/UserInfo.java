import java.util.ArrayList;

public class UserInfo {
    private String name;
    private String studentId;
    private String phoneNumber;
    private ArrayList<String> selectedSeats;

    public UserInfo(String name, String studentId, String phoneNumber, ArrayList<String> selectedSeats) {
        this.name = name;
        this.studentId = studentId;
        this.phoneNumber = phoneNumber;
        this.selectedSeats = selectedSeats;
    }

    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Name: ").append(name).append("\n");
        info.append("Student ID: ").append(studentId).append("\n");
        info.append("Phone Number: ").append(phoneNumber).append("\n");
        info.append("Selected Seats: ").append(String.join(", ", selectedSeats));
        return info.toString();
    }
}
