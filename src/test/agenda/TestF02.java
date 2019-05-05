package agenda;

import agenda.model.base.Activity;
import agenda.repository.classes.RepositoryActivityMock;
import agenda.repository.interfaces.RepositoryActivity;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestF02 {
        private Activity act;
        private RepositoryActivity rep;

        @Before
        public void setUp() throws Exception {
            rep = new RepositoryActivityMock();
        }

        @Test
        public void testCase_P05()
        {
            rep.count();
            boolean response=false;
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            try {
                act = new Activity("name1",
                        df.parse("03/20/2013 12:00"),
                        df.parse("03/20/2013 13:00"),
                        null,
                        "Lunch break");
                 response=rep.addActivity(act);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            assert(response==true);
            assertTrue(1 == rep.count());
            assertTrue(rep.getActivities().get(0).getName().equals("name1"));

        }

        @Test
        public void testCase2_P02()
        {
             boolean response1=false;
             boolean response2=false;
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            try{
                for (Activity a : rep.getActivities())
                    rep.removeActivity(a);

                act = new Activity("name1",
                        df.parse("03/20/2013 12:00"),
                        df.parse("03/20/2013 13:00"),
                        null,
                        "Lunch break");
                response1=rep.addActivity(act);

                act = new Activity("name2",
                        df.parse("03/20/2013 12:00"),
                        df.parse("03/20/2013 13:00"),
                        null,
                        "Lunch break");
                response2=rep.addActivity(act);
            }
            catch(Exception e){}
            int c = rep.count();
            assertEquals("name1", rep.getActivities().get(0).getName());
            assertTrue( c == 1);
            assert(response1==true);
            assert(response2==false);
            for (Activity a : rep.getActivities())
                rep.removeActivity(a);
        }
        @Test
        public void testCase_P01()
        {
            boolean response1=false;
            boolean response2=false;
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            try{
                for (Activity a : rep.getActivities())
                    rep.removeActivity(a);

                act = new Activity("name1",
                        df.parse("03/20/2013 12:00"),
                        df.parse("03/20/2013 13:00"),
                        null,
                        "Lunch break");
                response1=rep.addActivity(act);

                act = new Activity("name1",
                        df.parse("03/21/2013 12:00"),
                        df.parse("03/21/2013 13:00"),
                        null,
                        "Lunch break");
                response2=rep.addActivity(act);
            }
            catch(Exception e){}
            int c = rep.count();
            assert(response1);
            assert(response2);
            assertTrue( c == 2);
            for (Activity a : rep.getActivities())
                rep.removeActivity(a);
        }




}
