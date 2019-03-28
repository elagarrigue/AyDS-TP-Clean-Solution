package ayds.tp2.tests;

import java.net.URI;

import ayds.tp2.ej1.data.service.CreateUserService;
import ayds.tp2.ej1.data.service.CreateUserServiceImp;
import ayds.tp2.ej1.data.service.ServiceProvider;
import ayds.tp2.ej1.data.urlresolver.UrlUserCreator;
import ayds.tp2.ej1.data.urlresolver.UrlUserCreatorImp;
import ayds.tp2.ej1.data.UserLogic;
import ayds.tp2.ej1.negocio.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ej1Test {

	@Test
	public void test() {
		// Arrange.
		ServiceProvider serviceProvider =  new ServiceProvider() {
			@Override
			public String resolveCall(URI uri) {
				if(uri.toString().equals("http://www.my-service.com/create-user.json?name=Richard%20Dean&last-name=Anderson")) {
					return "{ \"result\" : \"ok\" }";
				} else {
					return "{ \"result\" : \"not ok\" }";
				}
			}
		};

		UrlUserCreator urlUserCreator = new UrlUserCreatorImp();
		CreateUserService createUserService = new CreateUserServiceImp(serviceProvider);
		UserLogic userLogic = new UserLogic(urlUserCreator,createUserService);
		
		User userOk =  new User("Richard Dean", "Anderson");
		User userNotOk =  new User("The", "Dude");
		
		// Act.
		boolean isUserOkOk = userLogic.addUser(userOk);
		boolean isUserNotOkOk = userLogic.addUser(userNotOk);
		
		// Assert.
		assertEquals(isUserOkOk, true);
		assertEquals(isUserNotOkOk, false);
	}
}
