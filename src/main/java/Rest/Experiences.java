package Rest;

import javax.xml.bind.annotation.XmlElement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by saidiaym on 15/04/14.
 */
public class Experiences {
    Map<String,String> Experiences;

    public Experiences() {

        Experiences= new HashMap<String, String>();
    }

    public void addExperience(String lang, String niveau) {
        Experiences.put(lang, niveau);
    }

    @XmlElement
    public List<String> getExperience(){
        List<String> tmp = new LinkedList<String>();
        for (String str : Experiences.keySet())
            tmp.add(str + ": " + Experiences.get(str));
        return tmp;
    }

}