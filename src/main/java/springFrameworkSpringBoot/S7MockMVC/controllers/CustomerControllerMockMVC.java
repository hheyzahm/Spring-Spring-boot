package springFrameworkSpringBoot.S7MockMVC.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springFrameworkSpringBoot.S7MockMVC.Model.CustomerMockMVC;
import springFrameworkSpringBoot.S7MockMVC.services.CustomerServiceMockMVC;

import java.util.List;
import java.util.UUID;

/**
 * @Created 17 03 2023 - 5:57 PM
 * @Author Hazeem Hassan
 */
@RequestMapping("/api/v1/MockMVC/customer/")
@RequiredArgsConstructor
@RestController
public class CustomerControllerMockMVC {

    private final CustomerServiceMockMVC customerServiceMockMVC;

    @DeleteMapping("{customerId}")
    public ResponseEntity deleteCustomerByIdMockMVC(@PathVariable("customerId") UUID customerId){

        customerServiceMockMVC.deleteCustomerById(customerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{customerId}")
    public ResponseEntity updateCustomerByIDMockMVC(@PathVariable("customerId") UUID customerId,
                                             @RequestBody CustomerMockMVC customerMockMVC){

        customerServiceMockMVC.updateCustomerById(customerId, customerMockMVC);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity handlePostMockMVC(@RequestBody CustomerMockMVC customerMockMVC){
        CustomerMockMVC savedCustomerMockMVC = customerServiceMockMVC.saveNewCustomer(customerMockMVC);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/MockMVC/customer/" + savedCustomerMockMVC.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CustomerMockMVC> listAllCustomersMockMVC(){
        return customerServiceMockMVC.getAllCustomers();
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public CustomerMockMVC getCustomerByIdMockMVC(@PathVariable("customerId") UUID id){
        return customerServiceMockMVC.getCustomerById(id);
    }

}