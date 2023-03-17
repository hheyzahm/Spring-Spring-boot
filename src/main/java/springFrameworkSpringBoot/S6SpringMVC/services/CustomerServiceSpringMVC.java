package springFrameworkSpringBoot.S6SpringMVC.services;



import springFrameworkSpringBoot.S6SpringMVC.Model.CustomerSpringMVC;

import java.util.List;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:55 PM
 * @Author Hazeem Hassan
 */
public interface CustomerServiceSpringMVC {

    CustomerSpringMVC getCustomerById(UUID uuid);

    List<CustomerSpringMVC> getAllCustomers();

    CustomerSpringMVC saveNewCustomer(CustomerSpringMVC customerSpringMVC);

    void updateCustomerById(UUID customerId, CustomerSpringMVC customerSpringMVC);

    void deleteCustomerById(UUID customerId);
}
