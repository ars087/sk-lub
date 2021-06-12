public class TopManager extends Profession {


    TopManager(Company company) {
        super(company);
        termsOfWages();

    }

    @Override
    public String toString() {

        return String.valueOf(getMonthSalary());

    }

    @Override
    public void termsOfWages() {
        if (company.getIncomeCompany() > HIGH_COMPANY_INCOME) {
            System.out.println(company.getIncomeCompany());
            setBonusSalary((FIXED_SALARY_TOPMANAGER * TOP_MANAGER_BONUS_PERCENTAGE) / ONE_HUNDRED_PERCENT);
            setMonthSalary(getBonusSalary() + FIXED_SALARY_TOPMANAGER);


        } else {
            setMonthSalary(FIXED_SALARY_TOPMANAGER);


        }
    }


    @Override
    public double getMonthSalary() {

        company.setIncomeCompany(company.getIncomeCompany() - super.getMonthSalary());
        return super.getMonthSalary();
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
    public int compareTo(Employee employee) {
        return Double.compare(getMonthSalary(), employee.getMonthSalary());


    }
}
