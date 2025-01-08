package personen;

import lombok.Getter;

@Getter
public class Manager extends Bueroarbeiter {

  private double bonus;

  public Manager(int id, String name, double festgehalt, double bonus) {
    super(id, name, festgehalt);
    setBonus(bonus);
  }

  public Manager(Bueroarbeiter b, double bonus) {
    super(b);
    setBonus(bonus);
  }

  public void setBonus(double prozentsatz) {
    if (prozentsatz < 0) {
      throw new IllegalArgumentException("Der Prozentsatz darf nicht negativ sein.");
    }
    this.bonus = this.getFestgehalt() * prozentsatz;
  }

}
