package agenda;



import agenda.controller.ActivityController;
import agenda.controller.ActivityControllerMock;
import agenda.exceptions.InvalidFormatException;
import agenda.model.base.Activity;
import agenda.model.base.Contact;
import agenda.repository.classes.RepositoryActivityFile;
import agenda.repository.classes.RepositoryActivityMock;
import agenda.repository.classes.RepositoryContactFile;
import agenda.repository.classes.RepositoryContactMock;
import agenda.repository.interfaces.RepositoryActivity;
import agenda.repository.interfaces.RepositoryContact;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class bigbang {

    private Activity act;
    private RepositoryActivity rep;
    private RepositoryContact repCon;
    private ActivityControllerMock activityController;


    @Before
    public void setUp() throws Exception {
        rep = new RepositoryActivityMock();
        repCon= new RepositoryContactMock();
        activityController=new ActivityControllerMock(repCon,rep);

    }

    @Test
    public void testContact() {
        try {
            int countController=repCon.count();
            activityController.addContact("Ion", "sdasdas", "+40733665321");
            int countControllerAfterSave=repCon.count();
            assert (countController+1==countControllerAfterSave);
        } catch (InvalidFormatException e) {
            assert false;
        }
    }

    @Test
    public void testAddActivity() {
        rep.count();
        boolean response = false;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        try {
            act = new Activity("name1",
                    df.parse("03/20/2013 12:00"),
                    df.parse("03/20/2013 13:00"),
                    null,
                    "Lunch break");
            response = rep.addActivity(act);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert (response == true);
        assertTrue(1 == rep.count());
        assertTrue(rep.getActivities().get(0).getName().equals("name1"));

    }


    @Test
    public void testAfisareActivity() {
        for (Activity act : rep.getActivities())
            rep.removeActivity(act);

        Calendar c = Calendar.getInstance();
        c.set(2013, 3 , 20, 12, 00);
        Date start = c.getTime();

        c.set(2013, 3, 20, 12, 30);
        Date end = c.getTime();

        Activity act = new Activity("name1", start, end,
                new LinkedList<Contact>(), "description2");

        rep.addActivity(act);

        c.set(2013, 3, 20);

        List<Activity> result = rep.activitiesOnDate("name1", c.getTime());
        assertTrue(result.size() == 1);
    }

    @Test
    public void testBigBang() {
        try {
            int countController=repCon.count();
            activityController.addContact("Ion", "sdsad", "+40733665321");
            int countControllerAfterSave=repCon.count();
            assert (countController+1==countControllerAfterSave);
        } catch (InvalidFormatException e) {
            assert false;
        }
//        try {
//            int countRepo=repCon.count();
//            con = new Contact("Ion", "sdasdasdas", "+40733665321");
//            repCon.addContact(con);
//            int countRepoAfterSave=repCon.count();
//            assert (countRepo+1==countRepoAfterSave);
//            assert (con != null);
//        } catch (InvalidFormatException e) {
//            assert (false);
//        }

        rep.count();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");

        try {
           boolean result= activityController.adaugActivitate("name2",df.parse("03/20/2015 12:00"), df.parse("03/20/2015 13:00"),"dasdasdasdas");
           assert (result);
        } catch (ParseException e) {
           assert false;
        }
//        boolean response = false;
//
//        try {
//            act = new Activity("name1",
//                    df.parse("03/20/2014 12:00"),
//                    df.parse("03/20/2014 13:00"),
//                    null,
//                    "Lunch break");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        response = rep.addActivity(act);
//        assert (response == true);
//        assert (rep.getActivities().get(1).getName().equals("name1"));




        Calendar c = Calendar.getInstance();

        c.set(2015, 02, 20);

//        List<Activity> result = rep.activitiesOnDate("name1", c.getTime());
//        assert (result.size() == 1);

        List<Activity> response=activityController.afisActivitate("name2",c.getTime());
        assert (response.size()==1);
    }
}
