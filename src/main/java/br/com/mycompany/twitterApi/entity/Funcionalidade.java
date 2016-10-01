/**
 * @author marcel.costa
 * @name: CustomerController.java
 * @description: Controller layer to access the services 
 * */
package br.com.mycompany.twitterApi.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Marcel
 *
 */
/*@Entity
@Table(name = "customer")*/
@Entity
@Table(name = "TB_FUNCIONALIDADE")
public class Funcionalidade extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 7711505597348200997L;

	/*@Column(name = "name", nullable = false)*/
	
	/*@SequenceGenerator(name = "nickname_seq", sequenceName = "SEQUENCE_NAME_IN_DATABASE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nickname_seq")*/
	
	@Column(name = "CD_GRUPO_FUNC")
	private Long codigo;
	
	@Column(name = "DS_FUNCIONALIDADE")
	private String nome;
	
	/*@Column(name = "type", nullable = false)
	private String type;
	
	@Column(name = "cpf_cnpj")
	private String cpfCnpj;
	
	@Column(name = "email")
	private String email;*/
	
	
	@Transient
	private List<Order> listOrder;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Order> getListOrder() {
		return listOrder;
	}

	public void setListOrder(List<Order> listOrder) {
		this.listOrder = listOrder;
	}

}
