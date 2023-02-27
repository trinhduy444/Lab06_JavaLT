package Utils.dao;


import java.util.List;


import Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.lab06.Student;


public class StudentDAO {
    public StudentDAO() {}
    public void addStudent(Student student)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(student);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateStudent(Student newStudent)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getFactory().openSession()) {
            transaction = session.beginTransaction();
            // Save student
            session.update(newStudent);
            // Commit
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void removeStudent(int id)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getFactory().openSession()) {
            transaction = session.beginTransaction();

            // Delete a user
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
                System.out.println("user is deleted");
            }

            // commit
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Student getStudent(int studentID)
    {
        Student student = new Student();
        Transaction transaction = null;
        try(Session session = HibernateUtils.getFactory().openSession();)
        {
            transaction = session.beginTransaction();
            student = (Student) session.byId(Student.class).getReference(studentID);
            transaction.commit();
        }catch(Exception e)
        {
            if(transaction !=null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return student;

    }

    public List<Student> getAllStudent() {

        Transaction transaction = null;
        List listOfStudent = null;
        try (Session session = HibernateUtils.getFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfStudent = session.createQuery("from Student").getResultList();
            //commit
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfStudent;
    }

}

