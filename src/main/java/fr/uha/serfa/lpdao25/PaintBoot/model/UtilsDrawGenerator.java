package fr.uha.serfa.lpdao25.PaintBoot.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class UtilsDrawGenerator {

    public static Dessin genereRandomDessin(int nbrShapes) {

        List<Forme> formes = new ArrayList<>();
        for (int i = 0; i < nbrShapes; i++) {

            int x = ThreadLocalRandom.current().nextInt(0, 600 + 1);
            int y = ThreadLocalRandom.current().nextInt(0, 600 + 1);
            int randomType = ThreadLocalRandom.current().nextInt(0, 3 + 1);
            switch (randomType) {
                case 0:
                    formes.add(new Rectangle(15, 25, x, y));
                    break;
                case 1:
                    formes.add(new Triangle(15, x, y));
                    break;
                case 2:
                    formes.add(new Cercle(10, x, y));
                    break;
                default:
            }
        }
        return new Dessin(formes);
    }

    public static void main(String[] args) {
        Dessin d = genereRandomDessin(100);
        System.out.println(d);
    }

}
