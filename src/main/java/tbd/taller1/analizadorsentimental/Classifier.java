package tbd.taller1.analizadorsentimental;

import opennlp.tools.doccat.*;
import opennlp.tools.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Classifier {
    private DoccatModel model;
    private DocumentCategorizerME categorizer;

    @Autowired
    private ResourceLoader resourceLoader;

    public DoccatModel getModel() {
        return model;
    }

    public void setModel(DoccatModel model) {
        this.model = model;
    }

    @PostConstruct
    public void train() {
        InputStreamFactory dataIn=null;
        try {
            FeatureGenerator[] def = { new BagOfWordsFeatureGenerator() };
            DoccatFactory factory=new DoccatFactory(def);

            Resource resource=resourceLoader.getResource("classpath:tweets.txt");
            File tweets=resource.getFile();

            dataIn=new MarkableFileInputStreamFactory(tweets);
            ObjectStream<String> lineStream=new PlainTextByLineStream(dataIn,StandardCharsets.UTF_8);
            ObjectStream<DocumentSample> sampleStream=new DocumentSampleStream(lineStream);

            TrainingParameters params = TrainingParameters.defaultParams();
            params.put(TrainingParameters.CUTOFF_PARAM, Integer.toString(0));
            params.put(TrainingParameters.ITERATIONS_PARAM, Integer.toString(100));

            this.model=DocumentCategorizerME.train("es",sampleStream,params,factory);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.categorizer=new DocumentCategorizerME(this.model);
    }

    public double[] classify(String tweet){
        String[] words=tweet.replaceAll("[^A-Za-z]"," ").split(" ");
        double[] prob=categorizer.categorize(words);

        int tipoDeValorizacion= 99; // Se devuelve 9999 no entro en if
        //Positiva = 1
        //Neutra = 0
        //Negativa = -1

        double[] infoAnalisis = new double[3];
        double probabilidadNegativa = prob[1];

        if(probabilidadNegativa <= 0.4){ tipoDeValorizacion= 1;}
        else if(probabilidadNegativa > 0.4 && probabilidadNegativa < 0.6){tipoDeValorizacion=0;}
        else if(probabilidadNegativa >= 0.6){tipoDeValorizacion=-1;}

        infoAnalisis[0] =tipoDeValorizacion;
        infoAnalisis[1] = prob[0];
        infoAnalisis[2] = prob[1];

        return infoAnalisis;
    }
}
