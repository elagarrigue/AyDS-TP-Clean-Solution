package ayds.tp2.ej1.data.urlresolver;

import ayds.tp2.ej1.negocio.User;

import static ayds.tp2.ej1.data.service.ServiceConfig.BASE_URL;
import static ayds.tp2.ej1.data.service.ServiceConfig.CREATE_USER_SERVICE;

public class UrlUserCreatorImp implements UrlUserCreator{

  // GET Request. Format: <base-url>/<service-name>?<params>
  // Example:
  // http://www.my-service.com/create-user.json?name=Richard%20Dean&last-name=Anderson
  public String createUrl(User user) {
    String addUserUrl = BASE_URL + "/" + CREATE_USER_SERVICE + "?" + "name=" + user.getName() + "&last-name="
            + user.getLastName();
    return addUserUrl.replace(" ", "%20");
  }
}
