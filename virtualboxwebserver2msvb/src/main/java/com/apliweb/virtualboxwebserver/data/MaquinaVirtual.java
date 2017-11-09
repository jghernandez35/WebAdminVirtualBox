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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AcerF5w10
 */
@Entity
@Table(name = "maquina_virtual")
@XmlRootElement
public class MaquinaVirtual implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "USU_ID")
    private String usuId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "USU_INDEX")
    private String usuIndex;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "USU_NOMBRE")
    private String usuNombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "USO_MEMORIA")
    private Double usoMemoria;
    @Column(name = "USO_CPU")
    private Double usoCpu;
    @Column(name = "USO_PROCESAMIENTO")
    private Double usoProcesamiento;

    public MaquinaVirtual() {
    }

    public MaquinaVirtual(String id) {
        this.id = id;
    }

    public MaquinaVirtual(String id, String usuId, String usuIndex, String usuNombre) {
        this.id = id;
        this.usuId = usuId;
        this.usuIndex = usuIndex;
        this.usuNombre = usuNombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

    public String getUsuIndex() {
        return usuIndex;
    }

    public void setUsuIndex(String usuIndex) {
        this.usuIndex = usuIndex;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
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
