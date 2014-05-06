package Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping(value="/all", method = RequestMethod.GET )
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

    @RequestMapping(value="{identifiant}/{nom}/{prenom}/{mail}/adresse/{ad}/competences/{c1}/{nc1}/{c2}/{nc2}" +
            "/experiences/{e1}/{ne1}/{e2}/{ne2}/langues/{l1}/{nl1}/{l2}/{nl2}" +
            "/loisirs/{lo1}", method = RequestMethod.GET)
    public @ResponseBody
    ResumeList  putCVInXML(@PathVariable String identifiant, @PathVariable String nom, @PathVariable String prenom, @PathVariable String mail,@PathVariable String ad,
                          @PathVariable String c1, @PathVariable String nc1, @PathVariable String c2, @PathVariable String nc2,
                          @PathVariable String e1, @PathVariable String ne1, @PathVariable String e2, @PathVariable String ne2,
                          @PathVariable String l1, @PathVariable String nl1, @PathVariable String l2, @PathVariable String nl2,
                          @PathVariable String lo1) {

        ResumeCompetences Rcomp = new ResumeCompetences();
        ResumeExperiences Rexp = new ResumeExperiences();
        ResumeLangue Rlangue = new ResumeLangue();
        ResumeLoisirs Rloisirs = new ResumeLoisirs();
        ResumeAdresse Radresse = new ResumeAdresse();
        Radresse.addResumeAdresse(ad);
        Rcomp.addCompetences(c1,nc1);
        Rcomp.addCompetences(c2,nc2);
        Rexp.addExperience(e1, ne1);
        Rexp.addExperience(e2,ne2);
        Rlangue.addLangue(l1, nl1);
        Rlangue.addLangue(l2,nl2);
        Rloisirs.addLoisir(lo1);

        Resume cv= new Resume(identifiant,nom,prenom,mail,Radresse, Rlangue,Rloisirs,Rexp,Rcomp);
        resumeList.CVS.add(cv);
        return resumeList;


    }

}
