package com.example.blog.model;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "posts")
@DynamicUpdate
public class Post {

    public interface View {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.class)
    private Long id;

    @NotNull
    @Size(min = 5, max = 50)
    @JsonView(View.class)
    private String title;

    @Lob
    @NotBlank
    private String content;

    @Lob
    private byte[] image;

    @OneToMany( mappedBy = "post",
                fetch = FetchType.EAGER,
                cascade = CascadeType.REMOVE)
    private Set<Comment> comments;

    @ManyToOne
    @CreatedBy
    private User author;

    @CreatedDate
    @Column(name = "created_at")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Date lastModifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
