package de.figuren.figuren3D;

import de.figuren.figuren.INamed;

public abstract class Figur3D<T> implements INamed {

  public abstract double volumen();

  public abstract double oberflaeche();

  protected Figur3D() {
  }

}