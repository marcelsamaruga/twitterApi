package br.com.mycompany.twitterApi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="twitter_user")
@Entity
public class TwitterUser extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -7335397239872144141L; 

	@Column(name="login")
	private String login;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="url")
	private String URL;
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the uRL
	 */
	public String getURL() {
		return URL;
	}
	/**
	 * @param uRL the uRL to set
	 */
	public void setURL(String uRL) {
		URL = uRL;
	}
	/**
	 * @return the profileImageURL
	 */
	public String getProfileImageURL() {
		return profileImageURL;
	}
	/**
	 * @param profileImageURL the profileImageURL to set
	 */
	public void setProfileImageURL(String profileImageURL) {
		this.profileImageURL = profileImageURL;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	@Column(name="profile_img_url")
	private String profileImageURL;
	
	@Column(name="location")
	private String location;
	
	@Column(name="created")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date created;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	
	
}
