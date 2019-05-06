package agenda.repository.interfaces;

import java.util.List;

import agenda.exceptions.InvalidFormatException;
import agenda.model.base.Contact;
import org.omg.CORBA.DynAnyPackage.Invalid;

public interface RepositoryContact {

	List<Contact> getContacts();
	void addContact(Contact contact) throws InvalidFormatException;
	boolean removeContact(Contact contact);
	boolean saveContracts();
	int count();
	Contact getByName(String string);
}
