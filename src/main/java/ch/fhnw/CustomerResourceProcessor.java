package ch.fhnw;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomerResourceProcessor implements ResourceProcessor<Resource<Customer>> {

    @Override
    public Resource<Customer> process(Resource<Customer> customerResource) {

        Long customerId = customerResource.getContent().getId();
        customerResource.add(new Link("http://image-microsserice.com/" + customerId + ".png", "profile-image"));

        return customerResource;
    }

}
