package utils;

import models.booster.BE3;
import models.booster.Booster;
import models.booster.EAP;
import models.booster.SRB;
import models.capsule.Apollo;
import models.capsule.Capsule;
import models.capsule.CargoDragon;
import models.capsule.CrewDragon;
import models.capsule.Orion;
import models.launcher.ArianeV;
import models.launcher.Falcon9;
import models.launcher.Launcher;
import models.launcher.SLS;
import models.launcher.SaturneV;
import models.mission.ISS;
import models.mission.Mars;
import models.mission.Mission;
import models.mission.Moon;
import models.mission.Orbit;
import models.mission.SecretMission;

public class Catalog {
    Falcon9 falcon = new Falcon9();
    ArianeV ariane = new ArianeV();
    SaturneV saturne = new SaturneV();
    SLS sls = new SLS();
    CargoDragon cargoDragon = new CargoDragon();
    CrewDragon crewDragon = new CrewDragon();
    Apollo apollo = new Apollo();
    Orion orion = new Orion();
    BE3 be3 = new BE3();
    EAP eap = new EAP();
    SRB srb = new SRB();
    Orbit orbit = new Orbit();
    ISS iss = new ISS();
    Moon moon = new Moon();
    Mars mars = new Mars();
    SecretMission secretMission = new SecretMission();


    //returns a Falcon9
    public Launcher getFalcon9(){
        return falcon;
    }

    //returns an Ariane V
    public Launcher getArianeV(){
        return ariane;
    }

    //returns a Saturne V
    public Launcher getSaturneV(){
        return saturne;
    }

    //returns an SLS
    public Launcher getSLS(){
        return sls;
    }

    //returns a Cargo Dragon
    public Capsule getCargoDragon(){
        return cargoDragon;
    }

    //returns a Crew Dragon
    public Capsule getCrewDragon(){
        return crewDragon;
    }

    //returns an Apollo
    public Capsule getApollo(){
        return apollo;
    }

    //returns an Orion
    public Capsule getOrion(){
        return orion;
    }

    //returns a BE-3
    public Booster getBE3(){
        return be3;
    }

    //returns an EAP
    public Booster getEAP(){
        return eap;
    }

    //returns an SRB
    public Booster getSRB(){
        return srb;
    }

    //returns the Orbit mission
    public Mission getOrbit(){
        return orbit;
    }

    //returns the ISS mission
    public Mission getISS(){
        return iss;
    }

    //returns the Moon mission
    public Mission getMoon(){
        return moon;
    }

    //returns the Mars mission
    public Mission getMars(){
        return mars;
    }

    //returns the secret mission
    public Mission getSecretMission(){
        return secretMission;
    }
    
}
