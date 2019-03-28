package ayds.tp2.ej1.data;

import ayds.tp2.ej1.data.service.CreateUserResult;
import ayds.tp2.ej1.data.service.CreateUserService;
import ayds.tp2.ej1.data.urlresolver.UrlUserCreator;
import ayds.tp2.ej1.negocio.User;

public class UserLogic {

  private final CreateUserService createUserService;
  private final UrlUserCreator urlUserCreator;

  public UserLogic(UrlUserCreator urlUserCreator, CreateUserService createUserService) {
    this.urlUserCreator = urlUserCreator;
    this.createUserService = createUserService;
  }

  public boolean addUser(User user) {
    String addUserUrl = urlUserCreator.createUrl(user);

    CreateUserResult addUserResult = createUserService.createUserResult(addUserUrl);

    return addUserResult == null || addUserResult.isResultOk();
  }

}
