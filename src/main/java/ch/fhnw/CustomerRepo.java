package ch.fhnw;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Collection<Customer> findByName(String name);

}
