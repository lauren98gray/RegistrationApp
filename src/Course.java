public class Course {

    private String dept;
    private String number;
    private int hours;

    public Course(String dept, String number, int hours) {
        this.dept = dept;
        this.number = number;
        this.hours = hours;
    }

    public String getDept() {
        return dept;
    }

    public String getNumber() {
        return number;
    }

    public int getHours() {
        return hours;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return dept + " " + number + "   " + hours;
    }
}
