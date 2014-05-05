package Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by saidiaym on 08/04/14.
 */


@Controller
@RequestMapping("/Resume")
public class ResumeController {

    public ListCV listCV;
    public Resume resume, resume1;
    public ResumeLangue la;
    public Loisirs lo;
    public ResumeCompetences Co;
    public Experiences E;

    @Autowired
    public void setResume(){

        la = new ResumeLangue();
        Co = new ResumeCompetences();
        lo = new Loisirs();
        E = new Experiences();

        la.addLangue("Anglais", "Moyen");
        la.addLangue("Français", "Bon niveau");
        la.addLangue("Chinois", "Bas");
        la.addLangue("Espagnol", "Bas");

        lo.addLoisir("nage", "excellent");
        lo.addLoisir("football", "moyen");

        E.addExperience("Stage", "moyen");
        E.addExperience("projet", "intermediaire");

        Co.addCompetences("java", "excellent");
        Co.addCompetences("xml", "intermediaire");


        resume = new Resume ("ILYES","NSAMAIL" ,"CV",la,lo,E,Co);
        resume1= new Resume("XAVIER", "LAROCHE","CV",la,lo,E,Co);
        listCV = new ListCV();

        listCV.CVS.add(resume);
        listCV.CVS.add(resume1);

    }
    @RequestMapping( method = RequestMethod.GET ,params = "list")
    public @ResponseBody
    ListCV getListInXML() {



        return listCV;


    }
    @RequestMapping(value="{name}", method = RequestMethod.GET)
    public @ResponseBody
    Resume getCVInXML(@PathVariable String name) {
        //Iterator iterator=listCV.resumeList.iterator();
        Resume resume2;
        for (int i=0;i<listCV.CVS.size();i++)
        {
            //resume2 =listCV.resumeList.get(i);
            if(listCV.CVS.get(i).getNom().equals(name)){

                return listCV.CVS.get(i);
            }
        }
        // resume2 =listCV.resumeList.get(1);
        return  null;




    }

    @RequestMapping(value="{name}/{nom}/{prenom}", method = RequestMethod.GET)
    public @ResponseBody
    ListCV putCVInXML(@PathVariable String name, @PathVariable String nom, @PathVariable String prenom) {


        Resume resume3= new Resume(nom,prenom,name,la,lo,E,Co);
        listCV.CVS.add(resume3);
        return listCV;


    }

}
