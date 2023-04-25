package apcs.shreyas.stages;

import java.util.HashMap;

// https://stackoverflow.com/questions/43906226/in-java-can-i-declare-a-hashmap-constant
public class Providers {
  public static final HashMap<Engine, Double> SPECIFIC_IMPULSE = new HashMap<>();
  static {
    SPECIFIC_IMPULSE.put(new Engine("RS-25", EngineType.LIQUID, EngineOperator.NASA), 452.3);
    SPECIFIC_IMPULSE.put(new Engine("Raptor", EngineType.LIQUID, EngineOperator.SPACEX), 363.0);
    SPECIFIC_IMPULSE.put(new Engine("RD-180", EngineType.LIQUID, EngineOperator.ROSCOSMOS), 338.0);
    SPECIFIC_IMPULSE.put(new Engine("F-1", EngineType.LIQUID, EngineOperator.NASA), 304.0);
    SPECIFIC_IMPULSE.put(new Engine("Space Shuttle SRB", EngineType.SOLID, EngineOperator.NASA), 242.0);
    SPECIFIC_IMPULSE.put(new Engine("NSTAR", EngineType.ELECTRIC, EngineOperator.NASA), 3120.0);
    SPECIFIC_IMPULSE.put(new Engine("NEXT", EngineType.ELECTRIC, EngineOperator.NASA), 4190.0);
    SPECIFIC_IMPULSE.put(new Engine("Merlin 1D", EngineType.LIQUID, EngineOperator.SPACEX), 311.0);
    SPECIFIC_IMPULSE.put(new Engine("Merlin 1C", EngineType.LIQUID, EngineOperator.SPACEX), 304.8);
  }

  public static class Engine implements Comparable<Engine> {
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
