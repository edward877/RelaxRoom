package RelaxRoom.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "users")
public class UsersEntity implements Serializable {

    private static final long serialVersionUID = 3497516698847425035L;

    @Id
    @Column(name = "username", nullable = false, length = 40)
    private String username;

    @Column(name = "fio", nullable = false, length = 40)
    private String fio;

    @Column(name = "password", nullable = false, length = 40)
    private String password;

    @Column(name = "is_free", nullable = false)
    private boolean isFree;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<QueueEntity> queue = new ArrayList();

    public UsersEntity() {
    }

    public UsersEntity(String username, String fio, String password) {
        this.username = username;
        this.fio = fio;
        this.password = password;
        this.isFree = true;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "username='" + username + '\'' +
                ", fio='" + fio + '\'' +
                ", password='" + password + '\'' +
                ", isFree=" + isFree +
                '}';
    }
}
