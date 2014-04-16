package Rest;

import javax.xml.bind.annotation.XmlElement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by saidiaym on 15/04/14.
 */
public class Loisirs {

    Map<String,String> Loisirs;

    public Loisirs() {

        Loisirs= new HashMap<String, String>();
    }

    public void addLoisirs(String lang, String niveau) {
       Loisirs.put(lang, niveau);
    }

    @XmlElement
    public List<String> getLoisirs(){
        List<String> tmp = new LinkedList<String>();
        for (String str : Loisirs.keySet())
            tmp.add(str + ": " + Loisirs.get(str));
        return tmp;
    }
}
