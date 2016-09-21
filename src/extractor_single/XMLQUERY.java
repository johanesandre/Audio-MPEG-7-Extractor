package extractor_single;

import org.basex.core.*;
import org.basex.core.cmd.*;
import org.basex.io.serial.*;
import org.basex.query.*;
import org.basex.query.iter.*;
import org.basex.query.value.*;
import org.basex.query.value.item.*;

import java.io.IOException;


public class XMLQUERY {

    static Context context = new Context();
    /*
    public static void main(String[] args) throws IOException, QueryException, BaseXException{
//        System.out.println("Audio Signature Type:");
        String string;
        string =AudioSpectrumProjectionType().trim();
        //string = AudioSpectrumEnvelopeType().trim();
        String[] hasil = string.split("&#xD;");
        for(int i = 0 ; i<hasil.length;i++){
            System.out.print(hasil[i].trim().replace(" ",","));
            if(i != hasil.length-1)
                System.out.print(",");
        }
    }
    */
   public static String[] AudioSpectrumEnvelopeType(String path) throws BaseXException{

        /*String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"coba+\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioSpectrumEnvelopeType\")then data($x/SeriesOfVector/Raw) else \"\"";
                */
       String query= "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\""+path+"\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioSpectrumEnvelopeType\")then data($x/SeriesOfVector/Raw) else \"\"";
       // System.out.println(new XQuery(query).execute(context));
       String hasil = new XQuery(query).execute(context);
       String[] hasil1 = hasil.split("&#xD;");
        for(int i = 0 ; i<hasil1.length;i++){
            System.out.print(hasil1[i].trim().replace(" ",","));
            if(i != hasil1.length-1)
                System.out.print(",");
        }
       return hasil1;
    }
    public static String[] AudioSpectrumProjectionType(String path) throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\""+path+"\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioSpectrumProjectionType\")then data($x/SeriesOfVector/Raw) else \"\"";
       String hasil = new XQuery(query).execute(context);
       String[] hasil1 = hasil.split("&#xD;");
        for(int i = 0 ; i<hasil1.length;i++){
            System.out.print(hasil1[i].trim().replace(" ",","));
            if(i != hasil1.length-1)
               System.out.print(",");
        }
       return hasil1;
    }

    
    //v
    public static String[] AudioSignatureType(String path) throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\""+path+"\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptionScheme return if($x/@xsi:type=\"AudioSignatureType\")then data($x/Flatness/SeriesOfVector/Mean) else \"\"";
        String hasil = new XQuery(query).execute(context);
       String[] hasil1 = hasil.split("&#xD;");
        for(int i = 0 ; i<hasil1.length;i++){
            System.out.print(hasil1[i].trim().replace(" ",","));
            if(i != hasil1.length-1)
               System.out.print(",");
        }
       return hasil1;
    }

    //v
    public static String[] AudioFundamentalFrequencyType(String path) throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\""+path+"\")/Mpeg7/Description/MultimediaContent/Audio return if($x/AudioDescriptor/@xsi:type=\"AudioFundamentalFrequencyType\")then data($x/AudioDescriptor/SeriesOfScalar/Raw) else \"\"";
         String hasil = new XQuery(query).execute(context);
       String[] hasil1 = hasil.split("&#xD;");
        for(int i = 0 ; i<hasil1.length;i++){
            System.out.print(hasil1[i].trim().replace(" ",","));
            if(i != hasil1.length-1)
               System.out.print(",");
        }
       return hasil1;
    }


    //v
    public static String[] AudioHarmonicityType(String path) throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\""+path+"\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioHarmonicityType\")then data($x/HarmonicRatio/SeriesOfScalar/Raw) else \"\"";

    String hasil = new XQuery(query).execute(context);
       String[] hasil1 = hasil.split("&#xD;");
        for(int i = 0 ; i<hasil1.length;i++){
            System.out.print(hasil1[i].trim().replace(" ",","));
            if(i != hasil1.length-1)
               System.out.print(",");
        }
       return hasil1;
        //System.out.println(new XQuery(query).execute(context));
    }


    //v
    public  static String[] AudioPowerType(String path) throws BaseXException{
        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\""+path+"\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioPowerType\")then data($x/SeriesOfScalar/Raw) else \"\"";

         String hasil = new XQuery(query).execute(context);
       String[] hasil1 = hasil.split("&#xD;");
        for(int i = 0 ; i<hasil1.length;i++){
            System.out.print(hasil1[i].trim().replace(" ",","));
            if(i != hasil1.length-1)
               System.out.print(",");
        }
       return hasil1;
        //System.out.println(new XQuery(query).execute(context));
    }

    public static String[] AudioSpectrumBasisType(String path) throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\""+path+"\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioSpectrumBasisType\")then data($x/SeriesOfVector/Raw) else \"\"";

       String hasil = new XQuery(query).execute(context);
       String[] hasil1 = hasil.split("&#xD;");
        for(int i = 0 ; i<hasil1.length;i++){
            System.out.print(hasil1[i].trim().replace(" ",","));
            if(i != hasil1.length-1)
               System.out.print(",");
        }
       return hasil1;
    }


    //v
    public static String[] AudioSpectrumCentroidType(String path) throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\""+path+"\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioSpectrumCentroidType\")then data($x/SeriesOfScalar/Raw) else \"\"";

     String hasil = new XQuery(query).execute(context);
       String[] hasil1 = hasil.split("&#xD;");
        for(int i = 0 ; i<hasil1.length;i++){
            System.out.print(hasil1[i].trim().replace(" ",","));
            if(i != hasil1.length-1)
               System.out.print(",");
        }
       return hasil1;
        //System.out.println(new XQuery(query).execute(context));
    }


    public  static String[] AudioSpectrumFlatnessType(String path) throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\""+path+"\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioSpectrumFlatnessType\")then data($x/SeriesOfVector/Raw) else \"\"";
 String hasil = new XQuery(query).execute(context);
       String[] hasil1 = hasil.split("&#xD;");
        for(int i = 0 ; i<hasil1.length;i++){
            System.out.print(hasil1[i].trim().replace(" ",","));
            if(i != hasil1.length-1)
               System.out.print(",");
        }
       return hasil1;
    }

    //v
    public static String[] AudioSpectrumSpreadType(String path) throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\""+path+"\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioSpectrumSpreadType\")then data($x/SeriesOfScalar/Raw) else \"\"";

 String hasil = new XQuery(query).execute(context);
       String[] hasil1 = hasil.split("&#xD;");
        for(int i = 0 ; i<hasil1.length;i++){
            System.out.print(hasil1[i].trim().replace(" ",","));
            if(i != hasil1.length-1)
               System.out.print(",");
        }
       return hasil1;
        //System.out.println(new XQuery(query).execute(context));
    }
    public static String[] HarmonicSpectralCentroidType(String path) throws BaseXException{
        //String jajal = "D:\Lagu Extract\Coba\Classic\Mozzart-Andate from  Piano Concerto no 21.xml";
        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\""+path+"\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"HarmonicSpectralCentroidType\")then data($x/Scalar) else \"\"";

 String hasil = new XQuery(query).execute(context);
       String[] hasil1 = hasil.split("&#xD;");
        for(int i = 0 ; i<hasil1.length;i++){
            System.out.print(hasil1[i].trim().replace(" ",","));
            if(i != hasil1.length-1)
               System.out.print(",");
        }
       return hasil1;
    }
        public static String[] HarmonicSpectralDeviationType(String path) throws BaseXException{
        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\""+path+"\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"HarmonicSpectralDeviationType\")then data($x/Scalar) else \"\"";

 String hasil = new XQuery(query).execute(context);
       String[] hasil1 = hasil.split("&#xD;");
        for(int i = 0 ; i<hasil1.length;i++){
            System.out.print(hasil1[i].trim().replace(" ",","));
            if(i != hasil1.length-1)
               System.out.print(",");
        }
       return hasil1;
    }
        public static String[] HarmonicSpectralDeviationSpreadType(String path) throws BaseXException{
        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\""+path+"\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"HarmonicSpectralSpreadType\")then data($x/Scalar) else \"\"";

        //System.out.println(new XQuery(query).execute(context));
         String hasil = new XQuery(query).execute(context);
       String[] hasil1 = hasil.split("&#xD;");
        for(int i = 0 ; i<hasil1.length;i++){
            System.out.print(hasil1[i].trim().replace(" ",","));
            if(i != hasil1.length-1)
               System.out.print(",");
        }
       return hasil1;
    }
        public static String[] HarmonicSpectralVariationType(String path) throws BaseXException{
        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\""+path+"\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"HarmonicSpectralVariationType\")then data($x/Scalar) else \"\"";

        //System.out.println(new XQuery(query).execute(context));
  String hasil = new XQuery(query).execute(context);
       String[] hasil1 = hasil.split("&#xD;");
        for(int i = 0 ; i<hasil1.length;i++){
            System.out.print(hasil1[i].trim().replace(" ",","));
            if(i != hasil1.length-1)
               System.out.print(",");
        }
       return hasil1;
    }
        public static String[] SoundModel(String path) throws BaseXException{
        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\""+path+"\")/Mpeg7/Description/Model/Initial\n return if($x/@xsi:type=\"SoundModelType\")then data($x/Transitions) else \"\"";
  String hasil = new XQuery(query).execute(context);
       String[] hasil1 = hasil.split("&#xD;");
        for(int i = 0 ; i<hasil1.length;i++){
            System.out.print(hasil1[i].trim().replace(" ",","));
            if(i != hasil1.length-1)
               System.out.print(",");
        }
       return hasil1;
    }
        public static String[] AudioWaveformType(String path) throws BaseXException{
        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\""+path+"\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioWaveformType\")then data($x/SeriesOfScalar/Min) else \"\"";
        String hasil = new XQuery(query).execute(context);
       String[] hasil1 = hasil.split("&#xD;");
        for(int i = 0 ; i<hasil1.length;i++){
            System.out.print(hasil1[i].trim().replace(" ",","));
            if(i != hasil1.length-1)
               System.out.print(",");
        }
       return hasil1;
    }
        public static String[] TemporalCentroid(String path) throws BaseXException{
        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\""+path+"\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"TemporalCentroidType\")then data($x/Scalar) else \"\"";
    String hasil = new XQuery(query).execute(context);
       String[] hasil1 = hasil.split("&#xD;");
        for(int i = 0 ; i<hasil1.length;i++){
            System.out.print(hasil1[i].trim().replace(" ",","));
            if(i != hasil1.length-1)
               System.out.print(",");
        }
       return hasil1;
    }
        public static String[] LogAttackTime(String path) throws BaseXException{
        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                           "for $x in doc(\""+path+"\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"LogAttackTimeType\")then data($x/Scalar) else \"\"";
       String hasil = new XQuery(query).execute(context);
       String[] hasil1 = hasil.split("&#xD;");
        for(int i = 0 ; i<hasil1.length;i++){
            System.out.print(hasil1[i].trim().replace(" ",","));
            if(i != hasil1.length-1)
               System.out.print(",");
        }
       return hasil1;
    }
}