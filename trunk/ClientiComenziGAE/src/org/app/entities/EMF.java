package org.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMF {
    private static final EntityManagerFactory emfInstance =
        Persistence.createEntityManagerFactory("transactions-optional");

    private EMF() {}

    public static EntityManagerFactory get() {
        return emfInstance;
    }
    
    /***************/
    private static final EntityManager emInstance = get().createEntityManager();
    public static EntityManager getEntityManager(){
    	return emInstance;
    }
}
/*
http://www.vogella.com/blog/2011/01/10/google-app-engine-jpa/
https://developers.google.com/appengine/docs/java/datastore/jpa/overview-dn2
http://www.datanucleus.org/products/accessplatform_3_0/jdo/transaction_types.html

http://localhost:8888/faces/FormClienti.xhtml
*/