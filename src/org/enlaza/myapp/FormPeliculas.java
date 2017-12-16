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
import java.util.Hashtable;
import java.util.Map;

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
    private com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button.addActionListener(callback);
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

            if(sourceComponent == gui_Button) {
                onButtonActionEvent(ev);
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
        addComponent(gui_Button);
        gui_Button.setText("Listar pel\u00EDculas");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setName("Button");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button.getParent().getLayout()).setInsets(gui_Button, "9.259259mm auto auto 36.27204%").setReferenceComponents(gui_Button, "-1 -1 -1 -1").setReferencePositions(gui_Button, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    
    public void mostrarDatos(Component c){
        ConnectionRequest r = new ConnectionRequest(){
            Map<String, Object> data;
            @Override
            protected void postResponse() {
//                super.postResponse(); //To change body of generated methods, choose Tools | Templates.
                listPeliculas.removeAll();
                c.getComponentForm().revalidate();
                java.util.List<Map<String, Object>> content = (java.util.List<Map<String, Object>>)data.get("root");
                for(Map<String, Object> obj : content) {
                    String titulo = (String)obj.get("titulo");
                    String genero = (String)obj.get("genero");
                    Container row = new Container(new BoxLayout(X_AXIS));
                    row.addComponent(new Button("Borrar"));
                    row.addComponent(new Button("Editar"));
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
//                super.readResponse(input); //To change body of generated methods, choose Tools | Templates.
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
    
    public void onButtonActionEvent(com.codename1.ui.events.ActionEvent ev) {
        mostrarDatos(ev.getComponent());
    }

}
