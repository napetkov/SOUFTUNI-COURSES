package softuni.exam.instagraphlite.models.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne(optional = false)
    @JoinColumn(name = "profile_picture_id")
    private Picture picture;

     public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
