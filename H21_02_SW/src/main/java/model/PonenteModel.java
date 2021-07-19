package model;

public class PonenteModel {
    private int CODPON;
    private String NOMPON;
    private String APEPON;
    private String CELPON;
    private String DNIPON;
    private String EMAPON;
    private String DIRPON;

    public int getCODPON() {
        return CODPON;
    }

    public void setCODPON(int CODPON) {
        this.CODPON = CODPON;
    }

    public String getNOMPON() {
        return NOMPON;
    }

    public void setNOMPON(String NOMPON) {
        this.NOMPON = NOMPON;
    }

    public String getAPEPON() {
        return APEPON;
    }

    public void setAPEPON(String APEPON) {
        this.APEPON = APEPON;
    }

    public String getCELPON() {
        return CELPON;
    }

    public void setCELPON(String CELPON) {
        this.CELPON = CELPON;
    }

    public String getDNIPON() {
        return DNIPON;
    }

    public void setDNIPON(String DNIPON) {
        this.DNIPON = DNIPON;
    }

    public String getEMAPON() {
        return EMAPON;
    }

    public void setEMAPON(String EMAPON) {
        this.EMAPON = EMAPON;
    }

    public String getDIRPON() {
        return DIRPON;
    }

    public void setDIRPON(String DIRPON) {
        this.DIRPON = DIRPON;
    }

    public PonenteModel() {
    }

    public PonenteModel(int CODPON, String NOMPON, String APEPON, String CELPON, String DNIPON, String EMAPON, String DIRPON) {
        this.CODPON = CODPON;
        this.NOMPON = NOMPON;
        this.APEPON = APEPON;
        this.CELPON = CELPON;
        this.DNIPON = DNIPON;
        this.EMAPON = EMAPON;
        this.DIRPON = DIRPON;
    }

    @Override
    public String toString() {
        return "PonenteModel{" + "CODPON=" + CODPON + ", NOMPON=" + NOMPON + ", APEPON=" + APEPON + ", CELPON=" + CELPON + ", DNIPON=" + DNIPON + ", EMAPON=" + EMAPON + ", DIRPON=" + DIRPON + '}';
    }
    
}
