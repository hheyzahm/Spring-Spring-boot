package springFrameworkSpringBoot.S6SpringMVC.services;

import org.springframework.stereotype.Service;
import springFrameworkSpringBoot.S6SpringMVC.Model.CustomerSpringMVC;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @Created 17 03 2023 - 5:56 PM
 * @Author Hazeem Hassan
 */
@Service
public class CustomerServiceSpringMVCImpl implements CustomerServiceSpringMVC {

    private Map<UUID, CustomerSpringMVC> customerMap;

    public CustomerServiceSpringMVCImpl() {
        CustomerSpringMVC customerSpringMVC1 = CustomerSpringMVC.builder()
                .id(UUID.randomUUID())
                .name("Customer 1")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerSpringMVC customerSpringMVC2 = CustomerSpringMVC.builder()
                .id(UUID.randomUUID())
                .name("Customer 2")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerSpringMVC customerSpringMVC3 = CustomerSpringMVC.builder()
                .id(UUID.randomUUID())
                .name("Customer 3")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        customerMap = new HashMap<>();
        customerMap.put(customerSpringMVC1.getId(), customerSpringMVC1);
        customerMap.put(customerSpringMVC2.getId(), customerSpringMVC2);
        customerMap.put(customerSpringMVC3.getId(), customerSpringMVC3);
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        customerMap.remove(customerId);
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerSpringMVC customerSpringMVC) {
        CustomerSpringMVC existing = customerMap.get(customerId);
        existing.setName(customerSpringMVC.getName());
    }

    @Override
    public CustomerSpringMVC saveNewCustomer(CustomerSpringMVC customerSpringMVC) {

        CustomerSpringMVC savedCustomerSpringMVC = CustomerSpringMVC.builder()
                .id(UUID.randomUUID())
                .version(1)
                .updateDate(LocalDateTime.now())
                .createdDate(LocalDateTime.now())
                .name(customerSpringMVC.getName())
                .build();

        customerMap.put(savedCustomerSpringMVC.getId(), savedCustomerSpringMVC);

        return savedCustomerSpringMVC;
    }

    @Override
    public CustomerSpringMVC getCustomerById(UUID uuid) {
        return customerMap.get(uuid);
    }

    @Override
    public List<CustomerSpringMVC> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }
}
