package tbd.taller1.analizadorsentimental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/analizar")
public class ServicioAnalizadorSentimental {

    @Autowired
    private Classifier classifier;

    @RequestMapping(method = RequestMethod.GET)
    public String classify(@RequestParam(value="text") String text) {

        double[] resultSentimentalTweet = this.classifier.classify(text);

        if(resultSentimentalTweet[0] == 1){

            System.out.println("Tweet Positivo\n");
            return "##Tweet Positivo\n porcentaje Positivo:"+resultSentimentalTweet[1]+"\nporcentaje Negativo:"+resultSentimentalTweet[2]+"\n" ;
        }
        else if(resultSentimentalTweet[0] == 0){

            System.out.println("Tweet Neutro\n");
            return "##Tweet Neutro\n porcentaje Positivo:"+resultSentimentalTweet[1]+"\nporcentaje Negativo:"+resultSentimentalTweet[2]+"\n" ;
        }
        else if(resultSentimentalTweet[0] == -1){

            System.out.println("Tweet Negativo\n");
            return "##Tweet Negativo\n porcentaje Positivo:"+resultSentimentalTweet[1]+"\nporcentaje Negativo:"+resultSentimentalTweet[2]+"\n\n" ;
        }
        return "ALERTA NO ENTRE CORRECTAMENTE EN IF 'classify'";
    }
    public Classifier getClassifier() {
        return classifier;
    }
    public void setClassifier(Classifier classifier) {
        this.classifier = classifier;
    }
}
