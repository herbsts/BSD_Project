/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import java.util.Set;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

/**
 *
 * @author schueler
 */
@javax.ws.rs.ApplicationPath("WS")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        resources.add(MultiPartFeature.class);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(webservice.PhraseDetail.class);
        resources.add(webservice.PhraseList.class);
        resources.add(webservice.RequestDetail.class);
        resources.add(webservice.RequestList.class);
        resources.add(webservice.UnitDetail.class);
        resources.add(webservice.UnitList.class);
        resources.add(webservice.UserDetail.class);
        resources.add(webservice.UserList.class);
        resources.add(webservice.WordDetail.class);
        resources.add(webservice.WordEnglish.class);
        resources.add(webservice.WordGerman.class);
    }
    
}
