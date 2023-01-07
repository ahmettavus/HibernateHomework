package service;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class MainService {

    public void run() {

        Department department = new Department();
        department.setName("GS");
        department.setLocation("Vodofone Arena");


        Employee employee1 = new Employee("Fernando", "Muslera", 1000, department);
        Employee employee2 = new Employee("Arda", "Turan", 200, department);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);

        department.setEmployees(employeeList);

//        department.getEmployees().add(employee1);
//        department.getEmployees().add(employee2);


        Customer customer = new Customer() ;
        customer.setName("Ahmet Tavus");
        customer.setEmail("ahmettavus40@gmail.com");
        customer.setAddress("Ankara Batikent");


        Order order1 = new Order("General", 2000.0,customer);
        Order order2 = new Order("Necessary", 500.0, customer);
        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);

        Product product = new Product("Krampon", 50,orderList);
        order1.setProduct(product);
        order2.setProduct(product);
        customer.setOrders(orderList);


        Session session=HibernateUtil.getSessionFactory().openSession();
        //Transaction has been created before objects saved
        Transaction tx= session.beginTransaction();
        session.persist(department);
        session.persist(employee1);
        session.persist(employee2);
        session.persist(order1);
        session.persist(order2);
        session.persist(customer);
        session.persist(product);

        tx.commit();

        //session closed
        session.close();

    }

}
