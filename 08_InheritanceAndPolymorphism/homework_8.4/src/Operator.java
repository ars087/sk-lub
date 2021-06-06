public class Operator extends Profession {


    Operator(Company company) {

        super(company);
        termsOfWages();
    }


    @Override
    public String toString() {

        return String.valueOf(getMonthSalary());


    }


    @Override
    public void termsOfWages() {
        if (company.getIncome() > 0) {

            setMonthSalary(FIXED_SALARY_OPERATOR);
            // System.out.println("Оклад оператора сформирован");


        }


    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        // 2
        return obj != null && getClass() == obj.getClass();
    }


    @Override
    public double getMonthSalary() {


        return super.getMonthSalary();


    }

    @Override
    public double getProfitForCompany() {

        int profit = 0;

        for (Employee employee :company.employeeAll) {

            if (employee instanceof Operator) {

                profit += employee.getMonthSalary();

            }

        }

        return profit;
    }

    @Override
    public int compareTo(Employee employee) {

        if (getMonthSalary() > employee.getMonthSalary()) {

            return 1;
        }

        if (getMonthSalary() < employee.getMonthSalary()) return -1;


        return 0;


    }


}



