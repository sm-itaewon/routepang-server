package kr.sm.ltaewon.travelmaker.controller;

import kr.sm.ltaewon.travelmaker.model.Article;
import kr.sm.ltaewon.travelmaker.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleRepository repository;

    @GetMapping("/read")
    public ResponseEntity<List<Article>> getArticleAll(){

        List<Article> list = new ArrayList<>();
        Iterable<Article> articles = repository.findAll();

        articles.forEach(list::add);

        return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<Void> postArticle(/*@RequestBody Article article*/){ // 나중에 파라미터로 받을 때 @RequestBody, @PostMapping 사용
        Article article = new Article();

        article.setLocation_id(1);
        article.setReg_date(new Timestamp(new Date().getTime()));
        article.setLink("https://");
        article.setSummary("");
        article.setImage("hello.jpg");
        article.setUser_id(1);
        repository.save(article);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
