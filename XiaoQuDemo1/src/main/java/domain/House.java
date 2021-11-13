package domain;

public class House {
    private int id;
    private String house_number;
    private String room_number;
    private String size;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouse_number() {
        return house_number;
    }

    public void setHouse_number(String house_number) {
        this.house_number = house_number;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "house{" +
                "id=" + id +
                ", house_number='" + house_number + '\'' +
                ", room_number='" + room_number + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
