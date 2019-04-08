package hu.hevi.timeline.api.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Comment {

    private String commentId;
    private String author;
    private String content;
    private String createdAt;
    private String parentId;
    private List<Comment> children = new ArrayList<>();
}
