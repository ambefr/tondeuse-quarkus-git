package com.far.apps.service;

import com.far.apps.domain.Tondeuse;

import javax.enterprise.context.ApplicationScoped;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author richard
 *
 */
@ApplicationScoped
public class TondeuseService {

    private static final Logger LOG = Logger.getLogger(TondeuseService.class.getName());

    public String lancerTondeuses (Path path) throws IOException {

        //String content = Files.readString(path);

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



                LOG.log(Level.SEVERE, "---- rep : {0}",rep);

            }

            rep = rep.trim();
            return rep;

        } catch (FileNotFoundException ex){
            LOG.log(Level.SEVERE, "---- ERREUR : Fichier introuvable !");
            return null;
        } catch (Exception ex){
            LOG.log(Level.SEVERE, "---- ERROR", ex);
            return null;
        }

    }

}
