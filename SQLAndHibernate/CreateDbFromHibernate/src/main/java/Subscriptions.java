import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Subscriptions")
public class Subscriptions implements Serializable {

    public Subscriptions(Courses coursesId, Students studentsId) {
        this.courseId = coursesId;
        this.studentId = studentsId;

    }


    public Subscriptions(){

    }

    //
// public Subscriptions(Students students ){
//
//  this.students= students;
// }
    @Id
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Courses courseId;
    @Id
    @ManyToOne
    @JoinColumn(name = "student_id" )
    private Students studentId;

    @Column(name = "subscription_date", columnDefinition = "datetime")
    private LocalDateTime localDateTime;


    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        Subscriptions subscriptions = (Subscriptions) obj;
        return Objects.equals(getCourseId(), subscriptions.getCourseId()) &&
                Objects.equals(getStudentId(), subscriptions.getStudentId());

    }


    @Override
    public int hashCode() {
        return Objects.hash(courseId, studentId);
    }






    public Courses getCourseId() {
        return courseId;
    }

    public void setCourseId(Courses courseId) {
        this.courseId = courseId;
    }

    public Students getStudentId() {
        return studentId;
    }

    public void setStudentId(Students studentId) {
        this.studentId = studentId;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }





}
