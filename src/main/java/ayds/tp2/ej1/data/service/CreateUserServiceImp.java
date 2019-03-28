package ayds.tp2.ej1.data.service;

import com.google.gson.Gson;

import java.net.URI;
import java.net.URISyntaxException;

public class CreateUserServiceImp implements CreateUserService{

  private final ServiceProvider serviceProvider;

  public CreateUserServiceImp(ServiceProvider serviceProvider) {
    this.serviceProvider = serviceProvider;
  }

  public CreateUserResult createUserResult(String addUserUrl) {
    String json = callUserService(addUserUrl);
    return createUserResultFromJson(json);
  }

  private String callUserService(String addUserUrl) {
    String json = null;
    try {
      json = serviceProvider.resolveCall(new URI(addUserUrl));
    } catch (URISyntaxException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return json;
  }

  // Result example: { "result" : "ok" }
  private CreateUserResult createUserResultFromJson(String json) {
    CreateUserResult addUserResult = null;
    if (json != null) {
      Gson gson = new Gson();
      addUserResult = gson.fromJson(json, CreateUserResult.class);
    }
    return addUserResult;
  }
}
