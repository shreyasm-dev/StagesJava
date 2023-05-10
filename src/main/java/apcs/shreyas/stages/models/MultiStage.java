package apcs.shreyas.stages.models;

import java.util.ArrayList;
import java.util.List;

public class MultiStage extends Rocket {
  private List<Stage> stages;

  public MultiStage(double payloadMass) {
    super(payloadMass);
    this.stages = new ArrayList<>();
  }

  public List<Stage> getStages() {
    return this.stages;
  }

  public void setStages(List<Stage> stages) {
    this.stages = stages;
  }

  public void addStage(Stage stage) {
    this.stages.add(stage);
  }

  public Stage removeStage(int index) {
    return this.stages.remove(index);
  }

  public Stage getStage(int index) {
    return this.stages.get(index);
  }

  // Calculated values

  public double getInitialMass() {
    return this.stages.stream().mapToDouble(Stage::getInitialMass).sum() + this.payloadMass;
  }

  public double getFinalMass() {
    if (this.stages.size() > 0) {
      return this.stages.get(this.stages.size() - 1).getFinalMass() + this.payloadMass;
    } else {
      return this.payloadMass;
    }
  }

  // Tsiolkovsky's rocket equation, but taking into account that we lose mass when stages separate
  // For each stage, you can pretend that the rest of the rocket is the payload (because it's basically dead weight when not in use)
  // Then, you can add all the deltaV's together
  public double getDeltaV() {
    ArrayList<Stage> unusedStages = new ArrayList<>(this.stages);
    double deltaV = 0;

    while (unusedStages.size() > 0) {
      Stage stage = unusedStages.remove(0);
      deltaV += new SingleStage(stage, unusedStages.stream().mapToDouble(Stage::getInitialMass).sum() + this.payloadMass).getDeltaV();
    }

    return deltaV;
  }
}
