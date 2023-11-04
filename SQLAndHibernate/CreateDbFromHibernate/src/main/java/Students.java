import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Students")
public class Students implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id ;
   private String name;
   private int age;
   @Column(name = "registration_date")
   private LocalDateTime localDateTime;

   @OneToMany(mappedBy = "studentId",orphanRemoval = true,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   private List<Subscriptions> list = new ArrayList<>();


   public List<Subscriptions> getList() {
      return list;
   }

   public void setList(Subscriptions subscriptions ) {
     list.add(subscriptions);
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

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public LocalDateTime getLocalDateTime() {
      return localDateTime;
   }

   public void setLocalDateTime(LocalDateTime localDateTime) {
      this.localDateTime = localDateTime;
   }


   @Override
   public boolean equals(Object obj) {
     if (  this ==obj) return  true;
     if ( null==obj || this.getClass() !=obj.getClass()  )return false;

     Students students = (Students) obj;
        return Objects.equals( this.id , students.id ) && Objects.equals(this.name,students.name );
   }

   @Override
   public int hashCode() {
      return Objects.hash(id,name);
   }



}

