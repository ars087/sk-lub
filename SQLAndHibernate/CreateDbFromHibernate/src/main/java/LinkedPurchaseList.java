import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList {

  @EmbeddedId
  private LinkedPurchaseKey subscriptionsKey;


  @Column(name = "subscription_date", columnDefinition = "datetime")
  private LocalDateTime localDateTime;

  @Column(name = "course_name")
  private String courseName;

  @Column(name = "student_name")
  private String studentName;

  private int price;


  public LinkedPurchaseKey getSubscriptionsKey() {
    return subscriptionsKey;
  }

  public void setSubscriptionsKey(LinkedPurchaseKey subscriptionsKey) {
    this.subscriptionsKey = subscriptionsKey;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public LocalDateTime getLocalDateTime() {
    return localDateTime;
  }

  public void setLocalDateTime(LocalDateTime localDateTime) {
    this.localDateTime = localDateTime;
  }

}
