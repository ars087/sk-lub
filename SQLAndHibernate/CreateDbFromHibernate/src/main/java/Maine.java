import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class Maine {


    public static void main(String[] args) {


        //     String hql = " from Subscriptions";


        String hqlLinked = " from LinkedPurchaseList subscriptionsKey ";


        try {

            // Maine.copyIdInLinkedPurchaseList(hql);
            persistToLinkedPurchaseList(hqlLinked);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }
    }


    public static void persistToLinkedPurchaseList(String hql) throws Exception {


        Session session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        Query query = session.createQuery(hql);

        List<LinkedPurchaseList> linkedPurchaseListListOne = query.getResultList();
        for (LinkedPurchaseList p : linkedPurchaseListListOne) {

            int studentId = p.getSubscriptionsKey().getStudentId();
            int coursesId = p.getSubscriptionsKey().getCourseId();

            var students = session.get(Students.class, studentId);
            var courses = session.get(Courses.class, coursesId);

            PurchaseList purchaseList = new PurchaseList();
            purchaseList.setStudentName(students.getName());
            purchaseList.setCourseName(courses.getName());

            PurchaseList purchaseListOne = session.get(PurchaseList.class, purchaseList);

            var ses = session.get(LinkedPurchaseList.class, new LinkedPurchaseKey(studentId, coursesId));

            ses.setLocalDateTime(purchaseListOne.getSubscriptionDate());
            ses.setCourseName(purchaseListOne.getCourseName());
            ses.setStudentName(purchaseListOne.getStudentName());
            ses.setPrice(purchaseListOne.getPrice());
            session.persist(ses);
            session.flush();


        }

        transaction.commit();
        session.close();


    }


    public static void copyIdInLinkedPurchaseList(String hql) throws Exception {

        Session session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        Query query = session.createQuery(hql);

        List<Subscriptions> list = query.getResultList();

        for (Subscriptions p : list) {

            int studentId = p.getStudentId().getId();
            int coursesId = p.getCourseId().getId();
            LinkedPurchaseKey subscriptionsKey = new LinkedPurchaseKey(studentId, coursesId);
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
            linkedPurchaseList.setSubscriptionsKey(subscriptionsKey);

            session.persist(linkedPurchaseList);
            session.flush();


        }

        transaction.commit();
        session.close();


    }


}



