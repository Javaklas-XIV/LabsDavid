package trainee.david.webshop.model.repo;

import trainee.david.webshop.model.Customer;

import java.util.Optional;

public class CustomerRepo extends LocalRepository<Customer> {

    public Optional<Customer> find(String name) {
        return getAll().stream().filter(customer -> customer.getName().equals(name)).findFirst();
    }

}
