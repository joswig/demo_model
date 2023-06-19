package firesat.activities.antenna;

import firesat.Mission;
import gov.nasa.jpl.aerie.merlin.framework.annotations.ActivityType;
import gov.nasa.jpl.aerie.merlin.protocol.types.Duration;

import static gov.nasa.jpl.aerie.merlin.framework.ModelActions.delay;

@ActivityType("AntennaPass")
public class AntennaPass {

  @ActivityType.EffectModel
  public void run(final Mission mission) {
    mission.antenna.prep();
    delay(Duration.MINUTE.times(5));
    mission.antenna.transmit();
    delay(Duration.MINUTE.times(25));
    mission.antenna.cleanup();
    delay(Duration.MINUTE.times(5));
    mission.antenna.powerOff();
  }
}
