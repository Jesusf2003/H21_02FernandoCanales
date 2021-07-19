package model;

import java.sql.Date;

public class ConferenciaModel {
    private String CODCONF;
    private String TEMCONF;
    private Date FECREACONF;
    private String BLOCONF;
    private int CODPON;

    public String getCODCONF() {
        return CODCONF;
    }

    public void setCODCONF(String CODCONF) {
        this.CODCONF = CODCONF;
    }

    public String getTEMCONF() {
        return TEMCONF;
    }

    public void setTEMCONF(String TEMCONF) {
        this.TEMCONF = TEMCONF;
    }

    public Date getFECREACONF() {
        return FECREACONF;
    }

    public void setFECREACONF(Date FECREACONF) {
        this.FECREACONF = FECREACONF;
    }

    public String getBLOCONF() {
        return BLOCONF;
    }

    public void setBLOCONF(String BLOCONF) {
        this.BLOCONF = BLOCONF;
    }

    public int getCODPON() {
        return CODPON;
    }

    public void setCODPON(int CODPON) {
        this.CODPON = CODPON;
    }

    public ConferenciaModel() {
    }

    public ConferenciaModel(String CODCONF, String TEMCONF, Date FECREACONF, String BLOCONF, int CODPON) {
        this.CODCONF = CODCONF;
        this.TEMCONF = TEMCONF;
        this.FECREACONF = FECREACONF;
        this.BLOCONF = BLOCONF;
        this.CODPON = CODPON;
    }

    @Override
    public String toString() {
        return "ConferenciaModel{" + "CODCONF=" + CODCONF + ", TEMCONF=" + TEMCONF + ", FECREACONF=" + FECREACONF + ", BLOCONF=" + BLOCONF + ", CODPON=" + CODPON + '}';
    }
    
}
