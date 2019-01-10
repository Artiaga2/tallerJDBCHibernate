package org.springframework.samples.petclinic.owner;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.NamedEntity;
import org.springframework.samples.petclinic.visit.Visit;

@Entity
@Table(name = "facturas")
public class Bill extends NamedEntity {
	@Min (10000000)
	@Max (99999999)
    @Digits(fraction = 0, integer = 10)
    private Long facturaId;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date fechaPago;
    
    @JoinColumn(name = "cuantia")
    private Integer cuantia;
    
    @ManyToOne
    @JoinColumn(name = "owner")
    private Owner owner;

	public Long getFacturaId() {
		return facturaId;
	}

	public void setFacturaId(Long facturaId) {
		this.facturaId = facturaId;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Integer getCuantia() {
		return cuantia;
	}

	public void setCuantia(Integer cuantia) {
		this.cuantia = cuantia;
	}

	@OneToOne(cascade = CascadeType.ALL, mappedBy="bill", fetch = FetchType.LAZY)
    private Visit visit;

	public Bill() {
	}
    
	
	
}
