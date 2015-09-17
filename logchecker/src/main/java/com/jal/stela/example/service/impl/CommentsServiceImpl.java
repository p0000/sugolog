package com.jal.stela.example.service.impl;

import com.jal.stela.example.dto.CommentDto;
import com.jal.stela.example.service.CommentsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier(value = "commentsService")
public class CommentsServiceImpl implements CommentsService {

    /**
     * The comments 'Repository'
     */
    private List<CommentDto> comments = new ArrayList<CommentDto>();

    @Override
    public List<CommentDto> getAll() {
        return comments;
    }

    @Override
    public CommentDto add(CommentDto updated) {
        comments.add(updated);
        return updated;
    }
}