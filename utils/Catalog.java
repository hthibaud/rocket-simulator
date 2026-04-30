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


    public Launcher getFalcon9(){
        return falcon;
    }

    public Launcher getArianeV(){
        return ariane;
    }

    public Launcher getSaturneV(){
        return saturne;
    }

    public Launcher getSLS(){
        return sls;
    }

    public Capsule getCargoDragon(){
        return cargoDragon;
    }

    public Capsule getCrewDragon(){
        return crewDragon;
    }

    public Capsule getApollo(){
        return apollo;
    }

    public Capsule getOrion(){
        return orion;
    }

    public Booster getBE3(){
        return be3;
    }

    public Booster getEAP(){
        return eap;
    }

    public Booster getSRB(){
        return srb;
    }

    public Mission getOrbit(){
        return orbit;
    }

    public Mission getISS(){
        return iss;
    }

    public Mission getMoon(){
        return moon;
    }

    public Mission getMars(){
        return mars;
    }

    public Mission getSecretMission(){
        return secretMission;
    }
    
}
