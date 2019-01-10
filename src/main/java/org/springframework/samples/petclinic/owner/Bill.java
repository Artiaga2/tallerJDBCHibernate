package org.springframework.samples.petclinic.owner;

import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.NamedEntity;
import org.springframework.samples.petclinic.visit.Visit;

@Entity
@Table(name = "facturas")
public class Bill extends NamedEntity {
	
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
    
    public Long getFactura() {
		return factura;
	}

	public void setFactura(Long factura) {
		this.factura = factura;
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



	@OneToMany(cascade = CascadeType.ALL, mappedBy="facturaId", fetch = FetchType.EAGER)
    private Set<Visit> visits = new LinkedHashSet<>();
    
	
}
