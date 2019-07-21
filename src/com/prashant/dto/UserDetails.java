package com.prashant.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="USER_DETAILS")
public class UserDetails implements Serializable{

	@JsonIgnore
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	@Column(name="USER_ID")
	@JsonProperty("user_id")
	private long userId;
	@Column(name="USER_NAME")
	@JsonProperty("user_name")
	private String userName;
	
	@JsonValue
	public String toJson() {
		return this.userId+","+this.userName;
	}
	
	@Override
	public String toString() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return null;
		}
	}
}
