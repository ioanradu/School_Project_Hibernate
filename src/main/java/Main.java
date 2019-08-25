import com.sda.entities.Group;
import com.sda.entities.Student;
import com.sda.entities.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*Student student1 = new Student("alex", "matei", 30);
        Student student2 = new Student("emanuel", "halip", 21);
        Student student3 = new Student("melen", "valentin", 40);

        Teacher teacher1 = new Teacher("ioan", "vasilescu", 50, "romana");
        Teacher teacher2 = new Teacher("manta", "vasile", 35, "matematica");
        Teacher teacher3 = new Teacher("maria", "gavril", 45, "sport");

        Group group1 = new Group("a");
        Group group2 = new Group("b");
        Group group3 = new Group("c");


        SessionFactory sessionFactory = returnSession(); // deschidem o sesiune
        if(sessionFactory == null){
            System.out.println("Obiectul nu a fost creat!");
        }
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
       // List<Student> studentList = new ArrayList<>();
        *//*session.persist(student1);
        session.persist(student2);
        session.persist(student3);*//*

        insertStudents(session,student3);

        *//*session.persist(teacher1);
        session.persist(teacher2);
        session.persist(teacher3);*//*
        insertTeachers(session,teacher1);

        *//*session.persist(group1);
        session.persist(group2);
        session.persist(group3);*//*
        insertGroups(session, group1);

        //deleteStudents(session, student1);
        transaction.commit();
        sessionFactory.close(); // inchidem sesiunea
    }

    public static SessionFactory returnSession(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        MetadataSources sources = new MetadataSources(registry);
        Metadata metadata = sources.getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        return sessionFactory;
    }

    public static void insertStudents(Session session, Student student){
        session.persist(student);
    }

    public static void insertTeachers(Session session, Teacher teacher){
        session.persist(teacher);
    }

    public static void insertGroups(Session session, Group group){
        session.persist(group);
    }

   *//*public static void deleteStudents(Session session, Student student){
        student = session.find(Student.class, 10);
        session.delete(student);
        */
    }
}
