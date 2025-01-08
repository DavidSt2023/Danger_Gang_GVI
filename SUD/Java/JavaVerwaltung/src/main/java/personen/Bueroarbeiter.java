package personen;

import lombok.Getter;

@Getter
public class Bueroarbeiter extends Mitarbeiter {

  private double festgehalt;

  public Bueroarbeiter(int id, String name, double festgehalt) {
    super(id, name);
    setFestgehalt(festgehalt);
  }

  public Bueroarbeiter(Mitarbeiter m, double festgehalt) {
    super(m);
    setFestgehalt(festgehalt);
  }

  public Bueroarbeiter(Bueroarbeiter b) {
    super(b);
    setFestgehalt(b.getFestgehalt());
  }

  @Override
  protected void setId(int id) {
    if (id < 5000 || id > 5999) {
      throw new IllegalArgumentException("Die Id muss positiv 4 stellig sein und mit der Ziffer 5 beginnen.");
    }
    super.setId(id);
  }

  public void setFestgehalt(double festgehalt) {
    if (festgehalt < 0) {
      throw new IllegalArgumentException("Das Festgehalt darf nicht negativ sein.");
    }
    this.festgehalt = festgehalt;
  }

}
