package fr.uha.serfa.lpdao25.PaintBoot.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Forme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    protected Long id;

    @Column
    protected int y = 50;
    @Column
    private int x = 10;

    public Forme() {
    }

    public Forme(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public abstract int getPerimetre();

    public abstract String toHTMLCanvas();

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void translate(int dx, int dy) {
        this.x = this.x + dx;
        this.y += dy;
    }

    @Override
    public String toString() {
        return "Forme{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}
