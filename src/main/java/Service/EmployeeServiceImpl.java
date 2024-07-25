package Service;

import Entity.Employee;
import Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeerepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeerepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeerepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeerepository.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeerepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeerepository.deleteById(theId);
    }
}


