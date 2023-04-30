package classes;

public class Channels implements Active_Inactive {
    private Integer id;
    private String name;
    private String status;

    public Channels(Integer id, String name , String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void changeStatus() {
        if(status.equals("Active")){
            this.setStatus("Inactive");
        }
        else if(status.equals("Inactive")){
            this.setStatus("Active");
        }
    }

    @Override
    public String toString() {
        return "\nChannels[" + "Id=" + id + ",Name=" + name + ']';
    }
}
