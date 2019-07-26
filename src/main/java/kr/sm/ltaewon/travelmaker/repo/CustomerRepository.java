package kr.sm.ltaewon.travelmaker.repo;

import kr.sm.ltaewon.travelmaker.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
