import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "purchaselist")
public class PurchaseList {
 @Id
  @Column(name ="student_name")
    private String studentName;

 @Id
 @Column(name ="course_name")
private String courseName;
private  int price;
    @Column(name ="subscription_date")
private LocalDateTime subscriptionDate;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getSubscriptionDate() {
        return  subscriptionDate;
    }

    public void setSubscriptionDate(LocalDateTime subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }


    @Override
    public boolean equals(Object obj) {
         PurchaseList purchaseList =(PurchaseList) obj;


        return   this.courseName.equals(purchaseList.courseName);
    }

    @Override
    public int hashCode() {


        return Objects.hash(courseName);
    }
}
