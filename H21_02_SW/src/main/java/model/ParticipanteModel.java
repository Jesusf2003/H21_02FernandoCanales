package model;

import java.sql.Date;

public class ParticipanteModel {
    private int CODPAR;
    private Date FECREGPAR;
    private String NOMPAR;
    private String APEPAR;
    private String DNIPAR;
    private String TIPPAR;
    private String CELPAR;
    private String EMAPAR;
    private String LUGPROPAR;
    private String ESTPAR;

    public int getCODPAR() {
        return CODPAR;
    }

    public void setCODPAR(int CODPAR) {
        this.CODPAR = CODPAR;
    }

    public Date getFECREGPAR() {
        return FECREGPAR;
    }

    public void setFECREGPAR(Date FECREGPAR) {
        this.FECREGPAR = FECREGPAR;
    }

    public String getNOMPAR() {
        return NOMPAR;
    }

    public void setNOMPAR(String NOMPAR) {
        this.NOMPAR = NOMPAR;
    }

    public String getAPEPAR() {
        return APEPAR;
    }

    public void setAPEPAR(String APEPAR) {
        this.APEPAR = APEPAR;
    }

    public String getDNIPAR() {
        return DNIPAR;
    }

    public void setDNIPAR(String DNIPAR) {
        this.DNIPAR = DNIPAR;
    }

    public String getTIPPAR() {
        return TIPPAR;
    }

    public void setTIPPAR(String TIPPAR) {
        this.TIPPAR = TIPPAR;
    }

    public String getCELPAR() {
        return CELPAR;
    }

    public void setCELPAR(String CELPAR) {
        this.CELPAR = CELPAR;
    }

    public String getEMAPAR() {
        return EMAPAR;
    }

    public void setEMAPAR(String EMAPAR) {
        this.EMAPAR = EMAPAR;
    }

    public String getLUGPROPAR() {
        return LUGPROPAR;
    }

    public void setLUGPROPAR(String LUGPROPAR) {
        this.LUGPROPAR = LUGPROPAR;
    }

    public String getESTPAR() {
        return ESTPAR;
    }

    public void setESTPAR(String ESTPAR) {
        this.ESTPAR = ESTPAR;
    }

    public ParticipanteModel() {
    }

    public ParticipanteModel(int CODPAR, Date FECREGPAR, String NOMPAR, String APEPAR, String DNIPAR, String TIPPAR, String CELPAR, String EMAPAR, String LUGPROPAR, String ESTPAR) {
        this.CODPAR = CODPAR;
        this.FECREGPAR = FECREGPAR;
        this.NOMPAR = NOMPAR;
        this.APEPAR = APEPAR;
        this.DNIPAR = DNIPAR;
        this.TIPPAR = TIPPAR;
        this.CELPAR = CELPAR;
        this.EMAPAR = EMAPAR;
        this.LUGPROPAR = LUGPROPAR;
        this.ESTPAR = ESTPAR;
    }

    @Override
    public String toString() {
        return "ParticipanteModel{" + "CODPAR=" + CODPAR + ", FECREGPAR=" + FECREGPAR + ", NOMPAR=" + NOMPAR + ", APEPAR=" + APEPAR + ", DNIPAR=" + DNIPAR + ", TIPPAR=" + TIPPAR + ", CELPAR=" + CELPAR + ", EMAPAR=" + EMAPAR + ", LUGPROPAR=" + LUGPROPAR + ", ESTPAR=" + ESTPAR + '}';
    }
    
}