package springFrameworkSpringBoot.S7MockMVC.services;

import org.springframework.stereotype.Service;
import springFrameworkSpringBoot.S7MockMVC.Model.CustomerMVC;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @Created 17 03 2023 - 5:56 PM
 * @Author Hazeem Hassan
 */
@Service
public class CustomerServiceMVCImpl implements CustomerServiceMVC {

    private Map<UUID, CustomerMVC> customerMap;

    public CustomerServiceMVCImpl() {
        CustomerMVC customerMVC1 = CustomerMVC.builder()
                .id(UUID.randomUUID())
                .name("Customer 1")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerMVC customerMVC2 = CustomerMVC.builder()
                .id(UUID.randomUUID())
                .name("Customer 2")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerMVC customerMVC3 = CustomerMVC.builder()
                .id(UUID.randomUUID())
                .name("Customer 3")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        customerMap = new HashMap<>();
        customerMap.put(customerMVC1.getId(), customerMVC1);
        customerMap.put(customerMVC2.getId(), customerMVC2);
        customerMap.put(customerMVC3.getId(), customerMVC3);
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        customerMap.remove(customerId);
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerMVC customerMVC) {
        CustomerMVC existing = customerMap.get(customerId);
        existing.setName(customerMVC.getName());
    }

    @Override
    public CustomerMVC saveNewCustomer(CustomerMVC customerMVC) {

        CustomerMVC savedCustomerMVC = CustomerMVC.builder()
                .id(UUID.randomUUID())
                .version(1)
                .updateDate(LocalDateTime.now())
                .createdDate(LocalDateTime.now())
                .name(customerMVC.getName())
                .build();

        customerMap.put(savedCustomerMVC.getId(), savedCustomerMVC);

        return savedCustomerMVC;
    }

    @Override
    public CustomerMVC getCustomerById(UUID uuid) {
        return customerMap.get(uuid);
    }

    @Override
    public List<CustomerMVC> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }
}
