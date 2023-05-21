package apcs.shreyas.stages;

import apcs.shreyas.stages.models.provider.Providable;
import apcs.shreyas.stages.models.provider.ProviderGroup;
import apcs.shreyas.stages.models.provider.ProviderItem;

public class Providers {
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

  public static final ProviderGroup<Double> STRUCTURAL_MASS = new ProviderGroup<>(
    "Structural mass",
    new Providable[]{
      new ProviderGroup(
        "NASA",
        new Providable[]{
          new ProviderGroup(
            "Saturn V",
            new Providable[]{
              new ProviderItem("Saturn V", 187566.0),
              new ProviderItem("Saturn V Stage 1 (S-IC)", 135218.0),
              new ProviderItem("Saturn V Stage 2 (S-II)", 39048.0),
              new ProviderItem("Saturn V Stage 3 (S-IVB)", 13300.0),
            }
          )
        }
      )
    }
  );
}
