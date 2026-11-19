package o2m.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import o2m.entities.Department;
import o2m.entities.Employee;

import java.util.List;

public class FetchDeptEmp {
    static void main() {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory(
                "one_to_many");
        EntityManager em = emf.createEntityManager();

        List<Department> departments
                /*
                    1 query to fetch all the departments
                    n queries to fetch employees for each dept
                    Total queries (n+1)

                    e.g    20 Departments
                   1 query to fetch all the departments
                   for 20 departments, 20 queries to fetch associated
                   employees

                   1 + 20 = 21
                 */
//                = em.createQuery("FROM Department",

                /*
                Fix for n+1 query problem

                Here, all the departments and associated
                employees will be fetched in a single query
                 */
                = em.createQuery("""
                        SELECT d
                        FROM Department d
                        JOIN FETCH d.employees
                        """,
                        Department.class)
                .getResultList();

        System.out.println("Department list:");
        departments.forEach(
                dept->{
                    System.out.printf("""
                            Name: %s
                            Employees:
                            """, dept.getName());

                    //Fetching associated employees for each department
                    List<Employee> employees= dept.getEmployees();
                    employees.forEach(
                            e->{
                                System.out.printf("""
                                        Name: %s
                                        Phone: %s
                                        Email: %s
                                        -----------
                                        """,
                                e.getName(),e.getMobile(),e.getEmail());
                            }
                    );
                }
        );

    }
}
