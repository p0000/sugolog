package com.jal.stela.example.controller;

import com.jal.stela.example.dto.CommentDto;
import com.jal.stela.example.service.CommentsService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class MainController {

    @Resource
    CommentsService commentsService;

    /**
     * Returns the main page when the webapp is accessed.
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "example/main";
    }

    @RequestMapping(value = "/comments", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public List<CommentDto> get()  {

        return commentsService.getAll();
    }

    @RequestMapping(value = "/comments", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public List<CommentDto> post(@RequestBody final CommentDto updated) {

        commentsService.add(updated);
        return commentsService.getAll();
    }

}
