import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LinkedPurchaseKey implements Serializable {





    public LinkedPurchaseKey(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;

    }
    public LinkedPurchaseKey(){

    }
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "course_id")
    private int courseId;


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;

        LinkedPurchaseKey subscriptionsKey = (LinkedPurchaseKey) obj;
        return Objects.equals(this.getCourseId(), subscriptionsKey.getCourseId())
                && Objects.equals(this.getStudentId(), subscriptionsKey.getStudentId());
    }


    @Override
    public int hashCode() {


        return Objects.hash(getCourseId(), getStudentId());
    }
}
