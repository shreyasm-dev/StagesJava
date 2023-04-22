package apcs.shreyas.stages.models;

abstract public class Rocket {
  private double payloadMass;

  public double getPayloadMass() {
    return this.payloadMass;
  }

  public void setPayloadMass(double payloadMass) {
    this.payloadMass = payloadMass;
  }

  // Calculated values

  abstract public double getInitialMass();

  abstract public double getFinalMass();

  abstract public double getDeltaV();
}
