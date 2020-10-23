package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "tbl_ordenes")
@Entity
public class Orden {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "orden_id")
    private Long orden_id;
    @Column(name = "orden_producto", length = 100)
    private String orden_producto;
    @Column(name = "orden_cantidad")
    private int orden_cantidad;
    @Column(name = "orden_precio")
    private int orden_precio;

    @Column(name = "cliente_id")
    private Long clienteId;

    @OneToMany(mappedBy = "orden", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cliente> clientes;

}
