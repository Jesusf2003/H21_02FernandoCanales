package model;

public class RegistroDetalleModel {
    private int CODREGDET;
    private String TEMREGDET;
    private int CODCONF;
    private int CORDREG;

    public int getCODREGDET() {
        return CODREGDET;
    }

    public void setCODREGDET(int CODREGDET) {
        this.CODREGDET = CODREGDET;
    }

    public String getTEMREGDET() {
        return TEMREGDET;
    }

    public void setTEMREGDET(String TEMREGDET) {
        this.TEMREGDET = TEMREGDET;
    }

    public int getCODCONF() {
        return CODCONF;
    }

    public void setCODCONF(int CODCONF) {
        this.CODCONF = CODCONF;
    }

    public int getCORDREG() {
        return CORDREG;
    }

    public void setCORDREG(int CORDREG) {
        this.CORDREG = CORDREG;
    }

    public RegistroDetalleModel() {
    }

    public RegistroDetalleModel(int CODREGDET, String TEMREGDET, int CODCONF, int CORDREG) {
        this.CODREGDET = CODREGDET;
        this.TEMREGDET = TEMREGDET;
        this.CODCONF = CODCONF;
        this.CORDREG = CORDREG;
    }

    @Override
    public String toString() {
        return "RegistroDetalleModel{" + "CODREGDET=" + CODREGDET + ", TEMREGDET=" + TEMREGDET + ", CODCONF=" + CODCONF + ", CORDREG=" + CORDREG + '}';
    }
    
}