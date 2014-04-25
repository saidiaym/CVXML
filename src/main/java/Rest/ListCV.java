package Rest;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by saidiaym on 25/04/14.
 */
@XmlRootElement
public class ListCV {

    List<Resume> CVS =  new LinkedList<Resume>();

   @XmlElement
    public List<Resume> getCVS(){
        return CVS;

    }


}
