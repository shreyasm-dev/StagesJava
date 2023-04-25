package apcs.shreyas.stages.models;

public class Engine implements Comparable<Engine> {
  private String name;
  private EngineType type;
  private EngineOperator operator;

  public Engine(String name, EngineType type, EngineOperator operator) {
    this.name = name;
    this.type = type;
    this.operator = operator;
  }

  public String getName() {
    return name;
  }

  public EngineType getType() {
    return type;
  }

  public EngineOperator getOperator() {
    return operator;
  }

  public String toString() {
    return name;
  }

  @Override
  public int compareTo(Engine other) {
    return name.compareTo(other.getName());
  }

  public static enum EngineType {
    LIQUID,
    SOLID,
    ELECTRIC;

    public String toString() {
      switch (this) {
        case LIQUID:
          return "Liquid";
        case SOLID:
          return "Solid";
        case ELECTRIC:
          return "Electric";
        default:
          return "Unknown";
      }
    }
  }

  public static enum EngineOperator {
    NASA,
    SPACEX,
    ROSCOSMOS;

    public String toString() {
      switch (this) {
        case NASA:
          return "NASA";
        case SPACEX:
          return "SpaceX";
        case ROSCOSMOS:
          return "Roscosmos";
        default:
          return "Unknown";
      }
    }
  }
}
