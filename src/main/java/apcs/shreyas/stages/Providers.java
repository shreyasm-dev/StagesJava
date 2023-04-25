package apcs.shreyas.stages;

import apcs.shreyas.stages.models.Engine;

import java.util.HashMap;

// https://stackoverflow.com/questions/43906226/in-java-can-i-declare-a-hashmap-constant
public class Providers {
  public static final HashMap<Engine, Double> SPECIFIC_IMPULSE = new HashMap<>();
  static {
    SPECIFIC_IMPULSE.put(new Engine("RS-25", Engine.EngineType.LIQUID, Engine.EngineOperator.NASA), 452.3);
    SPECIFIC_IMPULSE.put(new Engine("Raptor", Engine.EngineType.LIQUID, Engine.EngineOperator.SPACEX), 363.0);
    SPECIFIC_IMPULSE.put(new Engine("RD-180", Engine.EngineType.LIQUID, Engine.EngineOperator.ROSCOSMOS), 338.0);
    SPECIFIC_IMPULSE.put(new Engine("F-1", Engine.EngineType.LIQUID, Engine.EngineOperator.NASA), 304.0);
    SPECIFIC_IMPULSE.put(new Engine("Space Shuttle SRB", Engine.EngineType.SOLID, Engine.EngineOperator.NASA), 242.0);
    SPECIFIC_IMPULSE.put(new Engine("NSTAR", Engine.EngineType.ELECTRIC, Engine.EngineOperator.NASA), 3120.0);
    SPECIFIC_IMPULSE.put(new Engine("NEXT", Engine.EngineType.ELECTRIC, Engine.EngineOperator.NASA), 4190.0);
    SPECIFIC_IMPULSE.put(new Engine("Merlin 1D", Engine.EngineType.LIQUID, Engine.EngineOperator.SPACEX), 311.0);
    SPECIFIC_IMPULSE.put(new Engine("Merlin 1C", Engine.EngineType.LIQUID, Engine.EngineOperator.SPACEX), 304.8);
  }
}
