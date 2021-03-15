package Controlador;

import Modelo.Customer;
import Modelo.consultasCustomer;
import Vista.formCustomer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class controllerCustomer implements ActionListener{

    private Customer mod;
    private consultasCustomer modC;
    private formCustomer form;
    
    public controllerCustomer (Customer mod, consultasCustomer modC, 
            formCustomer form) {
        
        this.mod = mod;
        this.modC = modC;
        this.form = form;
        this.form.btnBuscar.addActionListener(this);
        this.form.btnGuardar.addActionListener(this);
        this.form.btnModificar.addActionListener(this);
        this.form.btnLimpiar.addActionListener(this);
        this.form.btnEliminar.addActionListener(this);
        
    }
    
    public void iniciar () {
        form.setTitle("Customers");
        form.setLocationRelativeTo(null);
        //form.txtId.setVisible(false);
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        
        if(e.getSource() == form.btnGuardar){
            mod.setName(form.txtName.getText());
            mod.setAddress(form.txtAddress.getText());
            mod.setPhone(form.txtPhone.getText());
            
            if (modC.registrar(mod)){
                JOptionPane.showMessageDialog(null, "Registro guardado");
                limpiar();
            } 
            else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }
        }
        if(e.getSource() == form.btnModificar){
            mod.setId(Integer.parseInt(form.txtId.getText()));
            mod.setName(form.txtName.getText());
            mod.setAddress(form.txtAddress.getText());
            mod.setPhone(form.txtPhone.getText());
            
            if (modC.editar(mod)){
                JOptionPane.showMessageDialog(null, "Registro modificado");
                limpiar();
            } 
            else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }
        }
        
        if(e.getSource() == form.btnEliminar){
        
            mod.setId(Integer.parseInt(form.txtId.getText()));
            
            if (modC.eliminar(mod)){
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                limpiar();
            } 
            else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
            
        }
        if(e.getSource() == form.btnBuscar){
        
            mod.setId(Integer.parseInt(form.txtId.getText()));
            
            if (modC.buscar(mod)){
                
                //form.txtId.setText(String.valueOf(mod.getId()));
                form.txtName.setText(mod.getName());
                form.txtAddress.setText(mod.getAddress());
                form.txtPhone.setText(mod.getPhone());
                
                JOptionPane.showMessageDialog(null, "Registro encontrado");
            } 
            else {
                JOptionPane.showMessageDialog(null, "Error al buscar el registro");
                limpiar();
            }
            
        }
        if(e.getSource() == form.btnLimpiar){
            
            limpiar();
                    
        }
        
    }
    
    public void limpiar () {
    
        form.txtId.setText(null);
        form.txtName.setText(null);
        form.txtAddress.setText(null);
        form.txtPhone.setText(null);
        
    }
            
}
