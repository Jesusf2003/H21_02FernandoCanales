package bean;

import dao.RegistroImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.inject.Named;
import model.RegistroDetalleModel;
import model.RegistroModel;
import model.TemaModelo;

@Named(value="registrarBean")
@SessionScoped
public class RegistrarControl implements Serializable{
    
    private RegistroImpl dao;
    private RegistroModel model;
    private List<RegistroModel> listreg;
    
    private RegistroDetalleModel modelRD;
    private List<RegistroDetalleModel> listregdet;
    
    private List<String> cities;
    private List<SelectItem> countries;
    private String[] selectedCities;
    
    public RegistrarControl(){
        model = new RegistroModel();
        dao = new RegistroImpl();
        listreg = new ArrayList<>();
        
        modelRD = new RegistroDetalleModel();
        listregdet = new ArrayList<>();
    }
    
    @PostConstruct
    public void init() {
        listregdet = new ArrayList<>();
//        listregdet.add("Ciberseguridad");
//        listregdet.add("Transformación Digital");
//        listregdet.add("Desarrollo de Software Empresarial");
    }
    
    public void registrar(){
        try {
            dao.registrar(model);
            dao.registrarRD(modelRD);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registró correctamente"));
        } catch (Exception e) {
            System.out.println("Registro - Error en RegistrarC: "+ e.getMessage());
        }
    }
    
    public void listar(){
        try {
            limpiar();
        } catch (Exception e) {
            System.out.println("registro - Error en listarC: "+ e.getMessage());
        }
    }
    
    public void datos(RegistroModel reg){
        this.model = reg;
    }
    
    public void limpiar(){
        model = new RegistroModel();
        modelRD = new RegistroDetalleModel();
    }

    public RegistroImpl getDao() {
        return dao;
    }

    public void setDao(RegistroImpl dao) {
        this.dao = dao;
    }

    public RegistroModel getModel() {
        return model;
    }

    public void setModel(RegistroModel model) {
        this.model = model;
    }

    public List<RegistroModel> getListreg() {
        return listreg;
    }

    public void setListreg(List<RegistroModel> listreg) {
        this.listreg = listreg;
    }

    public RegistroDetalleModel getModelRD() {
        return modelRD;
    }

    public void setModelRD(RegistroDetalleModel modelRD) {
        this.modelRD = modelRD;
    }

    public List<RegistroDetalleModel> getListregdet() {
        return listregdet;
    }

    public void setListregdet(List<RegistroDetalleModel> listregdet) {
        this.listregdet = listregdet;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public List<SelectItem> getCountries() {
        return countries;
    }

    public void setCountries(List<SelectItem> countries) {
        this.countries = countries;
    }

    public String[] getSelectedCities() {
        return selectedCities;
    }

    public void setSelectedCities(String[] selectedCities) {
        this.selectedCities = selectedCities;
    }
    
}