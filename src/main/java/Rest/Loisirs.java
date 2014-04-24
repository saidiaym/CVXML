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

    List<String> mesloisirs;

    public Loisirs() {
        this.mesloisirs = new LinkedList<String>();
    }

    public void addLoisir(String lang, String niveau) {
        this.mesloisirs.add(lang + ": " + niveau);
    }

    @XmlElement
    public  List<String> getLoisir(){
        return this.mesloisirs;
    }
}
