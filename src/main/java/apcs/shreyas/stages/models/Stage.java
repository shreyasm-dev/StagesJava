package apcs.shreyas.stages.models;

public class Stage {
  private double specificImpulse;
  private double propellantMass;
  private double structuralMass;

  public Stage(double specificImpulse, double propellantMass, double structuralMass) {
    this.specificImpulse = specificImpulse;
    this.propellantMass = propellantMass;
    this.structuralMass = structuralMass;
  }

  public double getSpecificImpulse() {
    return this.specificImpulse;
  }

  public double getPropellantMass() {
    return this.propellantMass;
  }

  public double getStructuralMass() {
    return this.structuralMass;
  }

  public void setSpecificImpulse(double specificImpulse) {
    this.specificImpulse = specificImpulse;
  }

  public void setPropellantMass(double propellantMass) {
    this.propellantMass = propellantMass;
  }

  public void setStructuralMass(double structuralMass) {
    this.structuralMass = structuralMass;
  }

  // Calculated values

  public double getExhaustVelocity() {
    return this.specificImpulse * 9.81;
  }

  public double getInitialMass() {
    return this.propellantMass + this.structuralMass;
  }

  public double getFinalMass() {
    return this.structuralMass;
  }
}
