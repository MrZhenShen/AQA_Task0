package testFramework.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "duolingoCredentials")
public class DuolingoCred {

    @Id
    private Integer id;
    private String login;
    private String password;

    public DuolingoCred(Integer id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public DuolingoCred() {}

    @Override
    public String toString() {
        return "DuolingoCred{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
