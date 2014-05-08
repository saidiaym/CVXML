package Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by saidiaym on 08/04/14.
 */


@Controller
@RequestMapping("/Resume")
public class ResumeController {

    public ResumeList resumeList;
    public Resume resume, resume1;
    public ResumeLangue la;
    public ResumeLoisirs lo;
    public ResumeCompetences Co;
    public ResumeExperiences E;
    public ResumeAdresse addr;
    @Autowired
    public void setResume(){

        la = new ResumeLangue();
        Co = new ResumeCompetences();
        lo = new ResumeLoisirs();
        E = new ResumeExperiences();
        addr = new ResumeAdresse();

        la.addLangue("Anglais", "Moyen");
        la.addLangue("Français", "Bon niveau");
        la.addLangue("Chinois", "Bas");
        la.addLangue("Espagnol", "Bas");

        lo.addLoisir("nage");


        E.addExperience("Stage", "moyen");
        E.addExperience("projet", "intermediaire");

        Co.addCompetences("java", "excellent");
        Co.addCompetences("xml", "intermediaire");

        addr.addResumeAdresse("numero :125 Rue Monnet , Ville :Rouen");


        resume = new Resume ("cvil","ILYES","NSAMAIL" ,"CV",addr,la,lo,E,Co);
        resume1= new Resume("cvxav","XAVIER", "LAROCHE","CV",addr,la,lo,E,Co);
        resumeList = new ResumeList();

        resumeList.CVS.add(resume);
        resumeList.CVS.add(resume1);

    }
    @RequestMapping(value="", method = RequestMethod.GET )
    public @ResponseBody
    ResumeList getListInXML() {



        return resumeList;


    }
    @RequestMapping(value="{identifiant}", method = RequestMethod.GET)
    public @ResponseBody
    Resume getResumeWithID(@PathVariable String identifiant) {


        for (int i=0;i< resumeList.CVS.size();i++)
        {

            if(resumeList.CVS.get(i).getIdentifiant().equals(identifiant)){

                return resumeList.CVS.get(i);
            }
        }

        return  null;


    }
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public String putcv(@RequestBody Resume resume){
        String id = resume.getIdentifiant();
        for (int i=0;i< resumeList.CVS.size();i++)
        {

            if(resumeList.CVS.get(i).getIdentifiant().equals(id)){

                return "Ce cv existe deja";
            }
        }
      resumeList.CVS.add(resume);
        return "CV ajouter au serveur";
    }






}
