package com.toy.pay.novel.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Novel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Category category;

    @OneToMany(mappedBy = "novel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Volume> volumes = new ArrayList<>();

    @ManyToOne
    private Author author;

    protected Novel() {
    }

    public Novel(String title, Category category, Author author) {
        this.title = title;
        this.category = category;
        this.author = author;
    }

    public void write(Volume volume) {
        volume.setNovel(this);
        volumes.add(volume);
    }

    public enum Category {
        FANTASY, ROMANCE_FANTASY;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
