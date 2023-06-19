package firesat;

import firesat.models.comm.Antenna;
import firesat.models.comm.AntennaMode;
import firesat.models.gnc.GncControlMode;
import gov.nasa.jpl.aerie.contrib.models.Register;
import gov.nasa.jpl.aerie.contrib.models.counters.Counter;
import gov.nasa.jpl.aerie.contrib.serialization.mappers.DoubleValueMapper;
import gov.nasa.jpl.aerie.contrib.serialization.mappers.EnumValueMapper;
import gov.nasa.jpl.aerie.merlin.framework.Registrar;

public final class Mission {
  public final Register<GncControlMode> gncControlMode = Register.forImmutable(GncControlMode.THRUSTERS);

  public final Counter<Double> dataVolume = Counter.ofDouble();

  public final Antenna antenna = new Antenna(AntennaMode.OFF, 0);

  public Mission(final Registrar registrar, final Configuration config) {
    registrar.discrete("/gncControlMode", this.gncControlMode, new EnumValueMapper<>(GncControlMode.class));
    registrar.discrete("/dataVolume", this.dataVolume, new DoubleValueMapper());
    registrar.discrete("/antennaMode", this.antenna.getMode(), new EnumValueMapper<>(AntennaMode.class));
  }
}
