package com.mingi.backend.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class PostDTOTest extends PostDTO {
    private List<String> tags;
    public PostDTOTest(long numbers, String title, String content, int likes, int views, String blockComm,
                       String privates, String isDelete, LocalDateTime postDate,
                       String writer, String writerImage, List<String> tags) {
        super(numbers, title, content, likes, views, blockComm, privates, isDelete, postDate, writer, writerImage);
        this.tags = tags;
    }
}
