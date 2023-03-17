package springFrameworkSpringBoot.S6SpringMVC.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springFrameworkSpringBoot.S6SpringMVC.Model.CustomerSpringMVC;
import springFrameworkSpringBoot.S6SpringMVC.services.CustomerServiceSpringMVC;

import java.util.List;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:57 PM
 * @Author Hazeem Hassan
 */
@RequestMapping("/SpringMVC/api/v1/MockMVC/customer/")
@RequiredArgsConstructor
@RestController
public class CustomerControllerSpringMVC {

    private final CustomerServiceSpringMVC customerServiceSpringMVC;

    @DeleteMapping("{customerId}")
    public ResponseEntity deleteCustomerByIdSpringMVC(@PathVariable("customerId") UUID customerId){

        customerServiceSpringMVC.deleteCustomerById(customerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{customerId}")
    public ResponseEntity updateCustomerByIDSpringMVC(@PathVariable("customerId") UUID customerId,
                                             @RequestBody CustomerSpringMVC customerSpringMVC){

        customerServiceSpringMVC.updateCustomerById(customerId, customerSpringMVC);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity handlePostSpringMVC(@RequestBody CustomerSpringMVC customerSpringMVC){
        CustomerSpringMVC savedCustomerSpringMVC = customerServiceSpringMVC.saveNewCustomer(customerSpringMVC);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/MockMVC/customer/" + savedCustomerSpringMVC.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CustomerSpringMVC> listAllCustomersSpringMVC(){
        return customerServiceSpringMVC.getAllCustomers();
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public CustomerSpringMVC getCustomerByIdSpringMVC(@PathVariable("customerId") UUID id){
        return customerServiceSpringMVC.getCustomerById(id);
    }

}