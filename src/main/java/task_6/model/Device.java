package task_6.model;

import javax.persistence.*;

@Entity
@Table(name = "device") // can be disabled, only if table is not as class name
public class Device {

    @Id
    private Integer id_device;
    private String model;
    private String type;

    @ManyToOne
    @JoinColumn(name = "fk_client")
    private Client client;

    public Device(Integer id_device, String model, String type, Client client) {
        this.id_device = id_device;
        this.model = model;
        this.type = type;
        this.client = client;
    }

    public Device() {
    }

    public Integer getId_device() {
        return id_device;
    }

    public void setId_device(Integer id_device) {
        this.id_device = id_device;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id_device=" + id_device +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", client="  + client +
                '}';
    }
}
