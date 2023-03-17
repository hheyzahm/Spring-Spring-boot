package springFrameworkSpringBoot.S7MockMVC.services;

import org.springframework.stereotype.Service;
import springFrameworkSpringBoot.S7MockMVC.Model.CustomerMockMVC;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @Created 17 03 2023 - 5:56 PM
 * @Author Hazeem Hassan
 */
@Service
public class CustomerServiceMockMVCImpl implements CustomerServiceMockMVC {

    private Map<UUID, CustomerMockMVC> customerMap;

    public CustomerServiceMockMVCImpl() {
        CustomerMockMVC customerMockMVC1 = CustomerMockMVC.builder()
                .id(UUID.randomUUID())
                .name("Customer 1")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerMockMVC customerMockMVC2 = CustomerMockMVC.builder()
                .id(UUID.randomUUID())
                .name("Customer 2")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerMockMVC customerMockMVC3 = CustomerMockMVC.builder()
                .id(UUID.randomUUID())
                .name("Customer 3")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        customerMap = new HashMap<>();
        customerMap.put(customerMockMVC1.getId(), customerMockMVC1);
        customerMap.put(customerMockMVC2.getId(), customerMockMVC2);
        customerMap.put(customerMockMVC3.getId(), customerMockMVC3);
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        customerMap.remove(customerId);
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerMockMVC customerMockMVC) {
        CustomerMockMVC existing = customerMap.get(customerId);
        existing.setName(customerMockMVC.getName());
    }

    @Override
    public CustomerMockMVC saveNewCustomer(CustomerMockMVC customerMockMVC) {

        CustomerMockMVC savedCustomerMockMVC = CustomerMockMVC.builder()
                .id(UUID.randomUUID())
                .version(1)
                .updateDate(LocalDateTime.now())
                .createdDate(LocalDateTime.now())
                .name(customerMockMVC.getName())
                .build();

        customerMap.put(savedCustomerMockMVC.getId(), savedCustomerMockMVC);

        return savedCustomerMockMVC;
    }

    @Override
    public CustomerMockMVC getCustomerById(UUID uuid) {
        return customerMap.get(uuid);
    }

    @Override
    public List<CustomerMockMVC> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }
}
