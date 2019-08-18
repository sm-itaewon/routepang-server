package kr.sm.itaewon.travelmaker.repo;

import com.vividsolutions.jts.geom.Point;
import kr.sm.itaewon.travelmaker.model.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location, Long> {

    List<Location> findByLocationId(long loacation_id);

    @Query(value = "SELECT * FROM location WHERE ST_DWithin(gps, ST_Transform(ST_GeomFromText('POINT(127.01937675476074 37.50916413798163)', 4326), 2097), 500)",
            nativeQuery = true)
    List<Location> findByCoordinate(Point coordinate);
}
