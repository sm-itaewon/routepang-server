package kr.sm.itaewon.travelmaker.controller;

import kr.sm.itaewon.travelmaker.model.Article;
import kr.sm.itaewon.travelmaker.model.Location;
import kr.sm.itaewon.travelmaker.repo.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationRepository repository;

    @GetMapping("/getAll")
    public ResponseEntity<List<Location>> getLocationAll(){

        List<Location> list = new ArrayList<>();
        Iterable<Location> articles = repository.findAll();

        articles.forEach(list::add);

        return new ResponseEntity<List<Location>>(list, HttpStatus.OK);
    }

    @GetMapping("/getLocationById/{location_id}")
    public ResponseEntity<List<Location>> getLocationByLocationId(@PathVariable long location_id){

        List<Location> list = repository.findByLocationId(location_id);

        return new ResponseEntity<List<Location>>(list, HttpStatus.OK);
    }

    //TODO postGIS 기능으로 수행할 수 있는 방법 모색, 지도 정보 저장 방식 검토
//    @GetMapping("/getLocationByCoordinate/latitude={latitude}&&longitude={longitude}")
//    public ResponseEntity<List<Location>> getLocationByCoordinate(@PathVariable long latitude,@PathVariable long longitude){
//
//
//    }

}
