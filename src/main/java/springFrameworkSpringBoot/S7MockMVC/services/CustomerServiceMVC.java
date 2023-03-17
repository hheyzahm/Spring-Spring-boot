package springFrameworkSpringBoot.S7MockMVC.services;



import springFrameworkSpringBoot.S7MockMVC.Model.CustomerMVC;

import java.util.List;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:55 PM
 * @Author Hazeem Hassan
 */
public interface CustomerServiceMVC {

    CustomerMVC getCustomerById(UUID uuid);

    List<CustomerMVC> getAllCustomers();

    CustomerMVC saveNewCustomer(CustomerMVC customerMVC);

    void updateCustomerById(UUID customerId, CustomerMVC customerMVC);

    void deleteCustomerById(UUID customerId);
}
