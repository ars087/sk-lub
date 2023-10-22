import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class Maine {


        public static void main(String[] args) {

            Session session = HibernateUtil.getSessionFactory().openSession();
            var transaction = session.beginTransaction();
            String hql = " select  p.courseName, " +
                    " if( month(min(p.subscriptionDate)) > 1, " +
                    "count(*)/ ( month(max(p.subscriptionDate)) - month(min(p.subscriptionDate)) +1) ,count(*) /(month(max(p.subscriptionDate))))`count`  " +
                    " from  PurchaseList p group by p.courseName order by p.courseName";

            Query query = session.createQuery(hql);
            List<Object[]> list = query.getResultList();
            for (Object[] i : list) {
                System.out.println(i[0] + " " + i[1]);
            }
            transaction.commit();
            session.close();


        }


    }



