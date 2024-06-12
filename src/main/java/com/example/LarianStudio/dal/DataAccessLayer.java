package com.example.LarianStudio.dal;

import com.example.LarianStudio.models.*;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;


@Getter
public class DataAccessLayer {
    private final SessionFactory sessionFactory;

    @Autowired
    public DataAccessLayer(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    Session session = null;
    ///////////////////////////////////Game//////////////////////////////////////////////////
    public void createGameToDatabase(Game newGame) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newGame);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }

    }

    public void deleteGame(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Game game = session.get(Game.class, id);
        session.remove(game);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public Game readGame(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Game game = session.get(Game.class, id);
        session.getTransaction().commit();
        return game;
    }

    public void updateGame(Long id, Game newGame){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Game game = session.get(Game.class, id);
        game.setName(newGame.getName());
        game.setCost(newGame.getCost());
        session.merge(game);
        session.getTransaction().commit();

    }
    ///////////////////////////////////Coloboration//////////////////////////////////////////////////
    public void createColoborationToDatabase(Coloboration newColoboration) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newColoboration);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }

    }

    public void deleteColoboration(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Coloboration coloboration = session.get(Coloboration.class, id);
        session.remove(coloboration);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public Coloboration readColoboration(Long id) {
        session  = sessionFactory.openSession();
        session.beginTransaction();
        Coloboration coloboration = session.get(Coloboration.class, id);
        System.out.println("Coloboration ID: " + coloboration.getColoboration_id());
        session.getTransaction().commit();
        return coloboration;

    }

    public void updateColoboration(Long id, Coloboration newColoboration){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Coloboration coloboration = session.get(Coloboration.class, id);
        coloboration.setName(newColoboration.getName());
        session.merge(coloboration);
        session.getTransaction().commit();

    }
    ///////////////////////////////////DLC//////////////////////////////////////////////////
    public void createDlcToDatabase(Dlc newDlc) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newDlc);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }

    }

    public void deleteDlc(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Dlc dlc = session.get(Dlc.class, id);
        session.remove(dlc);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public Dlc readDlc(Long id) {
        session  = sessionFactory.openSession();
        session.beginTransaction();
        Dlc dlc = session.get(Dlc.class, id);
        System.out.println("Dlc ID: " + dlc.getDlc_id());
        session.getTransaction().commit();
        return dlc;

    }

    public void updateDlc(Long id, Dlc newDlc){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Dlc dlc = session.get(Dlc.class, id);
        dlc.setName(newDlc.getName());
        dlc.setCost(newDlc.getCost());
        session.merge(dlc);
        session.getTransaction().commit();

    }
    ///////////////////////////////////Employee//////////////////////////////////////////////////
    public void createEmployeeToDatabase(Employee newEmployee) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newEmployee);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }

    }
    public void deleteEmployee(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        session.remove(employee);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public Employee readEmployee(Long id) {
        session  = sessionFactory.openSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        System.out.println("Employee ID: " + employee.getEmployee_id());
        session.getTransaction().commit();
        return employee;

    }

    public void updateEmployee(Long id, Employee newEmployee){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        employee.setName(newEmployee.getName());
        employee.setLogin(newEmployee.getLogin());
        employee.setPassword(newEmployee.getPassword());
        session.merge(employee);
        session.getTransaction().commit();

    }
///////////////////////////////////Larian_Studio//////////////////////////////////////////////////
    public void readLarian(Long String) {
        session  = sessionFactory.openSession();
        session.beginTransaction();
        Larian_Studio larian = session.get(Larian_Studio.class, String);
        System.out.println("Larian: " + larian.getLarian_studio_id());
        session.getTransaction().commit();

    }
    public void updateLarian(Long id, Larian_Studio newLarianStudio) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Larian_Studio larian = session.get(Larian_Studio.class, id);
        larian.setEmail(newLarianStudio.getEmail());
        larian.setAdress(newLarianStudio.getAdress());
        larian.setNumber(newLarianStudio.getNumber());
        larian.setWorkers(newLarianStudio.getWorkers());
        session.merge(larian);
        session.getTransaction().commit();

    }

///////////////////////////////////Launcher//////////////////////////////////////////////////
    public void readLauncher(Long String) {
        session  = sessionFactory.openSession();
        session.beginTransaction();
        Launcher launcher = session.get(Launcher.class, String);
        System.out.println("Larian: " + launcher.getLauncher_id());
        session.getTransaction().commit();

    }
    public void updateLauncher(Long id, Launcher newLauncher) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Launcher launcher = session.get(Launcher.class, id);
        launcher.setLauncher_id(newLauncher.getLauncher_id());
        launcher.setUser(newLauncher.getUser());
        session.merge(launcher);
        session.getTransaction().commit();

    }
///////////////////////////////////Story_pay//////////////////////////////////////////////////
    public void createStoryPay(Story_pay newStoryPay) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newStoryPay);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }

    }
    public void deleteStoryPayById(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Story_pay story_pay = session.get(Story_pay.class, id);
        session.remove(story_pay);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public void readStoryPayById(Long id) {
        session  = sessionFactory.openSession();
        session.beginTransaction();
        Story_pay story_pay = session.get(Story_pay.class, id);
        System.out.println("Story pay ID: " + story_pay.getStory_pay_id());
        session.getTransaction().commit();

    }

    public void updateStoryPayById(Long id, Story_pay newStoryPay){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Story_pay story_pay = session.get(Story_pay.class, id);
        story_pay.setDate(newStoryPay.getDate());
        story_pay.setCard(newStoryPay.getCard());
        session.merge(story_pay);
        session.getTransaction().commit();

    }
///////////////////////////////////User//////////////////////////////////////////////////
    public void createUserToDatabase(User newUser) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newUser);
        session.getTransaction().commit();
        if (session != null) {
        session.close();
        }

    }
    public void deleteUser(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.remove(user);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public User readUser(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        System.out.println("User ID: " + user.getUser_id());
        session.getTransaction().commit();
        return user;

    }

    public void updateUser(Long id, User newUser){
        session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        user.setName(newUser.getName());
        user.setLogin(newUser.getLogin());
        user.setPassword(newUser.getPassword());
        user.setAge(newUser.getAge());
        session.merge(user);
        session.getTransaction().commit();

    }

    public String newUserToDatabase(User user) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        String name = user.getName();

        Query query = session
                .createQuery("FROM User where name = :username")
                .setParameter("username", name);
        User userFrom = (User) query.uniqueResult();

        if (userFrom != null) {
            return "Выберите другое имя";
        }
        session.persist(user);
        session.getTransaction().commit();
        session.close();
        return "Pabeda)";
    }

    public User getUserFromDatabaseByUsername(String name) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session
                .createQuery("FROM User where name = :name")
                .setParameter("name", name);
        User userFrom = (User) query.uniqueResult();
        if (userFrom == null) {
            return null;
        }
        return userFrom;
    }
}
