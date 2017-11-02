/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apliweb.virtualboxwebserver.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AcerF5w10
 */
@Entity
@Table(name = "maquina_virtual")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaquinaVirtual.findAll", query = "SELECT m FROM MaquinaVirtual m")
    , @NamedQuery(name = "MaquinaVirtual.findById", query = "SELECT m FROM MaquinaVirtual m WHERE m.id = :id")
    , @NamedQuery(name = "MaquinaVirtual.findByUsoMemoria", query = "SELECT m FROM MaquinaVirtual m WHERE m.usoMemoria = :usoMemoria")
    , @NamedQuery(name = "MaquinaVirtual.findByUsoCpu", query = "SELECT m FROM MaquinaVirtual m WHERE m.usoCpu = :usoCpu")
    , @NamedQuery(name = "MaquinaVirtual.findByUsoProcesamiento", query = "SELECT m FROM MaquinaVirtual m WHERE m.usoProcesamiento = :usoProcesamiento")})
public class MaquinaVirtual implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "USO_MEMORIA")
    private Double usoMemoria;
    @Column(name = "USO_CPU")
    private Double usoCpu;
    @Column(name = "USO_PROCESAMIENTO")
    private Double usoProcesamiento;
    @JoinColumn(name = "USU_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private UserA usuId;

    public MaquinaVirtual() {
    }

    public MaquinaVirtual(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getUsoMemoria() {
        return usoMemoria;
    }

    public void setUsoMemoria(Double usoMemoria) {
        this.usoMemoria = usoMemoria;
    }

    public Double getUsoCpu() {
        return usoCpu;
    }

    public void setUsoCpu(Double usoCpu) {
        this.usoCpu = usoCpu;
    }

    public Double getUsoProcesamiento() {
        return usoProcesamiento;
    }

    public void setUsoProcesamiento(Double usoProcesamiento) {
        this.usoProcesamiento = usoProcesamiento;
    }

    public UserA getUsuId() {
        return usuId;
    }

    public void setUsuId(UserA usuId) {
        this.usuId = usuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaquinaVirtual)) {
            return false;
        }
        MaquinaVirtual other = (MaquinaVirtual) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apliweb.virtualboxwebserver.data.MaquinaVirtual[ id=" + id + " ]";
    }
    
}
