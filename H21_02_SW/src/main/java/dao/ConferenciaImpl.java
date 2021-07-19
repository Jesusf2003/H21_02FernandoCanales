package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ConferenciaModel;
import model.PonenteModel;

public class ConferenciaImpl extends Conexion{
    
    public List<ConferenciaModel> listarTema() throws Exception{
        List<ConferenciaModel> lista = null;
        ConferenciaModel conf;
        PonenteModel pon;
        try {
            conectar();
            String sql ="SELECT\n" +
                        "    CASE C.BLOCONF\n" +
                        "        WHEN 1 THEN 'Cyberseguridad'\n" +
                        "        WHEN 2 THEN 'Transformación Digital'\n" +
                        "        WHEN 3 THEN 'Desarrollo de Software Empresarial'\n" +
                        "        ELSE 'null'\n" +
                        "    END AS 'Bloque',\n" +
                        "    C.TEMCONF,\n" +
                        "    UPPER(P.APEPON) + ', ' + P.NOMPON\n" +
                        "FROM CONFERENCIA AS C\n" +
                        "    INNER JOIN PONENTE AS P\n" +
                        "    ON C.CODPON = P.CODPON\n" +
                        "WHERE C.BLOCONF = ?";
            PreparedStatement ps = this.conectar().prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()){
                conf = new ConferenciaModel();
                conf.setCODCONF(rs.getString("CODCONF"));
                conf.setTEMCONF(rs.getString("TEMCONF"));
                conf.setFECREACONF(rs.getDate("FECREACONF"));
                conf.setBLOCONF(rs.getString("BLOCONF"));
                conf.setCODPON(rs.getInt("CODPON"));
                
                pon = new PonenteModel();
                pon.setCODPON(rs.getInt("CODPON"));
                pon.setNOMPON(rs.getString("NOMPON"));
                pon.setAPEPON(rs.getString("APEPON"));
                pon.setCELPON(rs.getString("CELPON"));
                pon.setDNIPON(rs.getString("DNIPON"));
                pon.setEMAPON(rs.getString("EMAPON"));
                pon.setDIRPON(rs.getString("DIRPON"));
                
                lista.add(conf);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Conferencia - Error en ListarDao: "+ e.getMessage());
        }finally{
            this.cerrarCnx();
        }
        return lista;
    }
}
