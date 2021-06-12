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
        if (company.getIncomeCompany() > 0) {


            setMonthSalary(FIXED_SALARY_OPERATOR);


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
        company.setIncomeCompany(company.getIncomeCompany() - super.getMonthSalary());

        return super.getMonthSalary();


    }


    @Override
    public int compareTo(Employee employee) {

        return Double.compare(getMonthSalary(), employee.getMonthSalary());


    }


}



