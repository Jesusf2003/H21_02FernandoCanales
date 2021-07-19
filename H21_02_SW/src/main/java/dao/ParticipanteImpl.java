package dao;

import static dao.Conexion.conectar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ParticipanteModel;

public class ParticipanteImpl extends Conexion {

    public void registrar(ParticipanteModel par) throws Exception {
        String sql ="INSERT INTO PARTICIPANTE\n" +
                    "    (NOMPAR, APEPAR, DNIPAR, TIPPAR, CELPAR, EMAPAR, LUGPROPAR)\n" +
                    "VALUES\n" +
                    "    (?, ?, ?, ?, ?, ?, ?)";
        try {
            conectar();
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, par.getNOMPAR());
            ps.setString(2, par.getAPEPAR());
            ps.setString(3, par.getDNIPAR());
            ps.setString(4, par.getTIPPAR());
            ps.setString(5, par.getCELPAR());
            ps.setString(6, par.getEMAPAR());
            ps.setString(7, par.getLUGPROPAR());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Participante - Error en RegistrarDAO: " + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public void modificar(ParticipanteModel par) throws Exception {
        String sql = "UPDATE PARTICIPANTE"
                    + " SET NOMPAR=?, APEPAR=?, DNIPAR=?, TIPPAR=?, CELPAR=?, EMAPAR=?, LUGPROPAR=?"
                    + " WHERE CODPAR =?";
        try {
            conectar();
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, par.getNOMPAR());
            ps.setString(2, par.getAPEPAR());
            ps.setString(3, par.getDNIPAR());
            ps.setString(4, par.getTIPPAR());
            ps.setString(5, par.getCELPAR());
            ps.setString(6, par.getEMAPAR());
            ps.setString(7, par.getLUGPROPAR());
            ps.setInt(8, par.getCODPAR());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Participante - Error en ModificarDAO: " + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }
    
    public void eliminar(ParticipanteModel par) throws Exception{
        String sql = "UPDATE PARTICIPANTE SET PARTICIPANTE.ESTPAR='I' WHERE PARTICIPANTE.CODPAR=?";
        try {
            conectar();
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, par.getCODPAR());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Participante: Error en EliminarDAO: "+ e.getMessage());
        }finally{
            this.cerrarCnx();
        }
    }
    
    public List<ParticipanteModel> listar() throws Exception{
        List<ParticipanteModel> lista = null;
        ParticipanteModel par;
        try {
            conectar();
            String sql ="SELECT * FROM PARTICIPANTE WHERE ESTPAR = 'A' ORDER BY CODPAR DESC ";
            PreparedStatement ps = this.conectar().prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while(rs.next()){
                par = new ParticipanteModel();
                par.setCODPAR(rs.getInt("CODPAR"));
                par.setFECREGPAR(rs.getDate("FECREGPAR"));
                par.setNOMPAR(rs.getString("NOMPAR"));
                par.setAPEPAR(rs.getString("APEPAR"));
                par.setDNIPAR(rs.getString("DNIPAR"));
                par.setTIPPAR(rs.getString("TIPPAR"));
                par.setCELPAR(rs.getString("CELPAR"));
                par.setEMAPAR(rs.getString("EMAPAR"));
                par.setLUGPROPAR(rs.getString("LUGPROPAR"));
                par.setESTPAR(rs.getString("ESTPAR"));
                lista.add(par);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Participante - Error en ListarDAO: "+ e.getMessage());
        }finally{
            this.cerrarCnx();
        }
        return lista;
    }
}