package br.org.ons.EssentialServices.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.HashMap;

import br.org.ons.EssentialServices.model.ApplicationProvider;
import br.org.ons.EssentialServices.model.iEntity;

public class ApplicationProviderRepository {
    private String repositoryName;
    private String essentialProjectPath;

    public ApplicationProviderRepository(String projectPath, String repositoryName) {
        this.essentialProjectPath = projectPath;
        this.repositoryName = repositoryName;
    }

    public Collection<iEntity> getSimpleApplicationProviders() throws Exception{
        Collection<iEntity> applicationProviders = new ArrayList<iEntity>();
        EssentialRepository essential = new EssentialRepository(this.essentialProjectPath);
        
        ArrayList<String> slotList = ApplicationProvider.getSimpleTags();
        
        Collection<HashMap<String,Object>> instances = essential.getObjInstances("Application_Provider", slotList);
        Iterator<HashMap<String,Object>> instancesI = instances.iterator();
        while (instancesI.hasNext()) {
            HashMap<String,Object> map = instancesI.next();
            ApplicationProvider applicationProvider = new ApplicationProvider(map);
            applicationProviders.add(applicationProvider);
        }
        return applicationProviders;
    }
}