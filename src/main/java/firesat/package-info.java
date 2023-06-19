@MissionModel(model = Mission.class)
@WithMappers(BasicValueMappers.class)
@WithConfiguration(Configuration.class)
@WithActivityType(GncChangeControlMode.class)
@WithActivityType(AntennaPass.class)
@WithActivityType(ColorCamRaster.class)
@WithActivityType(ColorCamSingleImage.class)
package firesat;

import firesat.activities.antenna.AntennaPass;
import firesat.activities.colorcam.ColorCamRaster;
import firesat.activities.colorcam.ColorCamSingleImage;
import firesat.activities.gnc.GncChangeControlMode;
import gov.nasa.jpl.aerie.contrib.serialization.rulesets.BasicValueMappers;
import gov.nasa.jpl.aerie.merlin.framework.annotations.MissionModel;
import gov.nasa.jpl.aerie.merlin.framework.annotations.MissionModel.WithActivityType;
import gov.nasa.jpl.aerie.merlin.framework.annotations.MissionModel.WithConfiguration;
import gov.nasa.jpl.aerie.merlin.framework.annotations.MissionModel.WithMappers;
