package com.mingi.backend.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@Table(name = "post_tag")
public class PostTag {

    @EmbeddedId
    private PostTagId id;

    @ManyToOne
    @MapsId("postPostId")
    @JoinColumn(name = "post_post_id", insertable = false, updatable = false)
    private Post post;

    @ManyToOne
    @MapsId("tagTagId")
    @JoinColumn(name = "tag_tag_id", insertable = false, updatable = false)
    private Tag tag;
}

