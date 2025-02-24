package fr.uha.serfa.lpdao25.PaintBoot.model;

import jakarta.persistence.Entity;

@Entity
public class Rectangle extends Forme {

    private int longueur;
    private int hauteur;

    public Rectangle() {
        this.hauteur = 10;
        this.longueur = 5;
    }

    public Rectangle(int hauteur, int longueur) {
        this.hauteur = hauteur;
        this.longueur = longueur;
    }

    public Rectangle(int hauteur, int longueur, int x, int y) {
        super(x, y);
        this.longueur = longueur;
        this.hauteur = hauteur;
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        Rectangle r2 = new Rectangle(3, 4);

        System.out.println(r);
        System.out.println(r2);
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getPerimetre() {
        return (this.hauteur + this.longueur) * 2;
    }

    public String toHTMLCanvas() {
        String res = "ctx.fillRect(";
        res += this.getX() + ",";
        res += this.getY() + ",";
        res += this.hauteur + ",";
        res += this.longueur + ");";
        return res;
    }

    @Override
    public String toString() {
        return "Je suis un rectangle avec une longueur de : " + this.longueur + " et une hauteur " + this.hauteur + " le perimetre = " + this.getPerimetre() + "la position " + super.toString();
    }
}
