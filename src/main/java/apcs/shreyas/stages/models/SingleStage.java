package apcs.shreyas.stages.models;

public class SingleStage extends Rocket {
  private Stage stage;
  private double payloadMass;

  public SingleStage(Stage stage, double payloadMass) {
    this.stage = stage;
    this.payloadMass = payloadMass;
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

  public double getDeltaV() {
    System.out.println(this.stage.getExhaustVelocity());
    System.out.println(this.getInitialMass());
    System.out.println(this.getFinalMass());
    return this.stage.getExhaustVelocity() * Math.log(this.getInitialMass() / this.getFinalMass());
  }
}