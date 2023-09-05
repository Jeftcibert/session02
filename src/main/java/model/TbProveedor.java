package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_proveedor database table.
 * 
 */
@Entity
@Table(name="tb_proveedor")
@NamedQuery(name="TbProveedor.findAll", query="SELECT t FROM TbProveedor t")
public class TbProveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idproveedor;

	private String email;

	@Column(name="nombre_rs")
	private String nombreRs;

	private String telefono;

	//bi-directional many-to-one association to TbProducto
	@OneToMany(mappedBy="tbProveedor")
	private List<TbProducto> tbProductos;

	public TbProveedor() {
	}

	public int getIdproveedor() {
		return this.idproveedor;
	}

	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreRs() {
		return this.nombreRs;
	}

	public void setNombreRs(String nombreRs) {
		this.nombreRs = nombreRs;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<TbProducto> getTbProductos() {
		return this.tbProductos;
	}

	public void setTbProductos(List<TbProducto> tbProductos) {
		this.tbProductos = tbProductos;
	}

	public TbProducto addTbProducto(TbProducto tbProducto) {
		getTbProductos().add(tbProducto);
		tbProducto.setTbProveedor(this);

		return tbProducto;
	}

	public TbProducto removeTbProducto(TbProducto tbProducto) {
		getTbProductos().remove(tbProducto);
		tbProducto.setTbProveedor(null);

		return tbProducto;
	}

}