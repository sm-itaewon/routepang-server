package kr.sm.ltaewon.travelmaker.controller;

import kr.sm.ltaewon.travelmaker.model.Article;
import kr.sm.ltaewon.travelmaker.repo.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ArticleControllerTest {


//    @Autowired
//    private ArticleRepository repository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAll() throws Exception{
        assert mockMvc != null;
        mockMvc.perform(get("/article/read")).andExpect(status().isOk());

    }
}