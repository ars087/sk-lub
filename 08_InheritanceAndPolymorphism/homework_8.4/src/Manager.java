public class Manager extends Profession {

    Manager(Company company) {
        super(company);
        termsOfWages();
    }


    public void termsOfWages() {
        if (company.getIncome() > 0) {
            // System.out.println(company.getIncome());
            setBonusSalary((company.getIncome() * MANAGER_BONUS_PERCENTAGE) / DIVIDEND_NUMBER);
            // System.out.println("Бонус менеджера составляет" + getBonusSalary());
            setMonthSalary(getBonusSalary() + FIXED_SALARY_MANAGER);

        } else {
            setMonthSalary(FIXED_SALARY_MANAGER);
            //  System.out.println("У компании отсутствует доход. Бонус менеджера  в этом месяце отсутствует!");

        }

    }

    @Override
    public String toString() {

        return String.valueOf(getMonthSalary());


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
    public int compareTo(Employee employee) {

        if (getMonthSalary() > employee.getMonthSalary()) {

            return 1;
        }

        if (getMonthSalary() < employee.getMonthSalary()) return -1;


        return 0;


    }
}





