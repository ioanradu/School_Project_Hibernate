import com.sda.entities.Locker;
import com.sda.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        SessionFactory sessionFactory = returnSession(); // deschidem o sesiune
        if (sessionFactory == null) {
            System.out.println("Object has not been created!");

        }

        List<Student> studentList = new ArrayList<>();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //insertStudentsfromInput(session, studentList);
       /* Locker locker1 = new Locker(100);
        Locker locker2 = new Locker(101);
        Locker locker3 = new Locker(102);
        Locker locker4 = new Locker(103);
        Locker locker5 = new Locker(104);*/

       Query query = session.getNamedQuery("get_student_by_name");
       List<Student> students = query.setParameter("firstName", "vali").getResultList();
       for(Student student: students){
           System.out.println(student);
       }
        System.out.println(query.toString());
        /*insertLocker(session,locker1);
        insertLocker(session,locker2);
        insertLocker(session,locker3);
        insertLocker(session,locker4);
        insertLocker(session,locker5);*/

        //deleteStudent(session);
        //updateStudent(session);

        transaction.commit();
        sessionFactory.close(); // inchidem sesiunea
    }

    public static SessionFactory returnSession() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        MetadataSources sources = new MetadataSources(registry);
        Metadata metadata = sources.getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        return sessionFactory;
    }

    public static void insertStudentsfromInput(Session session, List<Student> studentList) {
        System.out.println("How many students do you want to insert?");
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = scanner.nextInt();
        int i = 0;

        while (i < numberOfStudents) {
            System.out.print("Please enter first name: ");
            String firstName = scanner.next();
            //scanner.nextLine();
            System.out.print("Please enter last name: ");
            String lastName = scanner.next();

            System.out.print("Please enter the age: ");
            int age = scanner.nextInt();

            /*System.out.print("Please enter the locker:");
            int locker  = scanner.nextInt();*/

            studentList.add(new Student(firstName, lastName, age));
            System.out.println("The student has been added to the list");
            i++;
        }

        for (Student student : studentList) {
            session.persist(student);
        }
    }

    public static void deleteStudent(Session session) {
        Student student = session.find(Student.class, 22);
        if (student != null) {
            session.delete(student);
        }
    }

    public static void updateStudent(Session session) {
        Student student = session.find(Student.class, 9);
        if (student != null) {
            student.setFirstName("Bogdan");
        }
    }

    public static void insertLocker(Session session, Locker locker){
        session.persist(locker);
    }
}
