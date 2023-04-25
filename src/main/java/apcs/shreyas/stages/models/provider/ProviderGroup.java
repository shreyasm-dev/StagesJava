package apcs.shreyas.stages.models.provider;

public class ProviderGroup<T> extends Providable<T> {
  private Providable<T>[] items;

  public ProviderGroup(String name, Providable<T>[] items) {
    super(name);
    this.items = items;
  }

  public Providable<T>[] getItems() {
    return items;
  }
}
