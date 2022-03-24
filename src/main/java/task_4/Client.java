package task_4;

public class Client {
    private String name;
    private String email;
    private int age;

    Client(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
    Client() {}

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
