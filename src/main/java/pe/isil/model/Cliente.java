package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "tbl_clientes")
@Entity
public class Cliente {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "cliente_id")
  private Long cliente_id;
  @Column(name = "cliente_dni", length = 8)
  private String cliente_dni;
  @Column(name = "cliente_nombre", length = 50)
  private String cliente_nombre;
  @Column(name = "cliente_apellidos", length = 100)
  private String cliente_apellidos;
  @Column(name = "cliente_email", length = 50)
  private String cliente_email;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "orden_id", insertable = false, updatable = false)
  private Orden orden;

}
