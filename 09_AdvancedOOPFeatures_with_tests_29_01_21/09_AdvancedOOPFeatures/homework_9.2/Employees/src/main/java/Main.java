import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";


    public static void main(String[] args) throws ParseException {

        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);

        System.out.println(findEmployeeWithHighestSalary(staff, 2022));


    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) throws ParseException {

        Date simpleDateFormat = new SimpleDateFormat("yyyy").parse(String.valueOf(year));
               Optional<Employee> optional = staff.stream()
                       .filter(employee -> employee.getWorkStart().getYear() == simpleDateFormat.getYear())
                       .max(Comparator.comparing(Employee::getSalary));


        return optional.orElse(null);


    }
}