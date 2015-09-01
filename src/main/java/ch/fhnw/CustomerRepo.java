package ch.fhnw;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

@RestResource
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Collection<Customer> findByName(@Param("name") String name);

}
