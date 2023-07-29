package softuni.exam.instagraphlite.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity{

    @Column(nullable = false)
    private String caption;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Picture Picture;

    public Post() {
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public softuni.exam.instagraphlite.models.entity.Picture getPicture() {
        return Picture;
    }

    public void setPicture(softuni.exam.instagraphlite.models.entity.Picture picture) {
        Picture = picture;
    }
}
