package fr.uha.serfa.lpdao25.PaintBoot.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Dessin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Long id;

    @OneToMany
    @JoinColumn(name = "dessin_id")
    private List<Forme> forms = new ArrayList<>();

    public Dessin() {
    }

    public Dessin(Forme... formes) {
        Collections.addAll(this.forms, formes);
    }

    public Dessin(List<Forme> formes) {
        this.forms = formes;
    }

    public static void main(String[] args) {
        System.out.println("creation d'un dessin avec triangle, rectangle, rectangle, cercle");
        Dessin d = new Dessin(new Triangle(30, 150, 40), new Rectangle(20, 30, 40, 150), new Rectangle(), new Cercle(50, 200, 200));
        System.out.println(d);

        System.out.println("périmetre du dessing : " + d.getPerimetre());

        System.out.println("en html : \n" + d.toHTMLCanvas());

        System.out.println("creation d'un dessin avec pleins de formes et affichage du html");
        Dessin random = UtilsDrawGenerator.genereRandomDessin(1000);
        System.out.println(random.toHTMLCanvas());
    }

    public void addForme(Forme f) {
        this.forms.add(f);
    }

    public int getPerimetre() {
        int total = 0;
        for (Forme f : this.forms) {
            total += f.getPerimetre();
        }
        return total;
    }

    public void translate(int dx, int dy) {
        for (Forme f : this.forms) {
            f.translate(dx, dy);
        }
    }

    public String toHTMLCanvas() {
        StringBuilder sb = new StringBuilder();
        for (Forme f : this.forms) {
            sb.append("\n\t").append(f.toHTMLCanvas());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Dessin{" +
                "formes=" + this.forms +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
