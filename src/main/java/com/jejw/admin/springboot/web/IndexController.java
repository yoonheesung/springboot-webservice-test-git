package com.jejw.admin.springboot.web;

import com.jejw.admin.springboot.config.auth.LoginUser;
import com.jejw.admin.springboot.config.auth.dto.SessionUser;
import com.jejw.admin.springboot.service.PostsService;
import com.jejw.admin.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        // LoginUser Annotation으로 대체
        // SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            // `` userName으로 실행하면 window기본 설정 값을 가져와 이름을 제대로 처리 못함
            model.addAttribute("oauthName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";

    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findByid(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }


}
