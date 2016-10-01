package br.com.mycompany.twitterApi.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Marcel
 *
 */
/*@Entity
@Table(name = "product_order")*/
public class Product extends BaseEntity implements Serializable {


	private static final long serialVersionUID = -3048793723783704758L;

//	@Column(name = "name", nullable = false)
//	private String name;
//	
//	@Column(name = "value", nullable = false)
//	private BigDecimal value;
//	
//	@JoinColumn(name = "id_order")
//	@ManyToOne(targetEntity=Order.class)
//	private Order order;
//	
//	@Column(name = "product_number")
//	private Integer prodNumber;
//	
//	@Column(name = "quantity")
//	private Integer quantity;
//
//	/**
//	 * @return the name
//	 */
//	public String getName() {
//		return name;
//	}
//
//	/**
//	 * @param name the name to set
//	 */
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	/**
//	 * @return the value
//	 */
//	public BigDecimal getValue() {
//		return value;
//	}
//
//	/**
//	 * @param value the value to set
//	 */
//	public void setValue(BigDecimal value) {
//		this.value = value;
//	}
//
//	/**
//	 * @return the order
//	 */
//	public Order getOrder() {
//		return order;
//	}
//
//	/**
//	 * @param order the order to set
//	 */
//	public void setOrder(Order order) {
//		this.order = order;
//	}
//
//	/**
//	 * @return the prodNumber
//	 */
//	public Integer getProdNumber() {
//		return prodNumber;
//	}
//
//	/**
//	 * @param prodNumber the prodNumber to set
//	 */
//	public void setProdNumber(Integer prodNumber) {
//		this.prodNumber = prodNumber;
//	}
//
//	/**
//	 * @return the quantity
//	 */
//	public Integer getQuantity() {
//		return quantity;
//	}
//
//	/**
//	 * @param quantity the quantity to set
//	 */
//	public void setQuantity(Integer quantity) {
//		this.quantity = quantity;
//	}	
	
}
