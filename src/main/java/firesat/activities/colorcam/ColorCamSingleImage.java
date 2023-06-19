package firesat.activities.colorcam;

import firesat.Mission;
import gov.nasa.jpl.aerie.merlin.framework.annotations.ActivityType;
import gov.nasa.jpl.aerie.merlin.framework.annotations.ActivityType.EffectModel;
import gov.nasa.jpl.aerie.merlin.framework.annotations.AutoValueMapper;
import gov.nasa.jpl.aerie.merlin.framework.annotations.Export.Parameter;
import gov.nasa.jpl.aerie.merlin.protocol.types.Duration;

import static gov.nasa.jpl.aerie.merlin.framework.ModelActions.delay;

@ActivityType("ColorCamSingleImage")
public class ColorCamSingleImage {


  @Parameter
  public int num_rows = 1024;
  @Parameter
  public int num_cols = 1024;

  @Parameter
  public Duration exposure_time = Duration.MINUTE;

  public ColorCamSingleImage(int num_rows, int num_cols, Duration exposure_time) {
    this.num_rows = num_rows;
    this.num_cols = num_cols;
    this.exposure_time = exposure_time;
  }

  public ColorCamSingleImage() {

  }

  @EffectModel
  public ComputedAttributes run(final Mission mission) {
    delay(exposure_time);
    mission.dataVolume.add(1234d);
    return new ComputedAttributes(
      num_rows * num_cols
    );
  }

  @AutoValueMapper.Record
  public record ComputedAttributes(
    double dataAccrued
  ) {
  }

}
