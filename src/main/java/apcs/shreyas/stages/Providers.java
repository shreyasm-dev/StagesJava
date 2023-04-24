package apcs.shreyas.stages;

import java.util.HashMap;

// https://stackoverflow.com/questions/43906226/in-java-can-i-declare-a-hashmap-constant
public class Providers {
  public static final HashMap<String, Double> SPECIFIC_IMPULSE = new HashMap<>();
  static {
    SPECIFIC_IMPULSE.put("RS-25", 452.3);
    SPECIFIC_IMPULSE.put("Raptor", 363.0);
    SPECIFIC_IMPULSE.put("RD-180", 338.0);
    SPECIFIC_IMPULSE.put("F-1", 304.0);
    SPECIFIC_IMPULSE.put("Space Shuttle SRB", 242.0);
    SPECIFIC_IMPULSE.put("NSTAR", 3120.0);
    SPECIFIC_IMPULSE.put("NEXT", 4190.0);
    SPECIFIC_IMPULSE.put("Merlin 1D", 311.0);
    SPECIFIC_IMPULSE.put("Merlin 1C", 304.8);
  }
}
