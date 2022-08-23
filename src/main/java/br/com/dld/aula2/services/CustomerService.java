package br.com.dld.aula2.services;

import br.com.dld.aula2.models.entities.Customer;
import br.com.dld.aula2.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author David Duarte
 * @created 09/08/2022
 * @project aula-1
 */
@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    public Optional<Customer> findById(long id) {
        return customerRepository.findById(id);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public List<Customer> findAllByName(String name) {
        return customerRepository.findAllByNameContains(name);
    }

    public List<Customer> findAllByCity(String name) {
        return customerRepository.findAllByCityContains(name);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void delete(long id) {
        customerRepository.deleteById(id);
    }
}
