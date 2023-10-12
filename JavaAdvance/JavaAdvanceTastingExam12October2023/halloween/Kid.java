package halloween;

public class Kid {
    private String name;
    private int age;
    private String street;

    public Kid(String name, int age, String street) {
        this.name = name;
        this.age = age;
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public Kid setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Kid setAge(int age) {
        this.age = age;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Kid setStreet(String street) {
        this.street = street;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s, %d years old, from %s",this.name,this.age,this.street);
    }
}
