package ufg.inf.si.estagio.model.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VagaEstagio {

    @Id
    @GeneratedValue
    private Long id;

    private String concedente;

    private String areaAtuacao;

    private String curso;

    private float cargaHoraria;

    private String tipoRemuneracao;

    private String localEnvioCurriculo;

    private String preRequisitos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConcedente() {
        return concedente;
    }

    public void setConcedente(String concedente) {
        this.concedente = concedente;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public float getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(float cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getTipoRemuneracao() {
        return tipoRemuneracao;
    }

    public void setTipoRemuneracao(String tipoRemuneracao) {
        this.tipoRemuneracao = tipoRemuneracao;
    }

    public String getLocalEnvioCurriculo() {
        return localEnvioCurriculo;
    }

    public void setLocalEnvioCurriculo(String localEnvioCurriculo) {
        this.localEnvioCurriculo = localEnvioCurriculo;
    }

    public String getPreRequisitos() {
        return preRequisitos;
    }

    public void setPreRequisitos(String preRequisitos) {
        this.preRequisitos = preRequisitos;
    }
}
