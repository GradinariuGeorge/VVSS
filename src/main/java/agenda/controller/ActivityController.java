package agenda.controller;

import agenda.exceptions.InvalidFormatException;
import agenda.model.base.Activity;
import agenda.model.base.Contact;
import agenda.repository.classes.RepositoryActivityFile;
import agenda.repository.classes.RepositoryContactFile;
import agenda.repository.classes.RepositoryUserFile;
import agenda.repository.interfaces.RepositoryActivity;
import agenda.repository.interfaces.RepositoryContact;
import agenda.repository.interfaces.RepositoryUser;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ActivityController {
    private RepositoryContact contactRep;
    private RepositoryActivity activityRep ;

    public ActivityController(){
        try {
            this.contactRep=new RepositoryContactFile();
            this.activityRep=new RepositoryActivityFile(contactRep);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addContact(String name , String adress, String telefon) throws InvalidFormatException {

        Contact c =  new Contact(name, adress, telefon);

        contactRep.addContact(c);
    }

    public boolean adaugActivitate(String name, Date start, Date end,
                                   String description){
        Activity act = new Activity(name, start, end,
                new LinkedList<Contact>(), description);

        return activityRep.addActivity(act);

    }
    public void afisActivitate(String name , Date d){
        List<Activity> act = activityRep
                .activitiesOnDate(name, d);
        for (Activity a : act) {
            System.out.printf("%s - %s: %s - %s with: ", a.getStart()
                    .toString(), a.getDuration().toString(), a
                    .getDescription());
            for (Contact con : a.getContacts())
                System.out.printf("%s, ", con.getName());
            System.out.println();
        }

    }
}
