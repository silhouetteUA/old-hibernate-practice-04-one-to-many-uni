package com.mycompany.demo;


import com.mycompany.entities.Course;
import com.mycompany.entities.Instructor;
import com.mycompany.entities.InstructorDetail;
import com.mycompany.entities.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewsDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                                            .configure("hibernate.cfg.xml")
                                            .addAnnotatedClass(Instructor.class)
                                            .addAnnotatedClass(InstructorDetail.class)
                                            .addAnnotatedClass(Course.class)
                                            .addAnnotatedClass(Review.class)
                                            .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();
            int myCourseID = 10;
            Course tempCourse = session.get(Course.class, myCourseID);
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());

            session.getTransaction().commit();
            System.out.println("Done");
        } catch (Exception ex)  {
            ex.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
