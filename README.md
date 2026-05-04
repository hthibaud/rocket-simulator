# Rocket Simulator

A Java rocket simulation project that models launch vehicles, capsules, boosters, missions, and flight sequences.

## Overview

This simulator is built in Java and provides a modular structure for creating and launching rockets with different components and mission profiles. It includes:

- Launchers, boosters, capsules, and mission modules with their own definition
- Simulation and launch 
- Utilities for ASCII display and data catalog support

## Project Structure

- `Program.java` - main entry point for the application
- `core/` - core classes for building, launching, and simulating rockets
  - `Builder.java`
  - `Launch.java`
  - `Rocket.java`
  - `Simulator.java`
- `models/` - rocket component and mission definitions
  - `booster/` - booster types such as `BE3`, `EAP`, `SRB`
  - `capsule/` - capsules like `Apollo`, `CargoDragon`, `CrewDragon`, `Orion`
  - `launcher/` - launchers like `ArianeV`, `Falcon9`, `SaturneV`, `SLS`
  - `mission/` - mission profiles including `ISS`, `Mars`, `Moon`, `Orbit`, `SecretMission`
- `simulator/` - simulation-specific classes
- `utils/` - utility helpers such as `ASCII`, `Catalog`, and generic helpers in `utils.java`

## Build and Run

Compile the project from the repository root:

```bash
javac Program.java
```

Run the simulator:

```bash
java Program
```

> If the project uses packages, compile and run from the package root or adjust the classpath accordingly.

## Notes

- The simulator is organized to support extensible rocket configurations and mission logic.
- New models, launchers, capsules, and missions can be added by following the existing class structure.
- The current entry point is `Program.java`, which initializes the simulation and starts hte program.

Made by Thibaud Herry