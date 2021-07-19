package model;

import java.sql.Date;

public class RegistroModel {
    private int CODREG;
    private Date FECREG;
    private String CERTREG;
    private int CODPAR;

    public int getCODREG() {
        return CODREG;
    }

    public void setCODREG(int CODREG) {
        this.CODREG = CODREG;
    }

    public Date getFECREG() {
        return FECREG;
    }

    public void setFECREG(Date FECREG) {
        this.FECREG = FECREG;
    }

    public String getCERTREG() {
        return CERTREG;
    }

    public void setCERTREG(String CERTREG) {
        this.CERTREG = CERTREG;
    }

    public int getCODPAR() {
        return CODPAR;
    }

    public void setCODPAR(int CODPAR) {
        this.CODPAR = CODPAR;
    }

    public RegistroModel() {
    }

    public RegistroModel(int CODREG, Date FECREG, String CERTREG, int CODPAR) {
        this.CODREG = CODREG;
        this.FECREG = FECREG;
        this.CERTREG = CERTREG;
        this.CODPAR = CODPAR;
    }

    @Override
    public String toString() {
        return "RegistroModel{" + "CODREG=" + CODREG + ", FECREG=" + FECREG + ", CERTREG=" + CERTREG + ", CODPAR=" + CODPAR + '}';
    }
    
}