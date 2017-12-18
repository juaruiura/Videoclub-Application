/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.enlaza.myapp;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import static com.codename1.ui.layouts.BoxLayout.X_AXIS;
import static com.codename1.ui.layouts.BoxLayout.Y_AXIS;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Map;
import org.json.simple.JSONObject;

/**
 * GUI builder created Form
 *
 * @author Juan Manuel
 */
public class FormPeliculas extends com.codename1.ui.Form {
    
    Container listPeliculas;
    
    public FormPeliculas() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        this.setLayout(new BoxLayout(Y_AXIS));
        listPeliculas = new Container(new BoxLayout(Y_AXIS));
    }
    
    public FormPeliculas(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_tituloTextField = new com.codename1.ui.TextField();
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.TextField gui_generoTextField = new com.codename1.ui.TextField();
    private com.codename1.ui.Button gui_ButtonAlta = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_ButtonListar = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_ButtonAlta.addActionListener(callback);
        gui_ButtonListar.addActionListener(callback);
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

            if(sourceComponent == gui_ButtonAlta) {
                onButtonAltaActionEvent(ev);
            }
            if(sourceComponent == gui_ButtonListar) {
                onButtonListarActionEvent(ev);
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
        setTitle("Pel\u00EDculas");
        setName("FormPeliculas");
        addComponent(gui_Label);
        addComponent(gui_tituloTextField);
        addComponent(gui_Label_1);
        addComponent(gui_generoTextField);
        addComponent(gui_ButtonAlta);
        addComponent(gui_ButtonListar);
        gui_Label.setText("T\u00EDtulo:");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "11.275626% auto auto 34.5667%").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
                gui_tituloTextField.setInlineStylesTheme(resourceObjectInstance);
        gui_tituloTextField.setName("tituloTextField");
        ((com.codename1.ui.layouts.LayeredLayout)gui_tituloTextField.getParent().getLayout()).setInsets(gui_tituloTextField, "15.3758545% auto auto 27.361246%").setReferenceComponents(gui_tituloTextField, "-1 -1 -1 -1").setReferencePositions(gui_tituloTextField, "0.0 0.0 0.0 0.0");
        gui_Label_1.setText("G\u00E9nero:");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setName("Label_1");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "20.95672% auto auto 34.46933%").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
                gui_generoTextField.setInlineStylesTheme(resourceObjectInstance);
        gui_generoTextField.setName("generoTextField");
        ((com.codename1.ui.layouts.LayeredLayout)gui_generoTextField.getParent().getLayout()).setInsets(gui_generoTextField, "26.65148% auto auto 25.413826%").setReferenceComponents(gui_generoTextField, "-1 -1 -1 -1").setReferencePositions(gui_generoTextField, "0.0 0.0 0.0 0.0");
        gui_ButtonAlta.setText("Dar de alta");
                gui_ButtonAlta.setInlineStylesTheme(resourceObjectInstance);
        gui_ButtonAlta.setName("ButtonAlta");
        ((com.codename1.ui.layouts.LayeredLayout)gui_ButtonAlta.getParent().getLayout()).setInsets(gui_ButtonAlta, "34.05467% auto auto 33.398247%").setReferenceComponents(gui_ButtonAlta, "-1 -1 -1 -1").setReferencePositions(gui_ButtonAlta, "0.0 0.0 0.0 0.0");
        gui_ButtonListar.setText("Listar pel\u00EDculas");
                gui_ButtonListar.setInlineStylesTheme(resourceObjectInstance);
        gui_ButtonListar.setName("ButtonListar");
        ((com.codename1.ui.layouts.LayeredLayout)gui_ButtonListar.getParent().getLayout()).setInsets(gui_ButtonListar, "39.407745% auto auto 33.8851%").setReferenceComponents(gui_ButtonListar, "-1 -1 -1 -1").setReferencePositions(gui_ButtonListar, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    
    public void mostrarDatos(Component c){
        ConnectionRequest r = new ConnectionRequest(){
            Map<String, Object> data;
            @Override
            protected void postResponse() {
                listPeliculas.removeAll();
                c.getComponentForm().revalidate();
                java.util.List<Map<String, Object>> content = (java.util.List<Map<String, Object>>)data.get("root");
                Button hideListPeliculas = new Button("Esconder listado");
                hideListPeliculas.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ev) {
                        listPeliculas.removeAll();
                        c.getComponentForm().revalidate();
                    }
                });
                listPeliculas.addComponent(hideListPeliculas);
                for(Map<String, Object> obj : content) {
                    String titulo = (String)obj.get("titulo");
                    String genero = (String)obj.get("genero");
                    Container row = new Container(new BoxLayout(X_AXIS));
                    Button buttonBorrar = new Button("Borrar");
                    buttonBorrar.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent ev) {
                            borrarDatos(ev.getComponent(), titulo);
                        }
                    });
                    row.addComponent(buttonBorrar);
                    Button buttonEditar = new Button("Editar");
                    buttonEditar.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent ev) {
                            editarDatos(ev.getComponent(), titulo);
                        }
                    });
                    row.addComponent(buttonEditar);
                    listPeliculas.addComponent(new Label(titulo));
                    listPeliculas.addComponent(new Label("Género: " + genero));
                    listPeliculas.addComponent(row);
                }
                if(c.getComponentForm().contains(listPeliculas)==false)
                    c.getComponentForm().addComponent(listPeliculas);
                c.getComponentForm().revalidate();
            }

            @Override
            protected void readResponse(InputStream input) throws IOException {
                JSONParser p = new JSONParser();
                data = p.parseJSON(new InputStreamReader(input));
            }
            
        };
        r.setUrl("http://localhost:8080/Videoclub/webresources/pelicula/findAll");
        r.setPost(false);
        r.addArgument("q", "@codename-one");
        InfiniteProgress prog = new InfiniteProgress();
        Dialog diag = prog.showInifiniteBlocking();
        r.setDisposeOnCompletion(diag);
        NetworkManager.getInstance().addToQueue(r);
    }
    
    public void enviarDatos(Component c){
        ConnectionRequest r = new ConnectionRequest(){
            JSONObject json = new JSONObject();

            protected void buildRequestBody(OutputStream os) throws IOException {
                json.put("titulo", gui_tituloTextField.getText());
                json.put("genero", gui_generoTextField.getText());
                os.write(json.toString().getBytes("UTF-8"));
            }
            
            @Override
            protected void readResponse(InputStream input) throws IOException {
                
            }
        };
        r.setUrl("http://localhost:8080/Videoclub/webresources/pelicula/post");
        r.setPost(true);
        r.setContentType("application/json");
        InfiniteProgress prog = new InfiniteProgress();
        Dialog diag = prog.showInifiniteBlocking();
        r.setDisposeOnCompletion(diag);
        NetworkManager.getInstance().addToQueue(r);
    }
    
    public void borrarDatos(Component c, String id){
        ConnectionRequest r = new ConnectionRequest(){
        };
        r.setUrl("http://localhost:8080/Videoclub/webresources/pelicula/delete/"+id);
        r.setPost(false);
        r.setHttpMethod("DELETE");
        r.addArgument("q", "@codename-one");
        InfiniteProgress prog = new InfiniteProgress();
        Dialog diag = prog.showInifiniteBlocking();
        r.setDisposeOnCompletion(diag);
        NetworkManager.getInstance().addToQueue(r);
    }
    
    public void editarDatos(Component c, String id){
        ConnectionRequest r = new ConnectionRequest(){
            JSONObject json = new JSONObject();

            protected void buildRequestBody(OutputStream os) throws IOException {
                json.put("titulo", gui_tituloTextField.getText());
                json.put("genero", gui_generoTextField.getText());
                os.write(json.toString().getBytes("UTF-8"));
            }
            
            @Override
            protected void readResponse(InputStream input) throws IOException {
            }
        };
        r.setUrl("http://localhost:8080/Videoclub/webresources/pelicula/put/"+id);
        r.setContentType("application/json");
        r.setPost(true);
        r.setHttpMethod("PUT");
        InfiniteProgress prog = new InfiniteProgress();
        Dialog diag = prog.showInifiniteBlocking();
        r.setDisposeOnCompletion(diag);
        NetworkManager.getInstance().addToQueue(r);
    }
    
    public void onButtonListarActionEvent(com.codename1.ui.events.ActionEvent ev) {
        mostrarDatos(ev.getComponent());
    }

    public void onButtonAltaActionEvent(com.codename1.ui.events.ActionEvent ev) {
        enviarDatos(ev.getComponent());
    }

}
