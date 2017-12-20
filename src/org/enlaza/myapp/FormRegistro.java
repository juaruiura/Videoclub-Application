/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.enlaza.myapp;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import static com.codename1.ui.layouts.BoxLayout.Y_AXIS;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.simple.JSONObject;

/**
 * GUI builder created Form
 *
 * @author AlumnoTarde
 */
public class FormRegistro extends com.codename1.ui.Form {

    public FormRegistro() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        //Change layout from Layered to Box
        this.setLayout(new BoxLayout(Y_AXIS));
        //Navigation between login and register form
        this.getToolbar().addMaterialCommandToSideMenu("Login", FontImage.MATERIAL_PEOPLE, e -> showLogin());
        this.getToolbar().addMaterialCommandToSideMenu("Registro", FontImage.MATERIAL_PEOPLE, e -> showRegistro());
    }
    
    public FormRegistro(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_usuarioTextField = new com.codename1.ui.TextField();
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_passwordTextField = new com.codename1.ui.TextField();
    private com.codename1.ui.Button gui_buttonRegistrar = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_buttonRegistrar.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();

            if(sourceComponent.getParent().getLeadParent() != null && (sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.MultiButton || sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.SpanButton)) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_buttonRegistrar) {
                onbuttonRegistrarActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Registro");
        setName("FormRegistro");
        addComponent(gui_Label);
        addComponent(gui_usuarioTextField);
        addComponent(gui_Label_1);
        addComponent(gui_passwordTextField);
        addComponent(gui_buttonRegistrar);
        gui_Label.setText("Usuario:");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "12.973761% auto auto 29.845423%").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
                gui_usuarioTextField.setInlineStylesTheme(resourceObjectInstance);
        gui_usuarioTextField.setName("usuarioTextField");
        ((com.codename1.ui.layouts.LayeredLayout)gui_usuarioTextField.getParent().getLayout()).setInsets(gui_usuarioTextField, "2.9100513mm auto auto 23.424494%").setReferenceComponents(gui_usuarioTextField, "0 -1 -1 -1").setReferencePositions(gui_usuarioTextField, "1.0 0.0 0.0 0.0");
        gui_Label_1.setText("Contrase\u00F1a:");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setName("Label_1");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "26.38484% auto auto 29.488705%").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
                gui_passwordTextField.setInlineStylesTheme(resourceObjectInstance);
        gui_passwordTextField.setName("passwordTextField");
        ((com.codename1.ui.layouts.LayeredLayout)gui_passwordTextField.getParent().getLayout()).setInsets(gui_passwordTextField, "32.944607% auto auto 21.16528%").setReferenceComponents(gui_passwordTextField, "-1 -1 -1 -1").setReferencePositions(gui_passwordTextField, "0.0 0.0 0.0 0.0");
        gui_buttonRegistrar.setText("Registrarse");
                gui_buttonRegistrar.setInlineStylesTheme(resourceObjectInstance);
        gui_buttonRegistrar.setName("buttonRegistrar");
        ((com.codename1.ui.layouts.LayeredLayout)gui_buttonRegistrar.getParent().getLayout()).setInsets(gui_buttonRegistrar, "44.606415% auto auto 29.964329%").setReferenceComponents(gui_buttonRegistrar, "-1 -1 -1 -1").setReferencePositions(gui_buttonRegistrar, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    
    //Create a new user in the database
    public void registrar(Component c){
        ConnectionRequest r = new ConnectionRequest(){
            //Object that will be sent to the service
            JSONObject json = new JSONObject();

            protected void buildRequestBody(OutputStream os) throws IOException {
                //Building the json
                json.put("usuario", gui_usuarioTextField.getText());
                json.put("password", gui_passwordTextField.getText());
                //Sending json to API
                os.write(json.toString().getBytes("UTF-8"));
                new Dialog().show("", "Te has registrado con éxito.", "OK", "Cancelar");
            }
            
            @Override
            protected void readResponse(InputStream input) throws IOException {
                
            }
        };
        r.setUrl("http://localhost:8080/Videoclub/webresources/usuario/post");
        r.setPost(true);
        r.setContentType("application/json");
        NetworkManager.getInstance().addToQueue(r);
    }
    
    //Method to check if the inputs are empty. In case they are, return false, otherwise, returns true
    private boolean validar(){
        if(gui_usuarioTextField.getText().compareTo("")==0 || gui_passwordTextField.getText().compareTo("")==0){
            new Dialog().show("¡Uy!", "Has dejado alguno de los campos vacío.", "OK", "Cancelar");
            return false;
        }
        return true;
    }
    
    private void showLogin(){
        Form login = new FormLogin();
        login.show();
    }
    
    private void showRegistro(){
        Form registro = new FormRegistro();
        registro.show();
    }
    
    public void onbuttonRegistrarActionEvent(com.codename1.ui.events.ActionEvent ev) {
        if(validar()){
            registrar(ev.getComponent());
        }
    }

}
