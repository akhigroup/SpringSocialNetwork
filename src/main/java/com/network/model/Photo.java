package com.network.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private boolean isAvatar;

    private Timestamp dateOfPost;

    private boolean wasAvatar;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "community_id")
    private Community community;

    @Column(length = 65535)
    private String likes;

    @OneToMany(mappedBy = "photo")
    private Set<Comment> comments;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "album_id")
    private PhotoAlbum photoAlbum;

    public Photo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvatar() {
        return isAvatar;
    }

    public void setAvatar(boolean avatar) {
        isAvatar = avatar;
    }

    public Timestamp getDateOfPost() {
        return dateOfPost;
    }

    public void setDateOfPost(Timestamp dateOfPost) {
        this.dateOfPost = dateOfPost;
    }

    public boolean isWasAvatar() {
        return wasAvatar;
    }

    public void setWasAvatar(boolean wasAvatar) {
        this.wasAvatar = wasAvatar;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public PhotoAlbum getPhotoAlbum() {
        return photoAlbum;
    }

    public void setPhotoAlbum(PhotoAlbum photoAlbum) {
        this.photoAlbum = photoAlbum;
    }
}
