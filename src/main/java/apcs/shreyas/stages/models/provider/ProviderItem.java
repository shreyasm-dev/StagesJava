package apcs.shreyas.stages.models.provider;

public class ProviderItem<T> extends Providable<T> {
  private T item;

  public ProviderItem(String name, T item) {
    super(name);
    this.item = item;
  }

  public T getItem() {
    return item;
  }
}
