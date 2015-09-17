package com.jal.stela.example.service;

import com.jal.stela.example.dto.CommentDto;

import java.util.List;

public interface CommentsService {

    public List<CommentDto> getAll();

    public CommentDto add(CommentDto updated);
}
