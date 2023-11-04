import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Courses")
public class Courses implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int duration;
    @Enumerated(EnumType.STRING)
    // @Column(columnDefinition =  "enum('DESIGN','PROGRAMMING','MARKETING','MANAGEMENT','BUSINESS')")
    private CourseType type;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private Teachers teacher;

    @Column(name = "subscription_date", columnDefinition = "datetime")
    private LocalDateTime subscriptionDate;


    @Column(name = "students_count")
    private int studentsCount;
    private int price;
    @Column(name = "price_per_hour")
    private float pricePerHour;


    @OneToMany(mappedBy = "courseId", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Subscriptions> list = new ArrayList<>();

   public void addList(Students students) {

        Subscriptions subscriptions = new Subscriptions(this, students);
        list.add(subscriptions);
        students.setList(subscriptions);

    }


 public void removeList(Students students) {
        Subscriptions subscriptions = new Subscriptions(this, students);
        students.getList().remove(subscriptions);
        list.remove(subscriptions);
        subscriptions.setStudentId(null);
        subscriptions.setCourseId(null);
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (null == obj || this.getClass() != obj.getClass()) return false;
        Courses courses = (Courses) obj;


        return Objects.equals(name, courses.name);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public CourseType getType() {
        return type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teachers getTeachers() {
        return teacher;
    }

    public void setTeacherId(Teachers teachers) {
        this.teacher = teachers;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }






}
