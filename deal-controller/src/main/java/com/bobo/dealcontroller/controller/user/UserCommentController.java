package com.bobo.dealcontroller.controller.user;

import com.bobo.deal.bean.Comment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserCommentController {

    @RequestMapping("/postComment")
    public List<Comment> getCommentList(int product_id){
        return null;
    }
}
