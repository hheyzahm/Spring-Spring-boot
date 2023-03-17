package springFrameworkSpringBoot.S7MockMVC.services;



import springFrameworkSpringBoot.S7MockMVC.Model.CustomerMockMVC;

import java.util.List;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:55 PM
 * @Author Hazeem Hassan
 */
public interface CustomerServiceMockMVC {

    CustomerMockMVC getCustomerById(UUID uuid);

    List<CustomerMockMVC> getAllCustomers();

    CustomerMockMVC saveNewCustomer(CustomerMockMVC customerMockMVC);

    void updateCustomerById(UUID customerId, CustomerMockMVC customerMockMVC);

    void deleteCustomerById(UUID customerId);
}
