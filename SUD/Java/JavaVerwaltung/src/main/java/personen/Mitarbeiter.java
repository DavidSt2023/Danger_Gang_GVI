package personen;

import lombok.Getter;

@Getter
public abstract class Mitarbeiter extends Person {

  private int id;

  public Mitarbeiter(int id, String name) {
    super(name);
    setId(id);
  }

  public Mitarbeiter(Mitarbeiter m) {
    super(m.getName());
    setId(m.getId());
  }

  public Mitarbeiter(Person p, int id) {
    super(p.getName());
    setId(id);
  }

  protected void setId(int id) {
    if (id >= 1000) {
      this.id = id;
    } else {
      throw new IllegalArgumentException("Die Id muss mindestens 4-stellig sein.");
    }
  }

}
