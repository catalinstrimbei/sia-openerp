package org.open.erp.ui.proman;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class UserBean {
/*
 * RichFaces nu merge fara  <h:head></h:head>
 */

    public List<String> autocomplete(String prefix) {

        ArrayList<String> result = new ArrayList<String>();
        result.add("England");
        result.add("France");
        result.add("Germany");
        result.add("Italy");
        result.add("Spain");

        return result;
    }

    private String name;

    private String state;

    public String getState() {
        return state;
    }

    public String getName() {
        return name;
    }

}
