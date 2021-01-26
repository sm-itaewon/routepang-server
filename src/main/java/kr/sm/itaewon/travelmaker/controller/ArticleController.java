package kr.sm.itaewon.travelmaker.controller;

import kr.sm.itaewon.travelmaker.model.Article;
import kr.sm.itaewon.travelmaker.repo.ArticleRepository;
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

    @GetMapping("/getAll")
    public ResponseEntity<List<Article>> getArticleAll(){

        List<Article> list = new ArrayList<>();
        Iterable<Article> articles = repository.findAll();

        articles.forEach(list::add);

        return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
    }

    @GetMapping("/getArticleById/{article_id}")
    public ResponseEntity<List<Article>> getArticleById(@PathVariable long article_id){

        List<Article> list = repository.findByArticleId(article_id);

        return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
    }

    @GetMapping("/getArticleByLocationId/{location_id}")
    public ResponseEntity<List<Article>> getArticleByLocationId(@PathVariable long location_id){

        List<Article> list = repository.findByLocationId(location_id);

        return new ResponseEntity<List<Article>>(list, HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<Void> postArticle(/*@RequestBody Article article*/){ // 나중에 파라미터로 받을 때 @RequestBody, @PostMapping 사용
        Article article = new Article();
//        Article model = article;
        article.setLocationId(1);
        article.setReg_date(new Timestamp(new Date().getTime()));
        article.setLink("https://");
        article.setSummary("");
        article.setImage("hello.jpg");
        article.setUserId(1);
        repository.save(article);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
