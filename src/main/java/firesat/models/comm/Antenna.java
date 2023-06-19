package firesat.models.comm;

import gov.nasa.jpl.aerie.contrib.models.Accumulator;
import gov.nasa.jpl.aerie.contrib.models.Register;

public final class Antenna {
  private final Register<AntennaMode> mode;
  private final Register<Double> bitRate;
  private final Accumulator transmittedBits;

  public Antenna(AntennaMode mode, double bitRate) {
    this.mode = Register.forImmutable(mode);
    this.bitRate = Register.forImmutable(bitRate);
    this.transmittedBits = new Accumulator();
  }

  public Register<AntennaMode> getMode() {
    return mode;
  }

  public void prep() {
    this.mode.set(AntennaMode.PREP);
  }

  public void transmit() {
    this.mode.set(AntennaMode.ACTIVE);
  }

  public void cleanup() {
    this.mode.set(AntennaMode.CLEANUP);
  }

  public void powerOff() {
    this.mode.set(AntennaMode.OFF);
    this.bitRate.set(0.0);
  }
}
