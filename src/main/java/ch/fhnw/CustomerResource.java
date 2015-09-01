package ch.fhnw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author Hasan Kara <hasan.kara@fhnw.ch>
 */
@RestController
@RequestMapping("/api")
public class CustomerResource {

    @Autowired
    CustomerRepo repo;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public Collection<Customer> findAllCustomers() {
        return repo.findAll();
    }

}
