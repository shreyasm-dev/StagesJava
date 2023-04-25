package apcs.shreyas.stages.models;

public class SingleStage extends Rocket {
  private Stage stage;

  public SingleStage(Stage stage, double payloadMass) {
    super(payloadMass);
    this.stage = stage;
  }

  public Stage getStage() {
    return this.stage;
  }

  public void setStage(Stage stage) {
    this.stage = stage;
  }

  // Calculated values

  public double getInitialMass() {
    return this.stage.getInitialMass() + this.payloadMass;
  }

  public double getFinalMass() {
    return this.stage.getFinalMass() + this.payloadMass;
  }

  // Tsiolkovsky's rocket equation
  public double getDeltaV() {
    return this.stage.getExhaustVelocity() * Math.log(this.getInitialMass() / this.getFinalMass());
  }
}
