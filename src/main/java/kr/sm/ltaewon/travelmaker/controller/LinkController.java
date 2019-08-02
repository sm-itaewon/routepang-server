package kr.sm.ltaewon.travelmaker.controller;

import kr.sm.ltaewon.travelmaker.model.Link;
        import kr.sm.ltaewon.travelmaker.repo.LinkRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private LinkRepository repository;

    @PostMapping("/")
    public ResponseEntity<Link> postLink(@RequestBody Link link){

        link.LinkApi();

        if(link.getLink() == null){
            return new ResponseEntity<Link>(HttpStatus.NO_CONTENT);
        }else{
            repository.save(link);

            return new ResponseEntity<Link>(link, HttpStatus.CREATED);
        }
    }
}