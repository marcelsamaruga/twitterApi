package br.com.mycompany.twitterApi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="twitter_log")
public class TwitterLog extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -3985428490705878499L;

	@Column(name="log")
	private String log;
	
	@Column(name="date")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="id_twitter_user", referencedColumnName="id", nullable=false)
	private TwitterUser twitterUser;
	
	@ManyToOne
	@JoinColumn(name="id_twitter_user_request", referencedColumnName="id")
	private TwitterUser twitterUserRequest;
	
	@Column(name="count_retweet")
	private Long countRetweet;
	
	@Column(name="count_favorite")
	private Long countFavorite;

	/**
	 * @return the countFavorite
	 */
	public Long getCountFavorite() {
		return countFavorite;
	}
	
	public void setCountFavorite(Long countFavorite) {
		this.countFavorite = countFavorite;
	}

	/**
	 * @return the twitterUserRequest
	 */
	public TwitterUser getTwitterUserRequest() {
		return twitterUserRequest;
	}

	/**
	 * @param twitterUserRequest the twitterUserRequest to set
	 */
	public void setTwitterUserRequest(TwitterUser twitterUserRequest) {
		this.twitterUserRequest = twitterUserRequest;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TwitterUser getTwitterUser() {
		return twitterUser;
	}

	public void setTwitterUser(TwitterUser twitterUser) {
		this.twitterUser = twitterUser;
	}

	/**
	 * @return the countRetweet
	 */
	public Long getCountRetweet() {
		return countRetweet;
	}

	/**
	 * @param countRetweet the countRetweet to set
	 */
	public void setCountRetweet(Long countRetweet) {
		this.countRetweet = countRetweet;
	}
	
}
