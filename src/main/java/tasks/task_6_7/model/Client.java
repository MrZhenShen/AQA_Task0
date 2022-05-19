package tasks.task_6_7.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "client") // can be disabled, only if table is not as class name
public class Client {

    @Id
    private Integer id_client;
    private String first_name;
    private String second_name;
    private Date join_date;
    private String job;

    @OneToMany(mappedBy = "client")
    private Set<Device> devices;

    public Client(Integer id_client, String first_name, String second_name, Date join_date, String job) {
        this.id_client = id_client;
        this.first_name = first_name;
        this.second_name = second_name;
        this.join_date = join_date;
        this.job = job;
    }
    public Client() {}

    public Integer getId_client() {
        return id_client;
    }

    public void setId_client(Integer id_client) {
        this.id_client = id_client;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id_client=" + id_client +
                ", first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", join_date=" + join_date +
                ", job='" + job + '\'' +
                '}';
    }
}
