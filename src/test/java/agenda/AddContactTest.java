package agenda;

import agenda.exceptions.InvalidFormatException;
import agenda.model.base.Contact;
import agenda.repository.interfaces.RepositoryContact;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class AddContactTest {

	private Contact con;
	private RepositoryContact rep;

	@Before
	public void setUp() throws Exception {
	}
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
	@Test(expected = InvalidFormatException.class)
	public void testECPNonValid1(){
		try {
			con = new Contact("Ion", "s", "+40733665321");
			assert false;
			assert (con!=null);
		} catch (InvalidFormatException e) {
			assert true;
		}
	}
	@Test
	public void testECPNonValid2(){
		try {
			con = new Contact("", "Str. Dunarii", "+40733665321");
			assert false;

		} catch (InvalidFormatException e) {
			assert true;

		}
	}
	@Test
	public void testBVAValid(){
		try {
			con = new Contact("IOn", "Sat", "+40733665321");
			assert true;
		} catch (InvalidFormatException e) {
			assert false;
		}

	}
	@Test
	public void testBVAValid2(){
		try {
			con = new Contact("I", "Str. Dunarii", "+40733665321");
			assert  true;

		} catch (InvalidFormatException e) {
			assert false;
		}

	}
	@Test(expected = InvalidFormatException.class)
	public void testBVANonValid1(){
		try {
			con = new Contact("Ion", "Sa", "+40733665321");
			assert false;

		} catch (InvalidFormatException e) {
			assert true;

		}

	}
	@Test
	public void testBVANonValid2(){
		try {
			con = new Contact("Ion", "Str. DunariiggfcgfgfcxadvjhsadvasjhvdjhasBDJSAHBDVHJSAVDHSVDGHADVJHFDAsjyfcdxatyqdfvxsgjhdfqj	ysaVXAYSdcvxjfdyajxvgjzhxvGJAHDFXYajgHXChgfZCXghZCXygjADTYASJDFASygdkjhfjdJFZjDfdjfhasDJFhakdjhJHDV	gfchcvhbvhvcghcgfxhccccgvghggggvgvgvvggvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvgvdfffffffffffffffffffffffffffffffffffffffffffffhhhgfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff", "+40733665321");
			assert false;
		} catch (InvalidFormatException e) {
			assert  true;

		}

	}

}
