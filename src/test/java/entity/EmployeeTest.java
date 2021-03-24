package entity;

import entity.embeddableEntities.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.DAO;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    DAO<Employee> dao;

    @BeforeEach
    void dao() {
        dao = new DAO<>(Employee.class);
    }

    @Test
    void createEmployeeTest() {
        Address address = new Address("Brasília", "Taguatinga");
        Employee employee = new Employee("Pedro", address);
        dao.insertAtomic(employee).closeEntityManager();

        Assertions.assertNotNull(employee.getId());
    }

}