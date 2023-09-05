package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_tipos database table.
 * 
 */
@Entity
@Table(name="tb_tipos")
@NamedQuery(name="TbTipo.findAll", query="SELECT t FROM TbTipo t")
public class TbTipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idtipo;

	private String descripcion;

	//bi-directional many-to-one association to TbUsuario
	@OneToMany(mappedBy="tbTipo")
	private List<TbUsuario> tbUsuarios;

	public TbTipo() {
	}

	public int getIdtipo() {
		return this.idtipo;
	}

	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<TbUsuario> getTbUsuarios() {
		return this.tbUsuarios;
	}

	public void setTbUsuarios(List<TbUsuario> tbUsuarios) {
		this.tbUsuarios = tbUsuarios;
	}

	public TbUsuario addTbUsuario(TbUsuario tbUsuario) {
		getTbUsuarios().add(tbUsuario);
		tbUsuario.setTbTipo(this);

		return tbUsuario;
	}

	public TbUsuario removeTbUsuario(TbUsuario tbUsuario) {
		getTbUsuarios().remove(tbUsuario);
		tbUsuario.setTbTipo(null);

		return tbUsuario;
	}

}