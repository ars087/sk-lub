import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Company {


    Company(int count) {

        generatingIncome(count);

    }


    // public final ArrayList<Employee> COMPANY_EMPLOYEES = new ArrayList<>();
    public ArrayList<Employee> employeeArrayList = new ArrayList<>();

    private double incomeCompany;  //сумма  дохода компании


    public int getSizeAllEmployee() {

        return employeeArrayList.size();
    }


    public void generatingIncome(int day) {

        if (day > 0) {

            for (int i = 0; i < day; i++) {
                incomeCompany += 115000 + (int) (Math.random() * 25001);// ;
            }
        } else {
            System.out.println("Укажите верное  количество дней работы компании");
        }
    }


    public void printArrayList() {
        for (Employee arrayList1 : employeeArrayList) {

            System.out.println(arrayList1.getMonthSalary());
        }

    }


    public double getIncome() {

        return incomeCompany;
    }


    public void fire(int count) {

        if (count <= employeeArrayList.size() && count > 0) {
            int i = employeeArrayList.size();
            int size = i;

            for (; size < i + count; i--) {


                employeeArrayList.remove(i - 1);

            }

        } else {
            System.out.println(" Количество удаляемых объектов больше чем добавленных в списке. Измените пероваемое значение");
        }

    }


    public void hire(Employee employee) {


        employeeArrayList.add(employee);


    }


    public void hireALL(ArrayList<Employee> employee) {

        employeeArrayList.addAll(employee);

    }


    public List<Employee> getTopSalaryStaff(int count) {


        Collections.sort(employeeArrayList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {

                if (o1.getMonthSalary() > o2.getMonthSalary()) {

                    return -1;
                }
                if (o1.getMonthSalary() < o2.getMonthSalary()) {

                    return 1;
                }


                return 0;
            }
        });

        List<Employee> clonedList = null;
        if (employeeArrayList.size() >= count) {

            clonedList = employeeArrayList.subList(0, count);

        } else {
            System.out.println("Указанная величина превышет размер имеющегося списка");
        }

        return clonedList;

    }


    public List<Employee> getLowestSalaryStaff(int count) {

        Collections.sort(employeeArrayList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {

                if (o1.getMonthSalary() > o2.getMonthSalary()) {

                    return 1;
                }
                if (o1.getMonthSalary() < o2.getMonthSalary()) {

                    return -1;
                }


                return 0;
            }
        });

        List<Employee> clonedList = null;
        if (employeeArrayList.size() >= count) {

            clonedList = employeeArrayList.subList(0, count);

        } else {
            System.out.println("Указанная величина превышет размер имеющегося списка");
        }

        return clonedList;

    }

}

