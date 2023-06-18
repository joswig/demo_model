package firesat.activities.colorcam;

import firesat.Mission;
import gov.nasa.jpl.aerie.merlin.framework.annotations.ActivityType;
import gov.nasa.jpl.aerie.merlin.framework.annotations.ActivityType.EffectModel;
import gov.nasa.jpl.aerie.merlin.framework.annotations.AutoValueMapper;
import gov.nasa.jpl.aerie.merlin.framework.annotations.Export.Parameter;
import gov.nasa.jpl.aerie.merlin.protocol.types.Duration;

import java.util.ArrayList;
import java.util.List;

import static firesat.generated.ActivityActions.call;
import static gov.nasa.jpl.aerie.merlin.framework.ModelActions.delay;

@ActivityType("ColorCamRaster")
public class ColorCamRaster {

  @Parameter
  public int num_rows = 3;
  @Parameter
  public int num_cols = 5;

  @Parameter
  public Duration settling_time = Duration.MINUTE;

  @AutoValueMapper.Record
  public record ComputedAttributes(
    double dataAccrued,
    int numChildren
  ) {}

  @EffectModel
  public ComputedAttributes run(final Mission mission) {

    for (int row = 0; row < num_rows; row++) {
      for (int col = 0; col < num_cols; col++) {
        final var single = new ColorCamSingleImage(1024, 1024, Duration.MINUTE);
//        children.add(single);
        call(mission, single);
        delay(settling_time);
//        delay(single.exposure_time);
      }
    }
//    final List<ColorCamSingleImage> children = new ArrayList<ColorCamSingleImage>();
//    children.parallelStream().forEach(colorCamSingleImage -> {
//
//    });
    return new ComputedAttributes(123, num_cols * num_rows);
  }

}
