package com.far.apps.service;

import com.far.apps.domain.Tondeuse;
import io.quarkus.runtime.annotations.QuarkusMain;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

@QuarkusMain
public class TondeuseMain {

    public static void main(String... args) {
        Path path = Paths.get("src", "test", "resources", "instructions.txt");
        String rep = lancerTondeuses(path);
        System.out.println(rep);
    }

    public static String lancerTondeuses (Path path) {

        try {
            String rep = new String("");
            int nbTondeuses = 0;

            List<String> lines = Files.lines(path).collect(Collectors.toList());

            nbTondeuses = (lines.size() - 1) / 2;

            String[] coinSuperieur = lines.get(0).split(" ");

            int j = 1;

            for (int i = 0; i < nbTondeuses; i++) {
                Tondeuse t = new Tondeuse();
                String initPosition = lines.get(j);

                t.providePosition(initPosition);

                String instruction = lines.get(j + 1);
                String[] instructions = instruction.split("");

                for (String inst : instructions) {
                    t.getInstructions(inst, Integer.parseInt(coinSuperieur[0]), Integer.parseInt(coinSuperieur[1]));
                }

                rep = rep.concat(String.valueOf(t.getX()))
                        .concat(" ")
                        .concat(String.valueOf(t.getY()))
                        .concat(" ")
                        .concat(t.getOrientation()).concat(" ");

                j += 2;
            }

            return rep.trim();

        } catch (FileNotFoundException ex) {
            System.out.println("---- ERREUR : Fichier introuvable !");
            return null;
        } catch (Exception ex) {
            System.out.println("--- ERROR :" + ex);
            return null;
        }
    }



}
