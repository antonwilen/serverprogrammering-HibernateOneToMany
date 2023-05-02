package se.yrgo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import se.yrgo.domain.Student;
import se.yrgo.domain.Tutor;

import java.util.List;


public class HibernateTest {
    private static SessionFactory sessionFactory = null;
    public static void main(String[] args) {
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        Student student1 = new Student("Nisse Jansson");
        Student student2 = new Student("Åke Johansson");
        Student student3 = new Student("Linda Hansson");

        Tutor tutor = new Tutor("TEACHER1","Per-Daniel Svensson", 32100);
        tutor.addStudentToTeachingGroup(student1);
        tutor.addStudentToTeachingGroup(student2);
        tutor.addStudentToTeachingGroup(student3);

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(tutor);

        List<Student> studentList = tutor.getTeachingGroup();
        for (Student student:studentList) {
            System.out.println(student);
        }

        transaction.commit();
        session.close();




    }

    private static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
