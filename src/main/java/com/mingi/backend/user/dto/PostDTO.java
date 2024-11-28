package com.mingi.backend.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class PostDTO {
    private long numbers;
    private long postId;
    private String title;
    private String content;
    private int likes;
    private int views;
    private String blockComm;
    private String privates;
    private String isDelete;
    @JsonFormat(pattern = "yy-MM-dd HH:mm")
    private LocalDateTime postDate;

    private String writer;
    private String writerImage;

    public PostDTO(long numbers, String title, String content, int likes, int views,
                   String blockComm, String privates, String isDelete, LocalDateTime postDate,
                   String writer, String writerImage) {
        this.numbers = numbers;
        this.postId = numbers;
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.views = views;
        this.blockComm = blockComm;
        this.privates = privates;
        this.isDelete = isDelete;
        this.postDate = postDate;
        this.writer = writer;
        this.writerImage = writerImage;
    }
}
