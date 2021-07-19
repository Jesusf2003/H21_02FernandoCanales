package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ConferenciaModel;
import model.PonenteModel;
import model.RegistroDetalleModel;
import model.RegistroModel;
import model.TemaModelo;

public class RegistroImpl extends Conexion{
    
    public void registrar(RegistroModel reg) throws Exception{
        String sql ="EXEC spInsertRegistro ?, ?";
        
        try {
            conectar();
            System.out.println(reg.toString());
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, reg.getCERTREG());
            ps.setInt(2, reg.getCODPAR());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Registro - Error en registrarDao: "+ e.getMessage());
        }finally{
            this.cerrarCnx();
        }
    }
    
    public void registrarRD(RegistroDetalleModel regdet) throws Exception{
        String sql ="EXEC spInsertRegistroDetalle ?";
        try {
            conectar();
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, regdet.getCODCONF());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Registro - Error en RegistrarVDDao: "+ e.getMessage());
        }finally{
            this.cerrarCnx();
        }
    }
    
    public List<TemaModelo> listar() throws Exception{
        List<TemaModelo> lista = null;
        TemaModelo tem;
        try {
            conectar();
            String sql ="SELECT * FROM vTEMA ";
            PreparedStatement ps = this.conectar().prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while(rs.next()){
                tem = new TemaModelo();
                tem.setBloque(rs.getString("Bloque"));
                tem.setTema(rs.getString("Tema"));
                tem.setPonente(rs.getString("Ponente"));
                lista.add(tem);
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