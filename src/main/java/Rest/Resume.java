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
    public ResumeCompetences Competences;
    public Loisirs Lois;
    public Experiences resumeExperiences;

    public Resume(String Prenom,String Nom,String Name) {

        this.nom = Nom;
        this.Prenom = Prenom;
        this.name = Name;
        this.Lois = new Loisirs();
        this.Competences = new ResumeCompetences();
        this.resumeExperiences = new Experiences();
        this.langue = new ResumeLangue();



        Competences.addCompetences("php","niveau bien");
        Competences.addCompetences("java","haut niveau");


        langue.addLangue("Anglais", "Moyen");
        langue.addLangue("Français", "Bon niveau");
        langue.addLangue("Chinois", "Bas");
        langue.addLangue("Espagnol", "Bas");


        Lois.addLoisir("Sport", "ssss");
        Lois.addLoisir("NATATION","DDD");
        Lois.addLoisir("la pech","d");

        resumeExperiences.addExperience("stage dans la societé Tunisie Telecom","6 mois");
        resumeExperiences.addExperience("stage dans la societé agoris","2 mois");
        resumeExperiences.addExperience("stage dans la societé SICEM","4 mois");
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
/*
    @XmlElement
    public ResumeLangue getLangues(){
        return this.langue;
    }

    public void setLangues(ResumeLangue rl) {
        this.langue = rl;
    }
*/
}