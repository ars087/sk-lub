import java.util.ArrayList;

public class Maine {

    public final ArrayList<Employee> COMPANY_EMPLOYEES = new ArrayList<>();


    public static void main(String[] args) {

        Company company = new Company(1);


        Operator operator = new Operator(company);


        Manager manager = new Manager(company);


        Maine maine = new Maine();
        Maine maine1 = new Maine();


        System.out.println(company.getIncomeCompany());

        TopManager topManager = new TopManager(company);

        //   maine.addEmployee(company, topManager, 15);
        //   maine.addEmployee(company, operator, 15);
        maine.addEmployee(company, manager, 23);

        company.hireALL(maine.COMPANY_EMPLOYEES);


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