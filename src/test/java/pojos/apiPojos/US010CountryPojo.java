package pojos.apiPojos;

public class US010CountryPojo {
    private int id;
    private String name;

    public US010CountryPojo() {
    }

    public US010CountryPojo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "US010CountryPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
