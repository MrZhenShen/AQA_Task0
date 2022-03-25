package task_4;

import java.io.Serializable;
import java.util.ArrayList;

public class Client implements Serializable {
    private String name;
    private String email;
    private int age;
    private ArrayList<Integer> orders;

    public Client(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
    public Client() {}

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", orders=" + orders +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Integer> getOrders() {
        return orders;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrders(ArrayList<Integer> orders) {
        this.orders = orders;
    }
}
