package kr.co.sboard.controller;

import jakarta.servlet.http.HttpServlet;
import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.dto.PageResponseDTO;
import kr.co.sboard.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/artcle/list")
    public String list(Model model, PageResponseDTO pageRequestDTO) {

        PageResponseDTO pageResponseDTO = articleService.getArticleAll(pageRequestDTO);

        model.addAttribute(pageResponseDTO);

        return "artcle/list";
    }

    @GetMapping("/artcle/modify")
    public String modify(){
        return "artcle/modify";
    }

    @GetMapping("/artcle/searchList")
    public String searchList(){
        return "artcle/searchList";
    }

    @GetMapping("/artcle/view")
    public String view(){
        return "artcle/view";
    }

    @GetMapping("/artcle/write")
    public String write(){
        return "artcle/write";
    }

    @PostMapping("/article/write")
    public String write(ArticleDTO articleDTO, HttpServlet request){

        log.info("articleDTO = {}", articleDTO);

        // ArticleService.save(articleDTO);

        return "redirect:/artcle/list";
    }


}
