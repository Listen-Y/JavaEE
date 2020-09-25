package model;

public class River {
    private int river_num;
    private String river_name;
    private String river_length;
    private String river_location;
    private String river_class;
    private String river_status;

    public int getRiver_num() {
        return river_num;
    }

    public void setRiver_num(int river_num) {
        this.river_num = river_num;
    }

    public String getRiver_name() {
        return river_name;
    }

    public void setRiver_name(String river_name) {
        this.river_name = river_name;
    }

    public String getRiver_length() {
        return river_length;
    }

    public void setRiver_length(String river_length) {
        this.river_length = river_length;
    }

    public String getRiver_location() {
        return river_location;
    }

    public void setRiver_location(String river_location) {
        this.river_location = river_location;
    }

    public String getRiver_class() {
        return river_class;
    }

    public void setRiver_class(String river_class) {
        this.river_class = river_class;
    }

    public String getRiver_status() {
        return river_status;
    }

    public void setRiver_status(String river_status) {
        this.river_status = river_status;
    }

    @Override
    public String toString() {
        return "River{" +
                "river_num=" + river_num +
                ", river_name='" + river_name + '\'' +
                ", river_length='" + river_length + '\'' +
                ", river_location='" + river_location + '\'' +
                ", river_class='" + river_class + '\'' +
                ", river_status='" + river_status + '\'' +
                '}';
    }
}
