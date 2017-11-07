/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AcerF5w10
 */
@Entity
@Table(name = "usuarios_sistema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserA.findAll", query = "SELECT u FROM UserA u")
    , @NamedQuery(name = "UserA.findById", query = "SELECT u FROM UserA u WHERE u.id = :id")
    , @NamedQuery(name = "UserA.findByIdentificacion", query = "SELECT u FROM UserA u WHERE u.identificacion = :identificacion")
    , @NamedQuery(name = "UserA.findByNombres", query = "SELECT u FROM UserA u WHERE u.nombres = :nombres")
    , @NamedQuery(name = "UserA.findByApellidos", query = "SELECT u FROM UserA u WHERE u.apellidos = :apellidos")
    , @NamedQuery(name = "UserA.findByEmail", query = "SELECT u FROM UserA u WHERE u.email = :email")
    , @NamedQuery(name = "UserA.findByCelular", query = "SELECT u FROM UserA u WHERE u.celular = :celular")
    , @NamedQuery(name = "UserA.findByTelefono", query = "SELECT u FROM UserA u WHERE u.telefono = :telefono")
    , @NamedQuery(name = "UserA.findByTipousuario", query = "SELECT u FROM UserA u WHERE u.tipousuario = :tipousuario")
    , @NamedQuery(name = "UserA.findByContrasena", query = "SELECT u FROM UserA u WHERE u.contrasena = :contrasena")})
public class UserA implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "IDENTIFICACION")
    private Integer identificacion;
    @Column(name = "NOMBRES")
    private String nombres;
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "CELULAR")
    private Integer celular;
    @Column(name = "TELEFONO")
    private Integer telefono;
    @Column(name = "TIPOUSUARIO")
    private String tipousuario;
    @Column(name = "CONTRASENA")
    private String contrasena;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuId")
    private List<MaquinaVirtual> maquinaVirtualList;

    public UserA() {
    }

    public UserA(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @XmlTransient
    public List<MaquinaVirtual> getMaquinaVirtualList() {
        return maquinaVirtualList;
    }

    public void setMaquinaVirtualList(List<MaquinaVirtual> maquinaVirtualList) {
        this.maquinaVirtualList = maquinaVirtualList;
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
        if (!(object instanceof UserA)) {
            return false;
        }
        UserA other = (UserA) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UserA[ id=" + id + " ]";
    }
    
}
