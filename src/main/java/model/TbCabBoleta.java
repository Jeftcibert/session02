package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_cab_boleta database table.
 * 
 */
@Entity
@Table(name="tb_cab_boleta")
@NamedQuery(name="TbCabBoleta.findAll", query="SELECT t FROM TbCabBoleta t")
public class TbCabBoleta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="num_bol")
	private int numBol;

	@Temporal(TemporalType.DATE)
	@Column(name="fch_bol")
	private Date fchBol;

	//bi-directional many-to-one association to TbUsuario
	@ManyToOne
	@JoinColumn(name="cod_usua")
	private TbUsuario tbUsuario;

	//bi-directional many-to-one association to TbDetBoleta
	@OneToMany(mappedBy="tbCabBoleta")
	private List<TbDetBoleta> tbDetBoletas;

	public TbCabBoleta() {
	}

	public int getNumBol() {
		return this.numBol;
	}

	public void setNumBol(int numBol) {
		this.numBol = numBol;
	}

	public Date getFchBol() {
		return this.fchBol;
	}

	public void setFchBol(Date fchBol) {
		this.fchBol = fchBol;
	}

	public TbUsuario getTbUsuario() {
		return this.tbUsuario;
	}

	public void setTbUsuario(TbUsuario tbUsuario) {
		this.tbUsuario = tbUsuario;
	}

	public List<TbDetBoleta> getTbDetBoletas() {
		return this.tbDetBoletas;
	}

	public void setTbDetBoletas(List<TbDetBoleta> tbDetBoletas) {
		this.tbDetBoletas = tbDetBoletas;
	}

	public TbDetBoleta addTbDetBoleta(TbDetBoleta tbDetBoleta) {
		getTbDetBoletas().add(tbDetBoleta);
		tbDetBoleta.setTbCabBoleta(this);

		return tbDetBoleta;
	}

	public TbDetBoleta removeTbDetBoleta(TbDetBoleta tbDetBoleta) {
		getTbDetBoletas().remove(tbDetBoleta);
		tbDetBoleta.setTbCabBoleta(null);

		return tbDetBoleta;
	}

}