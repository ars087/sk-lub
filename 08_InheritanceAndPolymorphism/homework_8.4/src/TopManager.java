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
    public double getMonthSalary() {
        return super.getMonthSalary();
    }

    @Override
    public void termsOfWages() {
        if (company.getIncome() > HIGH_COMPANY_INCOME) {
            System.out.println(company.getIncome());
            setBonusSalary(FIXED_SALARY_TOPMANAGER * TOP_MANAGER_BONUS_PERCENTAGE / DIVIDEND_NUMBER);
            // System.out.println("Бонус Топменеджера составляет" + getBonusSalary());
            setMonthSalary(getBonusSalary() + FIXED_SALARY_TOPMANAGER);

        } else {
            setMonthSalary(FIXED_SALARY_TOPMANAGER);
            //System.out.println("Бонус в этом месяце отсутствует");


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
    public int compareTo(Employee employee) {
        if (getMonthSalary() > employee.getMonthSalary()) {

            return 1;
        }

        if (getMonthSalary() < employee.getMonthSalary()) return -1;


        return 0;
    }
}
