package Rest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by saidiaym on 08/04/14.
 */
public class Resume {

    private  String name;
    private String nom;
    private String Prenom;

    private String  objectifs;
    private String Interets;
    Map<Integer,String> Experiences;
    Map<Integer,String> CompetencesProf;
    Map<Integer,String> Loisirs;
    Map<Integer,String> Langues;



    public Resume(String Prenom,String Nom,String Name) {

        this.nom = Nom;
        this.Prenom = Prenom;
        this.name = Name;
        CompetencesProf = new HashMap<Integer, String>();
        Experiences = new HashMap<Integer, String>();
        Loisirs =  new HashMap<Integer, String>();
        Langues = new HashMap<Integer, String>();


    }
    public Resume(){

    }
    public  String  getName(){

        return name;
    }

    public String getNom(){

        return Prenom;
    }
    public String getPrenom() {
        return Prenom;
    }
    public  String  getInterets(){

        return Interets;
    }

    public String getObjectif(){

        return objectifs;
    }



    public void setObjectifs(String Objectifs){

        this.objectifs = Objectifs;
    }
    public Map getCompetencesProf(){

            return this.CompetencesProf;
    }
    public Map Langues(){

        return this.Langues;
    }

    public Map getExperiences(){

            return this.Experiences;
    }

    public Map getLoisirs(){

        return this.Loisirs;
    }
}
