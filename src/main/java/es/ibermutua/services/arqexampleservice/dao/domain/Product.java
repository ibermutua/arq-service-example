package es.ibermutua.services.arqexampleservice.dao.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
@ApiModel(description = "All details about the Product. ")
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	@ApiModelProperty(notes = "The database generated product ID")
	private Long id;

	@Column(name = "NOMBRE", nullable = false, length = 100)
	@ApiModelProperty(notes = "The product name")
	private String nombre;

	@Column(name = "DESCRIPCION", length = 300)
	@ApiModelProperty(notes = "The product description")
	private String descripcion;

	@Column(name = "NUMERO_SERIE", length = 10)
	@ApiModelProperty(notes = "The product serial number")
	private String numeroSerie;


}
