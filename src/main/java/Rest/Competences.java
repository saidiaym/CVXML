package Rest;

import javax.xml.bind.annotation.XmlElement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by saidiaym on 15/04/14.
 */
public class Competences {

    Map<String,String> Competences;

    public Competences() {

       Competences= new HashMap<String, String>();
    }

    public void addCompetences(String lang, String niveau) {
        Competences.put(lang, niveau);
    }

    @XmlElement
    public List<String> getCompetences(){
        List<String> tmp = new LinkedList<String>();
        for (String str : Competences.keySet())
            tmp.add(str + ": " + Competences.get(str));
        return tmp;
    }
}
