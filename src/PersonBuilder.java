import java.util.OptionalInt;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String address = null;
    private boolean installAge = false;
    
    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        installAge = true;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public OptionalInt getAge() {
        OptionalInt i;
        if (installAge) {
            i = OptionalInt.of(age);
        } else {
            i = OptionalInt.empty();
        }
        return i;
    }

    public Person build() {
        return new Person(this);
    }
}
