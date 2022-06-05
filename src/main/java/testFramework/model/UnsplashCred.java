package testFramework.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "unsplashCredentials")
public class UnsplashCred {

    @Id
    private Integer id;
    private String accessKey;
    private String secretKey;

    public UnsplashCred(Integer id, String accessKey, String secretKey) {
        this.id = id;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public UnsplashCred() {}

    @Override
    public String toString() {
        return "UnsplashCred{" +
                "id=" + id +
                ", accessKey='" + accessKey + '\'' +
                ", secretKey='" + secretKey + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
