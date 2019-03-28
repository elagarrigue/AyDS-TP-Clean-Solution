package ayds.tp2.ej1.data.service;

public class CreateUserResult {

  private String result;

  public CreateUserResult(String result) {
    this.result = result;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public boolean isResultOk() {
      return getResult().equals("ok");
  }

}
