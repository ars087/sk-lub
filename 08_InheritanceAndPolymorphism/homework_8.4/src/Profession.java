public abstract class Profession implements Employee, Comparable<Employee> {


    Company company;
    private double monthSalary;
    // private double fixedSalary;
    private double bonusSalary;
    public static final double FIXED_SALARY_TOPMANAGER = 65000;
    public static final double FIXED_SALARY_MANAGER = 15000;
    public static final double FIXED_SALARY_OPERATOR = 35000;

    public static final double MANAGER_BONUS_PERCENTAGE = 5;
    public static final double HIGH_COMPANY_INCOME = 10000000;
    public static final double TOP_MANAGER_BONUS_PERCENTAGE = 150;
    public static final double ONE_HUNDRED_PERCENT = 100;


    Profession(Company company) {

        this.company = company;

    }


    public void setMonthSalary(double monthSalary) {
        this.monthSalary = monthSalary;
    }


    @Override
    public double getMonthSalary() {


        return monthSalary;
    }


    public void setBonusSalary(double bonusSalary) {
        this.bonusSalary = bonusSalary;
    }


    public double getBonusSalary() {
        return bonusSalary;
    }

    public static double getManagerBonusPercentage() {
        return MANAGER_BONUS_PERCENTAGE;
    }

    public static double getHighCompanyIncome() {
        return HIGH_COMPANY_INCOME;
    }

    public static double getTopManagerBonusPercentage() {
        return TOP_MANAGER_BONUS_PERCENTAGE;
    }

    public static double getDividendNumber() {
        return ONE_HUNDRED_PERCENT;
    }

    public abstract void termsOfWages();


}