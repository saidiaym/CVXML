package Rest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by saidiaym on 08/04/14.
 */
@XmlRootElement
public class Resume {

    private  String name;
    private String nom;
    private String Prenom;
    public ResumeLangue langue;

    public Resume(String Prenom,String Nom,String Name) {

        this.nom = Nom;
        this.Prenom = Prenom;
        this.name = Name;
        this.langue = new ResumeLangue();

        langue.addLangue("Anglais", "Moyen");
        langue.addLangue("Français", "Bon niveau");
        langue.addLangue("Chinois", "Bas");
        langue.addLangue("Espagnol", "Bas");

    }
    public Resume(){

    }

    @XmlElement
    public  String  getName(){
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    @XmlElement
    public String getNom(){

        return nom;
    }

    public void setNom(String n) {
        this.nom = n;
    }

    @XmlElement
    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom (String p) {
        this.Prenom = p;
    }

    @XmlElement
    public ResumeLangue getLangues(){
        return this.langue;
    }

    public void setLangues(ResumeLangue rl) {
        this.langue = rl;
    }

}
