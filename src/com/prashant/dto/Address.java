package com.prashant.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="USER_ADDRESS")
public class Address implements Serializable {
	@JsonIgnore
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ADDRESS_ID")
	@JsonProperty("address_id")
	private Long addressId;
	@Column(name = "ADDRESS_LINE_1")
	@JsonProperty("address_Line_1")
	private String addressLine1;
	@Column(name = "ADDRESS_LINE_2")
	@JsonProperty("address_Line_2")
	private String addressLine2;
	@Column(name = "ADDRESS_LINE_3")
	@JsonProperty("address_Line_3")
	private String addressLine3;
	@Column(name = "CITY")
	@JsonProperty("city")
	private String city;
	@Column(name = "ZIPCODE")
	@JsonProperty("zipcode")
	private String zipcode;
	
	@OneToOne(mappedBy="address")
	private UserDetails userDetails;
	
	@Override
	public String toString() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return null;
		}
	}
}
