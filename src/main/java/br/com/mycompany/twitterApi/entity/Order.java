package br.com.mycompany.twitterApi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author Marcel
 *
 */
/*@Entity
@Table(name = "orders")*/
public class Order extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -7335397234232144141L;

	
	/*@Column(name = "num_order", nullable = false, unique = true)
	private String numOrder;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "date_order")
	private Date date;
	
	@ManyToOne( targetEntity=Customer.class, fetch = FetchType.EAGER )
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	@Transient
	private List<Product> listProduct;

	public String getNumOrder() {
		return numOrder;
	}

	public void setNumOrder(String numOrder) {
		this.numOrder = numOrder;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}*/

	
}
