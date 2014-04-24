package Rest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

/**
 * Created by saidiaym on 15/04/14.
 */
public class ResumeLangue {

    List<String> lang;

    public ResumeLangue() {
        this.lang = new LinkedList<String>();
    }

    public void addLangue(String lang, String niveau) {
        this.lang.add(lang + ": " +niveau);
    }

    @XmlElement
    public  List<String> getLangue(){
        return this.lang;
    }

}

