package com.brink.microBlogDbRevisit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Message {

    @Id
    @Column(nullable = false)
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String text;

    public Message(String text) {
        this.text = text;
    }

    public Message() {
    }
}
