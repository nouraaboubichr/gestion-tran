/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author hp
 */

public class Bus {
    private int id;
    private String immatriculation;
    private int nombrePlaces;

    public Bus(int id, String immatriculation, int nombrePlaces) {
        this.id = id;
        this.immatriculation = immatriculation;
        this.nombrePlaces = nombrePlaces;
    }

    public Bus(String immatriculation, int nombrePlaces) {
        this.immatriculation = immatriculation;
        this.nombrePlaces = nombrePlaces;
    }

    public int getId() {
        return id; 
    }
    public String getImmatriculation() {
        return immatriculation;
    }
    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public void setId(int id) {
        this.id = id; 
    }
    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }
    @Override
    public String toString() {
       return  " (ID: " + this.getId() + ")";
    }
    
}