

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAISES")

public class Pais {
    @Id
    @Column(name = "id_pais")
    private double id_pais;

    @Column(name ="nombre")
    private String nombre;

    public Pais () {}

    public Pais(double id_pais, String nombre) {
        this.id_pais = id_pais;
        this.nombre = nombre;
    }
    public double getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id_pais=" + id_pais +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
