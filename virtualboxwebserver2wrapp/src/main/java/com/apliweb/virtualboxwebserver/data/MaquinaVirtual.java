/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apliweb.virtualboxwebserver.data;

/**
 *
 * @author AcerF5w10
 */
public class MaquinaVirtual {
    protected String id;
    protected String usuNombre;
    protected String usuIndex;
    protected Double usoMemoria;
    protected Double usoCpu;
    protected Double usoProcesamiento;
    protected String usuId;  

    public MaquinaVirtual() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuIndex() {
        return usuIndex;
    }

    public void setUsuIndex(String usuIndex) {
        this.usuIndex = usuIndex;
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

    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }
}
