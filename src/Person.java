import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private int age; //необязательное
    private String address = null; //необязательное
    private boolean installAge = false;

    Person(PersonBuilder personBuilder) {
        name = personBuilder.name;
        surname = personBuilder.surname;
        if (personBuilder.getAge().isPresent()) {
            age = personBuilder.age;
            installAge = true;
        }
        address = personBuilder.address;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder pb = new PersonBuilder();
        pb.setSurname(surname);
        pb.setAddress(address);
        return pb;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
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

    public String getAddress() {
        return address;
    }

    public boolean hasAge() {
        return installAge;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(String.format("Имя: %s, Фамилия: %s", name, surname));
        if (hasAge()) {
            res.append(String.format(", Возраст: %d", age));
        }
        if (hasAddress()) {
            res.append(String.format(", город проживания: %s", address));
        }
        return res.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }


}