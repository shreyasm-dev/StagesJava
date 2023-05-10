package apcs.shreyas.stages.models.provider;

public abstract class Providable<T> {
  private final String name;

  public Providable(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
