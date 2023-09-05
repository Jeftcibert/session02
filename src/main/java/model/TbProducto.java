package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tb_productos database table.
 * 
 */
@Entity
@Table(name="tb_productos")
@NamedQuery(name="TbProducto.findAll", query="SELECT t FROM TbProducto t")
public class TbProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_prod")
	private String idProd;

	@Column(name="des_prod")
	private String desProd;

	@Column(name="est_prod")
	private byte estProd;

	@Column(name="pre_prod")
	private BigDecimal preProd;

	@Column(name="stk_prod")
	private int stkProd;

	//bi-directional many-to-one association to TbDetBoleta
	@OneToMany(mappedBy="tbProducto")
	private List<TbDetBoleta> tbDetBoletas;

	//bi-directional many-to-one association to TbCategoria
	@ManyToOne
	@JoinColumn(name="idcategoria")
	private TbCategoria tbCategoria;

	//bi-directional many-to-one association to TbProveedor
	@ManyToOne
	@JoinColumn(name="idproveedor")
	private TbProveedor tbProveedor;

	public TbProducto() {
	}

	public String getIdProd() {
		return this.idProd;
	}

	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}

	public String getDesProd() {
		return this.desProd;
	}

	public void setDesProd(String desProd) {
		this.desProd = desProd;
	}

	public byte getEstProd() {
		return this.estProd;
	}

	public void setEstProd(byte estProd) {
		this.estProd = estProd;
	}

	public BigDecimal getPreProd() {
		return this.preProd;
	}

	public void setPreProd(BigDecimal preProd) {
		this.preProd = preProd;
	}

	public int getStkProd() {
		return this.stkProd;
	}

	public void setStkProd(int stkProd) {
		this.stkProd = stkProd;
	}

	public List<TbDetBoleta> getTbDetBoletas() {
		return this.tbDetBoletas;
	}

	public void setTbDetBoletas(List<TbDetBoleta> tbDetBoletas) {
		this.tbDetBoletas = tbDetBoletas;
	}

	public TbDetBoleta addTbDetBoleta(TbDetBoleta tbDetBoleta) {
		getTbDetBoletas().add(tbDetBoleta);
		tbDetBoleta.setTbProducto(this);

		return tbDetBoleta;
	}

	public TbDetBoleta removeTbDetBoleta(TbDetBoleta tbDetBoleta) {
		getTbDetBoletas().remove(tbDetBoleta);
		tbDetBoleta.setTbProducto(null);

		return tbDetBoleta;
	}

	public TbCategoria getTbCategoria() {
		return this.tbCategoria;
	}

	public void setTbCategoria(TbCategoria tbCategoria) {
		this.tbCategoria = tbCategoria;
	}

	public TbProveedor getTbProveedor() {
		return this.tbProveedor;
	}

	public void setTbProveedor(TbProveedor tbProveedor) {
		this.tbProveedor = tbProveedor;
	}

}