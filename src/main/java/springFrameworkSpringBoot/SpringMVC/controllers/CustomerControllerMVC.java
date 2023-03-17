package springFrameworkSpringBoot.SpringMVC.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springFrameworkSpringBoot.SpringMVC.Model.CustomerMVC;
import springFrameworkSpringBoot.SpringMVC.services.CustomerServiceMVC;

import java.util.List;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:57 PM
 * @Author Hazeem Hassan
 */
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
@RestController
public class CustomerControllerMVC {

    private final CustomerServiceMVC customerServiceMVC;

    @DeleteMapping("{customerId}")
    public ResponseEntity deleteCustomerById(@PathVariable("customerId") UUID customerId){

        customerServiceMVC.deleteCustomerById(customerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{customerId}")
    public ResponseEntity updateCustomerByID(@PathVariable("customerId") UUID customerId,
                                             @RequestBody CustomerMVC customerMVC){

        customerServiceMVC.updateCustomerById(customerId, customerMVC);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerMVC customerMVC){
        CustomerMVC savedCustomerMVC = customerServiceMVC.saveNewCustomer(customerMVC);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + savedCustomerMVC.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CustomerMVC> listAllCustomers(){
        return customerServiceMVC.getAllCustomers();
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public CustomerMVC getCustomerById(@PathVariable("customerId") UUID id){
        return customerServiceMVC.getCustomerById(id);
    }

}