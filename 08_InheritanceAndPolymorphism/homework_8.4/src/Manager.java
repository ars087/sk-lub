public class Manager extends Profession {

    int numberOfdays;

    Manager(Company company) {
        super(company);
        this.numberOfdays = company.numberOfdays;
        termsOfWages();

    }


    public void termsOfWages() {

        if (company.getIncomeCompany() > 0) {
            double managerBonus = (getProfitForCompany() * MANAGER_BONUS_PERCENTAGE) / ONE_HUNDRED_PERCENT;
            setBonusSalary(managerBonus);


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

        company.setIncomeCompany(company.getIncomeCompany() - super.getMonthSalary());
        return super.getMonthSalary();
    }


    public double getProfitForCompany() {

        double profit = 0;
        if (numberOfdays >= 0) {

            for (int i = 0; i < numberOfdays; i++) {

                profit += 115000 + (int) (Math.random() * 25000);
            }


        }


        return profit;
    }


    @Override
    public int compareTo(Employee employee) {

        return Double.compare(getMonthSalary(), employee.getMonthSalary());


    }
}





