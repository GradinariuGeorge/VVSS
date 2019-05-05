package agenda.controller;

import agenda.exceptions.InvalidFormatException;
import agenda.model.base.Activity;
import agenda.model.base.Contact;
import agenda.repository.classes.RepositoryActivityFile;
import agenda.repository.classes.RepositoryActivityMock;
import agenda.repository.classes.RepositoryContactFile;
import agenda.repository.classes.RepositoryContactMock;
import agenda.repository.interfaces.RepositoryActivity;
import agenda.repository.interfaces.RepositoryContact;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ActivityControllerMock {
    private RepositoryContact contactRep;
    private RepositoryActivity activityRep ;

    public ActivityControllerMock(RepositoryContact repositoryContactMock, RepositoryActivity repositoryActivityMock){
        try {
            this.contactRep=repositoryContactMock;
            this.activityRep=repositoryActivityMock;
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
    public List<Activity> afisActivitate(String name , Date d){
        List<Activity> act = activityRep
                .activitiesOnDate(name, d);
        return act;

    }
}
