package Rest;

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

            /*Map<Integer,String> CompetencesProf = new HashMap<Integer, String>();
            Map<Integer,String> Experiences = new HashMap<Integer, String>();
            Map <Integer,String> Loisirs =  new HashMap<Integer, String>();
            Map<Integer,String> Langues = new HashMap<Integer, String>();*/

    @RequestMapping(value="{name}", method = RequestMethod.GET)
    public @ResponseBody Resume getCoffeeInXML(@PathVariable String name) {


            /*CompetencesProf.put(1,"developpementWeb");
            Experiences.put(1,"stage de 2mois a la societé Agoris");
            Loisirs.put(1,"Football");
            Langues.put(1,"arab");
            Langues.put(2,"Francais");*/

       Resume resume = new Resume ("saidi","ayman" ,"CV");

        return resume;

    }


}
