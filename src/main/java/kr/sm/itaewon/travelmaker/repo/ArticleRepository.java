package kr.sm.itaewon.travelmaker.repo;

import kr.sm.itaewon.travelmaker.model.Article;
import org.springframework.data.repository.CrudRepository;


public interface ArticleRepository extends CrudRepository<Article, Long> {

    //List<Article> findByLocationId(int loacation_id);
}
