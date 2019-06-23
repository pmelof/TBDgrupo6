package tbd.taller1.analizadorsentimental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.elasticsearch.search.aggregations.Aggregation.CommonFields.VALUES;


@RestController
@RequestMapping("/analizar")
public class ServicioAnalizadorSentimental {

    @Autowired
    private Classifier classifier;

    @RequestMapping(method = RequestMethod.GET)
    public int classify(@RequestParam(value="text") String text) {

        double[] resultSentimentalTweet = this.classifier.classify(text);
        //System.out.println("Positivo:"+resultSentimentalTweet[1]);
        //System.out.println("Negativo:"+resultSentimentalTweet[2]);


        if(resultSentimentalTweet[0] == 1){

            //System.out.println("Tweet Positivo\n");

            return 1;
            //return "##Tweet Positivo\n porcentaje Positivo:"+resultSentimentalTweet[1]+"\nporcentaje Negativo:"+resultSentimentalTweet[2]+"\n" ;
        }
        else if(resultSentimentalTweet[0] == 0){

            //System.out.println("Tweet Neutro\n");
            //return "##Tweet Neutro\n porcentaje Positivo:"+resultSentimentalTweet[1]+"\nporcentaje Negativo:"+resultSentimentalTweet[2]+"\n" ;
            return 0;
        }
        else if(resultSentimentalTweet[0] == -1){

            //System.out.println("Tweet Negativo\n");
            //return "##Tweet Negativo\n porcentaje Positivo:"+resultSentimentalTweet[1]+"\nporcentaje Negativo:"+resultSentimentalTweet[2]+"\n\n" ;

            return -1;
        }
        //return "ALERTA NO ENTRE CORRECTAMENTE EN IF 'classify'";



        return 99;
    }
    public Classifier getClassifier() {
        return classifier;
    }
    public void setClassifier(Classifier classifier) {
        this.classifier = classifier;
    }
}
