﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using SpaceTransporter.Entities;

namespace SpaceTransporter.Interfaces
{
    public interface IService
    {

        public void CreateNewShip(Ship ship);
        public List<Ship> ReadAllShips();
        public Ship ReadShip(string shipName);
        public Ship ReadShip(int shipId);
        public void UpdateShip(Ship updateValue);
        public void DeleteShip(Ship ship);

        // Create Planet is not allowed according to the assignment
        public List<Planet> ReadAllPlanets();
        public Planet ReadPlanet(string planetName);
        public Planet ReadPlanet(int planetId);
        public void UpdatePlanet(int planetIdToBeUpdated, Planet updateVlaue);
        public void DeletePlanet(Planet planet);
    }
}
