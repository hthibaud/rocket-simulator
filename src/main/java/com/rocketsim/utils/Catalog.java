package com.rocketsim.utils;

import com.rocketsim.models.booster.BE3;
import com.rocketsim.models.booster.EAP;
import com.rocketsim.models.booster.SRB;
import com.rocketsim.models.capsule.Apollo;
import com.rocketsim.models.capsule.CargoDragon;
import com.rocketsim.models.capsule.CrewDragon;
import com.rocketsim.models.capsule.Orion;
import com.rocketsim.models.launcher.ArianeV;
import com.rocketsim.models.launcher.Falcon9;
import com.rocketsim.models.launcher.SLS;
import com.rocketsim.models.launcher.SaturneV;
import com.rocketsim.models.mission.ISS;
import com.rocketsim.models.mission.Mars;
import com.rocketsim.models.mission.Moon;
import com.rocketsim.models.mission.Orbit;
import com.rocketsim.models.mission.SecretMission;

public class Catalog {

    private Falcon9 falcon9 = new Falcon9();
    private ArianeV arianeV = new ArianeV();
    private SaturneV saturneV = new SaturneV();
    private SLS sls = new SLS();

    private CargoDragon cargoDragon = new CargoDragon();
    private CrewDragon crewDragon = new CrewDragon();
    private Apollo apollo = new Apollo();
    private Orion orion = new Orion();

    private BE3 be3 = new BE3();
    private EAP eap = new EAP();
    private SRB srb = new SRB();

    private Orbit orbit = new Orbit();
    private ISS iss = new ISS();
    private Moon moon = new Moon();
    private Mars mars = new Mars();
    private SecretMission secretMission = new SecretMission();


    public Falcon9 getFalcon9() {
        return falcon9;
    }

    public ArianeV getArianeV() {
        return arianeV;
    }

    public SaturneV getSaturneV() {
        return saturneV;
    }

    public SLS getSLS() {
        return sls;
    }

    public CargoDragon getCargoDragon() {
        return cargoDragon;
    }

    public CrewDragon getCrewDragon() {
        return crewDragon;
    }

    public Apollo getApollo() {
        return apollo;
    }

    public Orion getOrion() {
        return orion;
    }

    public BE3 getBE3() {
        return be3;
    }

    public EAP getEAP() {
        return eap;
    }

    public SRB getSRB() {
        return srb;
    }

    public Orbit getOrbit() {
        return orbit;
    }

    public ISS getISS() {
        return iss;
    }

    public Moon getMoon() {
        return moon;
    }

    public Mars getMars() {
        return mars;
    }
    public SecretMission getSecretMission(){
        return secretMission;
    }
}
