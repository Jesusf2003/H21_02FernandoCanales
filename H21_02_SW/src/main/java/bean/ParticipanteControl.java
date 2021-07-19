package bean;

import dao.ParticipanteImpl;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;
import model.ParticipanteModel;
import servicios.ReporteParticipante;

@Named(value="participanteBean")
@SessionScoped
public class ParticipanteControl implements Serializable{
    private ParticipanteModel model;
    private ParticipanteImpl dao;
    private List<ParticipanteModel> listPar;
    
    @PostConstruct
    public void construir(){
        try {
            listar();
        } catch (Exception e) {
            System.out.println("Participante - Error en construirC: "+ e.getMessage());
        }
    }
    
    public ParticipanteControl(){
        model = new ParticipanteModel();
        dao = new ParticipanteImpl();
        listPar = new ArrayList<>();
    }
    
    public void listar(){
        try {
            listPar = dao.listar();
            limpiar();
        } catch (Exception e) {
            System.out.println("Paciente - error en ListarC: "+ e.getMessage());
        }
    }
    
    public void registrar(){
        try {
            dao.registrar(model);
            listar();
            limpiar();
        } catch (Exception e) {
            System.out.println("Paciente - Error en RegistrarC: "+ e.getMessage());
        }
    }
    
    public void eliminar(){
        try {
            dao.eliminar(model);
            listar();
        } catch (Exception e) {
            System.out.println("Paciente - Error en EliminarC: "+ e.getMessage());
        }
    }
    
    public void modificar(){
        try {
            dao.modificar(model);
            listar();
            limpiar();
        } catch (Exception e) {
            System.out.println("Paciente - Error en ModificarC: "+ e.getMessage());
        }
    }
    
    public void verReportePDFEST()throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        model.setTIPPAR("Estudiante");
        ReporteParticipante rParticipante = new ReporteParticipante();
        FacesContext facescontext = FacesContext.getCurrentInstance();
        ServletContext servletcontext = (ServletContext) facescontext.getExternalContext().getContext();
        String root = servletcontext.getRealPath("reportes/tipoParticipante.jasper");
        String numeroinformesocial = String.valueOf(model.getTIPPAR());
        System.out.println("El tipo de estudiante es: "+ numeroinformesocial);
        rParticipante.getReportePdf(root, numeroinformesocial);
        FacesContext.getCurrentInstance().responseComplete();
    }
    
    public void verReportePDFEGR()throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        model.setTIPPAR("Egresado");
        ReporteParticipante rParticipante = new ReporteParticipante();
        FacesContext facescontext = FacesContext.getCurrentInstance();
        ServletContext servletcontext = (ServletContext) facescontext.getExternalContext().getContext();
        String root = servletcontext.getRealPath("reportes/tipoParticipante.jasper");
        String numeroinformesocial = String.valueOf(model.getTIPPAR());
        System.out.println("El tipo de estudiante es: "+ numeroinformesocial);
        rParticipante.getReportePdf(root, numeroinformesocial);
        FacesContext.getCurrentInstance().responseComplete();
    }
    
    public void verReportePDFPUB()throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
        model.setTIPPAR("Público General");
        ReporteParticipante rParticipante = new ReporteParticipante();
        FacesContext facescontext = FacesContext.getCurrentInstance();
        ServletContext servletcontext = (ServletContext) facescontext.getExternalContext().getContext();
        String root = servletcontext.getRealPath("reportes/tipoParticipante.jasper");
        String numeroinformesocial = String.valueOf(model.getTIPPAR());
        System.out.println("El tipo de estudiante es: "+ numeroinformesocial);
        rParticipante.getReportePdf(root, numeroinformesocial);
        FacesContext.getCurrentInstance().responseComplete();
    }
    
    public void datos(ParticipanteModel par){
        this.model = par;
    }
    
    public void limpiar(){
        model = new ParticipanteModel();
    }

    public ParticipanteModel getModel() {
        return model;
    }

    public void setModel(ParticipanteModel model) {
        this.model = model;
    }

    public ParticipanteImpl getDao() {
        return dao;
    }

    public void setDao(ParticipanteImpl dao) {
        this.dao = dao;
    }

    public List<ParticipanteModel> getListPar() {
        return listPar;
    }

    public void setListPar(List<ParticipanteModel> listPar) {
        this.listPar = listPar;
    }
}