package agenda.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import agenda.exceptions.InvalidFormatException;

import agenda.model.base.Contact;
import agenda.repository.classes.RepositoryContactMock;
import agenda.repository.interfaces.RepositoryContact;


public class AddContactTest {

	private Contact con;
	private RepositoryContact rep;
	
	@Before
	public void setUp() throws Exception {
//		rep = new RepositoryContactMock();
	}
	
//	@Test
//	public void testCase1()
//	{
//		try {
//			con = new Contact("name", "address1", "+4071122334455");
//		} catch (InvalidFormatException e) {
//			assertTrue(false);
//		}
//		//int n = rep.count();
//		rep.addContact(con);
//		for(Contact c : rep.getContacts())
//			if (c.equals(con))
//			{
//				assertTrue(true);
//				break;
//			}
//		//assertTrue(n+1 == rep.count());
//	}
//
//	@Test
//	public void testCase2()
//	{
//		try{
//			rep.addContact((Contact) new Object());
//		}
//		catch(Exception e)
//		{
//			assertTrue(true);
//		}
//	}
//
//	@Test
//	public void testCase3()
//	{
//		for(Contact c : rep.getContacts())
//			rep.removeContact(c);
//
//		try {
//			con = new Contact("name", "address1", "+071122334455");
//			rep.addContact(con);
//		} catch (InvalidFormatException e) {
//			assertTrue(false);
//		}
//		int n  = rep.count();
//		if (n == 1)
//			if (con.equals(rep.getContacts().get(0))) assertTrue(true);
//			else assertTrue(false);
//		else assertTrue(false);
//	}

	@Test
	public void testECPValid(){
		try {
			con = new Contact("Ion", "Str. Dunarii", "+40733665321");
			assert(con.getName().equals("Ion"));
		} catch (InvalidFormatException e) {
			fail();
		}
		assertTrue(true);

	}
	@Test
	public void testECPNonValid1(){
		try {
			con = new Contact("Ion", "s", "+40733665321");
			assertTrue(false);
			assert (con!=null);
		} catch (InvalidFormatException e) {
			assertTrue(true);
		}
	}
	@Test
	public void testECPNonValid2(){
		try {
			con = new Contact("", "Str. Dunarii", "+40733665321");
			assertTrue(false);

		} catch (InvalidFormatException e) {
			assertTrue(true);

		}
	}
	@Test
	public void testBVAValid(){
		try {
			con = new Contact("IOn", "Sat", "+40733665321");
			assertTrue(true);
		} catch (InvalidFormatException e) {
			assertTrue(false);
		}

	}
	@Test
	public void testBVAValid2(){
		try {
			con = new Contact("I", "Str. Dunarii", "+40733665321");
			assertTrue(true);

		} catch (InvalidFormatException e) {
			fail();
		}

	}
	@Test
	public void testBVANonValid1(){
		try {
			con = new Contact("Ion", "Sa", "+40733665321");
			assertTrue(false);

		} catch (InvalidFormatException e) {
			assertTrue(true);

		}

	}
	@Test
	public void testBVANonValid2(){
		try {
			con = new Contact("Ion", "Str. DunariiggfcgfgfcxadvjhsadvasjhvdjhasBDJSAHBDVHJSAVDHSVDGHADVJHFDAsjyfcdxatyqdfvxsgjhdfqj	ysaVXAYSdcvxjfdyajxvgjzhxvGJAHDFXYajgHXChgfZCXghZCXygjADTYASJDFASygdkjhfjdJFZjDfdjfhasDJFhakdjhJHDV	gfchcvhbvhvcghcgfxhccccgvghggggvgvgvvggvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvdfffffffffffffffffffffffffffffffffffffffffffffhhhgfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff", "+40733665321");
			assertTrue(false);
		} catch (InvalidFormatException e) {
			assertTrue(true);

		}

	}
	
}
