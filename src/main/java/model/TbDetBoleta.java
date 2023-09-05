package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the tb_det_boleta database table.
 * 
 */
@Entity
@Table(name="tb_det_boleta")
@NamedQuery(name="TbDetBoleta.findAll", query="SELECT t FROM TbDetBoleta t")
public class TbDetBoleta implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TbDetBoletaPK id;

	private int cantidad;

	private BigDecimal preciovta;

	//bi-directional many-to-one association to TbCabBoleta
	@ManyToOne
	@JoinColumn(name="num_bol" ,insertable=false, updatable=false)
	private TbCabBoleta tbCabBoleta;

	//bi-directional many-to-one association to TbProducto
	@ManyToOne
	@JoinColumn(name="id_prod" ,insertable=false, updatable=false)
	private TbProducto tbProducto;

	public TbDetBoleta() {
	}

	public TbDetBoletaPK getId() {
		return this.id;
	}

	public void setId(TbDetBoletaPK id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPreciovta() {
		return this.preciovta;
	}

	public void setPreciovta(BigDecimal preciovta) {
		this.preciovta = preciovta;
	}

	public TbCabBoleta getTbCabBoleta() {
		return this.tbCabBoleta;
	}

	public void setTbCabBoleta(TbCabBoleta tbCabBoleta) {
		this.tbCabBoleta = tbCabBoleta;
	}

	public TbProducto getTbProducto() {
		return this.tbProducto;
	}

	public void setTbProducto(TbProducto tbProducto) {
		this.tbProducto = tbProducto;
	}

}