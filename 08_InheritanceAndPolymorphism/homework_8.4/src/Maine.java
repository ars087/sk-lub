import java.util.ArrayList;
import java.util.List;

public class Maine {

    public final ArrayList<Employee> COMPANY_EMPLOYEES = new ArrayList<>();


    public static void main(String[] args) {

        Company company = new Company(30);

        Company company1 = new Company(10);


        Operator operator = new Operator(company);


        Manager manager = new Manager(company);


        TopManager topManager = new TopManager(company);

        Maine maine = new Maine();
        Maine maine1 = new Maine();

        maine.addEmployee(company, operator, 180);
        maine.addEmployee(company, manager, 80);
        maine.addEmployee(company, topManager, 10);


        company.hireALL(maine.COMPANY_EMPLOYEES);
        company1.hireALL(maine1.COMPANY_EMPLOYEES);


        System.out.println(company.getIncome());
        System.out.println(company1.getIncome());


        System.out.println(company.getSizeAllEmployee());

        System.out.println(company1.getSizeAllEmployee());

        List<Employee> list1 = company.getTopSalaryStaff(10);

        for (Employee employee : list1) {

            System.out.println(employee);

        }


        company.fire(135);

        System.out.println(company.getSizeAllEmployee());

        List<Employee> list = company.getLowestSalaryStaff(30);


        for (Employee employee : list) {

            System.out.println(employee);

        }


    }


    public void addEmployee(Company company, Employee employee, int count) {


        if (employee.equals(new Operator(company))) {

            int i = 0;

            if (COMPANY_EMPLOYEES.size() > 0) {
                i = COMPANY_EMPLOYEES.size();
                count = count + COMPANY_EMPLOYEES.size();

            }
            for (; i < count; i++) {

                COMPANY_EMPLOYEES.add(new Operator(company));

            }

        } else if (employee.equals(new Manager(company))) {

            int i = 0;

            if (COMPANY_EMPLOYEES.size() > 0) {
                i = COMPANY_EMPLOYEES.size();
                count = count + COMPANY_EMPLOYEES.size();

            }

            for (; i < count; i++) {


                COMPANY_EMPLOYEES.add(new Manager(company));
            }

        } else if (employee.equals(new TopManager(company))) {

            int i = 0;

            if (COMPANY_EMPLOYEES.size() > 0) {
                i = COMPANY_EMPLOYEES.size();
                count = count + COMPANY_EMPLOYEES.size();

            }

            for (; i < count; i++) {

                COMPANY_EMPLOYEES.add(new TopManager(company));
            }

        }

    }


}