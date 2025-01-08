package personen;

import lombok.Getter;
import utils.ToStringUtil;

@Getter
public class Person {

  private String name;

  public Person(String name) {
    setName(name);
  }

  public void setName(String name) {
    if (name != null && !name.isBlank()) {
      this.name = name;
    } else {
      throw new IllegalArgumentException("Der Name darf nicht leer sein.");
    }
  }

  @Override
  public String toString() {
    return ToStringUtil.toString(this);
  }

}
