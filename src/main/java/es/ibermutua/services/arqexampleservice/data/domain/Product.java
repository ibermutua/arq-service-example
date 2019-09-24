package es.ibermutua.services.arqexampleservice.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table (name = "PRODUCT")
@ApiModel(description = "All details about the Product. ")
@Data
public class Product {
	@Id
	@GeneratedValue
    @Column(name = "ID", nullable = false)
	@ApiModelProperty(notes = "The database generated product ID")
    private Long id;
	
	@Column(name = "NOMBRE", nullable = false)
	@ApiModelProperty(notes = "The product name")
    private String nombre;
	
	@Column (name ="DESCRIPCION")
	@ApiModelProperty(notes = "The product description")
	private String descripcion;
	
	@Column (name ="NUMERO_SERIE")
	@ApiModelProperty(notes = "The product serial number")
	private String numeroSerie;
	
	
}
