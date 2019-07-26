package kr.sm.ltaewon.travelmaker.repo;

import kr.sm.ltaewon.travelmaker.model.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ArticleRepository extends CrudRepository<Article, Long> {

    //List<Article> findByLocationId(int loacation_id);
}
