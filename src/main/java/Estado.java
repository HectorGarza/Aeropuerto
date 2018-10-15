import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "estados")

public class Estado implements Serializable {
    @Id
    @Column(name = "ID_PAIS")
    private double id_pais;

    @Id
    @Column(name = "ID_ESTADO")
    private double id_estado;

    @Column(name = "NOMBRE")
    private String nombre;

    public Estado () { }

    public Estado(double id_pais, double id_estado, String nombre) {
        this.id_pais = id_pais;
        this.id_estado = id_estado;
        this.nombre = nombre;
    }

    public double getId_pais() {
        return id_pais;
    }

    public void setId_pais(double id_pais) {
        this.id_pais = id_pais;
    }

    public double getId_estado() {
        return id_estado;
    }

    public void setId_estado(double id_estado) {
        this.id_estado = id_estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id_pais=" + id_pais +
                ", id_estado=" + id_estado +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
