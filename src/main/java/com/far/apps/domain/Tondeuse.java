package com.far.apps.domain;

import java.io.IOException;

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



    public void providePosition(String initPosition){
        String[] position = initPosition.split(" ");
        this.x = Integer.parseInt(position[0]);
        this.y = Integer.parseInt(position[1]);
        this.orientation = position[2];
    }



    public void getInstructions(String instruction, int limitX, int limitY) throws IOException {

//         System.out.println("Instruction reçue : " + instruction);
//         System.out.println(limitX);
//         System.out.println(limitY);
        if(instruction.equals(Instructions.AVANCER.getValue()) ){
//             System.out.println("Instruction reçue avancer: " + instruction);
            avancer(limitX, limitY);
        }

        if(instruction.equals(Instructions.GAUCHE.getValue()) ){
            tournerGauche();
        }

        if(instruction.equals(Instructions.DROITE.getValue()) ){
            tournerDroite();
        }

    }

    public void avancer(int limitX, int limitY){

        if (this.orientation.equals(Orientations.NORTH.getValue())){
//            System.out.println("Instruction reçue avancer orientation: " + orientation);
//            System.out.println("y : " + this.y);
            int newY = this.y + 1;
            if(newY >= 0 && newY <= limitY){
                this.y+=1;
            }
//            System.out.println("new y : " + this.y);



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
    }

    public void tournerGauche(){
        if (this.orientation.equals(Orientations.NORTH.getValue())){
            this.orientation = Orientations.WEST.getValue();
        } else if (this.orientation.equals(Orientations.EAST.getValue())){
            this.orientation = Orientations.NORTH.getValue();
        } else if (this.orientation.equals(Orientations.WEST.getValue())){
            this.orientation = Orientations.SOUTH.getValue();
        } else if (this.orientation.equals(Orientations.SOUTH.getValue())){
            this.orientation = Orientations.EAST.getValue();
        }
    }

    public void tournerDroite(){
        if (this.orientation.equals(Orientations.NORTH.getValue())){
            this.orientation = Orientations.EAST.getValue();
        } else if (this.orientation.equals(Orientations.EAST.getValue())){
            this.orientation = Orientations.SOUTH.getValue();
        } else if (this.orientation.equals(Orientations.WEST.getValue())){
            this.orientation = Orientations.NORTH.getValue();
        } else if (this.orientation.equals(Orientations.SOUTH.getValue())){
            this.orientation = Orientations.WEST.getValue();
        }
    }

}
