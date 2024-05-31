public class Seat {
    private String seat;
    private String name;
    private String student_id;
    private String phone_number;

    public Seat(String seat, String student_id, String name, String phone_number) {
        this.seat = seat;
        this.name = name;
        this.student_id = student_id;
        this.phone_number = phone_number;
    }

    public String getSeat() {
        return seat;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return student_id;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public Boolean isOccupied(){ //true -> reservation
        return !seat.trim().isEmpty() && !name.trim().isEmpty() && !student_id.trim().isEmpty() && !phone_number.trim().isEmpty();
    }
}
