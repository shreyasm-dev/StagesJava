package apcs.shreyas.stages;

import apcs.shreyas.stages.models.provider.Providable;
import apcs.shreyas.stages.models.provider.ProviderGroup;
import apcs.shreyas.stages.models.provider.ProviderItem;

// https://stackoverflow.com/questions/43906226/in-java-can-i-declare-a-hashmap-constant
public class Providers {
  /*

  SPECIFIC_IMPULSE.put(new Engine("RS-25", Engine.EngineType.LIQUID, Engine.EngineOperator.NASA), 452.3);
    SPECIFIC_IMPULSE.put(new Engine("Raptor", Engine.EngineType.LIQUID, Engine.EngineOperator.SPACEX), 363.0);
    SPECIFIC_IMPULSE.put(new Engine("RD-180", Engine.EngineType.LIQUID, Engine.EngineOperator.ROSCOSMOS), 338.0);
    SPECIFIC_IMPULSE.put(new Engine("F-1", Engine.EngineType.LIQUID, Engine.EngineOperator.NASA), 304.0);
    SPECIFIC_IMPULSE.put(new Engine("Space Shuttle SRB", Engine.EngineType.SOLID, Engine.EngineOperator.NASA), 242.0);
    SPECIFIC_IMPULSE.put(new Engine("NSTAR", Engine.EngineType.ELECTRIC, Engine.EngineOperator.NASA), 3120.0);
    SPECIFIC_IMPULSE.put(new Engine("NEXT", Engine.EngineType.ELECTRIC, Engine.EngineOperator.NASA), 4190.0);
    SPECIFIC_IMPULSE.put(new Engine("Merlin 1D", Engine.EngineType.LIQUID, Engine.EngineOperator.SPACEX), 311.0);
    SPECIFIC_IMPULSE.put(new Engine("Merlin 1C", Engine.EngineType.LIQUID, Engine.EngineOperator.SPACEX), 304.8);


   */
  public static final ProviderGroup<Double> SPECIFIC_IMPULSE = new ProviderGroup<>(
    "Specific impulse",
    new Providable[]{
      new ProviderGroup(
        "Liquid",
        new Providable[]{
          new ProviderGroup(
            "NASA",
            new Providable[]{
              new ProviderItem("RS-25", 452.3),
              new ProviderItem("F-1", 304.0)
            }
          ),
          new ProviderGroup(
            "SpaceX",
            new Providable[]{
              new ProviderItem("Raptor", 363.0),
              new ProviderItem("Merlin 1D", 311.0),
              new ProviderItem("Merlin 1C", 304.8)
            }
          ),
          new ProviderGroup(
            "Roscosmos",
            new Providable[]{
              new ProviderItem("RD-180", 338.0)
            }
          )
        }
      ),
      new ProviderGroup(
        "Solid",
        new Providable[]{
          new ProviderGroup(
            "NASA",
            new Providable[]{
              new ProviderItem("Space Shuttle SRB", 242.0)
            }
          )
        }
      ),
      new ProviderGroup(
        "Electric",
        new Providable[]{
          new ProviderGroup(
            "NASA",
            new Providable[]{
              new ProviderItem("NSTAR", 3120.0),
              new ProviderItem("NEXT", 4190.0)
            }
          )
        }
      )
    }
  );
}
