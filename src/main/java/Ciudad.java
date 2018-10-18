import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "CIUDADES")
public class Ciudad implements Serializable {
    @Id
    @Column(name = "id_pais")
    private double id_pais;

    @Id
    @Column(name = "id_estado")
    private double id_estado;

    @Id
    @Column(name = "id_ciudad")
    private double id_ciudad;

    @Column(name = "nombre")
    private String nombre;

    public double getId_pais () {
        return id_pais;
    }

    public void setId_pais (double id_pais) {
        this.id_pais = id_pais;
    }

    public double getId_estado () {
        return id_estado;
    }

    public void setId_estado (double id_estado) {
        this.id_estado = id_estado;
    }

    public double getId_ciudad () {
        return id_ciudad;
    }

    public void setId_ciudad (double id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getNombre () {
        return nombre;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }
}
