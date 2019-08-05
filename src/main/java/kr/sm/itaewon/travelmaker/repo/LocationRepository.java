package kr.sm.itaewon.travelmaker.repo;

import kr.sm.itaewon.travelmaker.model.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location, Long> {

    List<Location> findByLocationId(long loacation_id);
}
