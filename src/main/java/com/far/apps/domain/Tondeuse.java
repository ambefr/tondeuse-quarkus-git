package com.far.apps.domain;

import java.io.IOException;

/**
 * @author richard
 * Classe Tondeuse permettant d'instancier les tondeuses
 */
public class Tondeuse {
    private int x;
    private int y;
    private String orientation;

    public Tondeuse() {
    }

    public Tondeuse(int x, int y, String orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }


    /**
     * Permet de fournir les coordonnées de la position initiale de la tondeuse
     * @param initPosition
     */
    public void providePosition(String initPosition){
        try {
            String[] position = initPosition.split(" ");
            this.x = Integer.parseInt(position[0]);
            this.y = Integer.parseInt(position[1]);
            this.orientation = position[2];
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }


    /**
     * Permet de récupérer les instructions à passer l'intance en cours de la tondeuse
     * @param instruction la chaine de caractères contenant les instructions
     * @param limitX la limite du coin supérieur droit en abscisse
     * @param limitY la limite du coin supérieur droit en ordonnée
     */

    public void getInstructions(String instruction, int limitX, int limitY) {

        try{
            if(instruction.equals(Instructions.AVANCER.getValue()) ){
                avancer(limitX, limitY);
            }

            if(instruction.equals(Instructions.GAUCHE.getValue()) ){
                tournerGauche();
            }

            if(instruction.equals(Instructions.DROITE.getValue()) ){
                tournerDroite();
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }


    }

    /**
     * Faire avancer la tondeuse sans sortir des limites de la surface
     * @param limitX
     * @param limitY
     */
    public void avancer(int limitX, int limitY){

        try {
            if (this.orientation.equals(Orientations.NORTH.getValue())){
                int newY = this.y + 1;
                if(newY >= 0 && newY <= limitY){
                    this.y+=1;
                }
            }

            if (this.orientation.equals(Orientations.EAST.getValue())){
                int newX = this.x + 1;
                if(newX >= 0 && newX <= limitX){
                    this.x+=1;
                }

            }

            if (this.orientation.equals(Orientations.WEST.getValue())){
                int newX = this.x - 1;
                if(newX >= 0 && newX <= limitX){
                    this.x-=1;
                }
            }

            if (this.orientation.equals(Orientations.SOUTH.getValue())){
                int newY = this.y - 1;
                if(newY >= 0 && newY <= limitY){
                    this.y-=1;
                }

            }
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    /**
     * Faire touner la tondeuse vers la gauche
     */
    public void tournerGauche(){
        try {
            if (this.orientation.equals(Orientations.NORTH.getValue())){
                this.orientation = Orientations.WEST.getValue();
            } else if (this.orientation.equals(Orientations.EAST.getValue())){
                this.orientation = Orientations.NORTH.getValue();
            } else if (this.orientation.equals(Orientations.WEST.getValue())){
                this.orientation = Orientations.SOUTH.getValue();
            } else if (this.orientation.equals(Orientations.SOUTH.getValue())){
                this.orientation = Orientations.EAST.getValue();
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    /**
     * Faire touner la tondeuse vers la droite
     */
    public void tournerDroite(){
        try {
            if (this.orientation.equals(Orientations.NORTH.getValue())){
                this.orientation = Orientations.EAST.getValue();
            } else if (this.orientation.equals(Orientations.EAST.getValue())){
                this.orientation = Orientations.SOUTH.getValue();
            } else if (this.orientation.equals(Orientations.WEST.getValue())){
                this.orientation = Orientations.NORTH.getValue();
            } else if (this.orientation.equals(Orientations.SOUTH.getValue())){
                this.orientation = Orientations.WEST.getValue();
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
