import org.basex.core.*;
import org.basex.core.cmd.*;
import org.basex.io.serial.*;
import org.basex.query.*;
import org.basex.query.iter.*;
import org.basex.query.value.*;
import org.basex.query.value.item.*;

import java.io.IOException;


public class Main {

    static Context context = new Context();
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
   private static String AudioSpectrumEnvelopeType() throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"D:\\Lagu Extract\\Coba\\Rock\\Baru\\Michael Jackson - You Are Not Alone.xml\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioSpectrumEnvelopeType\")then data($x/SeriesOfVector/Raw) else \"\"";

       // System.out.println(new XQuery(query).execute(context));
       String hasil = new XQuery(query).execute(context);
       return hasil;
    }
    private static String AudioSpectrumProjectionType() throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"D:\\Lagu Extract\\Coba\\Rap\\1 detik baru.xml\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioSpectrumProjectionType\")then data($x/SeriesOfVector/Raw) else \"\"";
        String hasil = new XQuery(query).execute(context);
        return hasil;
    }

    
    //v
    private static String AudioSignatureType() throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"D:\\Lagu Extract\\Coba\\Classic\\Mozzart-Andate from  Piano Concerto no 21.xml\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptionScheme return if($x/@xsi:type=\"AudioSignatureType\")then data($x/Flatness/SeriesOfVector/Mean) else \"\"";
        String hasil = new XQuery(query).execute(context);
        return hasil;
        //System.out.println(hasil);
    }

    //v
    private static String AudioFundamentalFrequencyType() throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"D:\\Lagu Extract\\Coba\\Classic\\Mozzart-Andate from  Piano Concerto no 21.xml\")/Mpeg7/Description/MultimediaContent/Audio return if($x/AudioDescriptor/@xsi:type=\"AudioFundamentalFrequencyType\")then data($x/AudioDescriptor/SeriesOfScalar/Raw) else \"\"";
        String hasil = new XQuery(query).execute(context);
        return hasil;
        //System.out.println(hasil);
    }


    //v
    private static String AudioHarmonicityType() throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"D:\\Lagu Extract\\Coba\\Classic\\Mozzart-Andate from  Piano Concerto no 21.xml\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioHarmonicityType\")then data($x/HarmonicRatio/SeriesOfScalar/Raw) else \"\"";

        String hasil = new XQuery(query).execute(context);
        return hasil;
        //System.out.println(new XQuery(query).execute(context));
    }


    //v
    private  static String AudioPowerType() throws BaseXException{
        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"D:\\Lagu Extract\\Coba\\Classic\\Mozzart-Andate from  Piano Concerto no 21.xml\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioPowerType\")then data($x/SeriesOfScalar/Raw) else \"\"";

        String hasil = new XQuery(query).execute(context);
        return hasil;
        //System.out.println(new XQuery(query).execute(context));
    }

    private static String AudioSpectrumBasisType() throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"D:\\Lagu Extract\\Coba\\Classic\\Mozzart-Andate from  Piano Concerto no 21.xml\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioSpectrumBasisType\")then data($x/SeriesOfVector/Raw) else \"\"";

       // System.out.println(new XQuery(query).execute(context));
        String hasil = new XQuery(query).execute(context);
        return hasil;
    }


    //v
    private static String AudioSpectrumCentroidType() throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"D:\\Lagu Extract\\Coba\\Classic\\Mozzart-Andate from  Piano Concerto no 21.xml\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioSpectrumCentroidType\")then data($x/SeriesOfScalar/Raw) else \"\"";

        String hasil = new XQuery(query).execute(context);
        return hasil;
        //System.out.println(new XQuery(query).execute(context));
    }


    private static String AudioSpectrumFlatnessType() throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"D:\\Lagu Extract\\Coba\\Classic\\Mozzart-Andate from  Piano Concerto no 21.xml\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioSpectrumFlatnessType\")then data($x/SeriesOfVector/Raw) else \"\"";

        //System.out.println(new XQuery(query).execute(context));
        String hasil = new XQuery(query).execute(context);
        return hasil;
    }

    //v
    private static String AudioSpectrumSpreadType() throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"D:\\Lagu Extract\\Coba\\Classic\\Mozzart-Andate from  Piano Concerto no 21.xml\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioSpectrumSpreadType\")then data($x/SeriesOfScalar/Raw) else \"\"";

        String hasil = new XQuery(query).execute(context);
        return hasil;
        //System.out.println(new XQuery(query).execute(context));
    }
    private static String HarmonicSpectralCentroidType() throws BaseXException{
        //String jajal = "D:\Lagu Extract\Coba\Classic\Mozzart-Andate from  Piano Concerto no 21.xml";
        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"D:\\Lagu Extract\\Coba\\Classic\\Mozzart-Andate from  Piano Concerto no 21.xml\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"HarmonicSpectralCentroidType\")then data($x/Scalar) else \"\"";

        //System.out.println(new XQuery(query).execute(context));
        String hasil = new XQuery(query).execute(context);
        return hasil;
    }
        private static String HarmonicSpectralDeviationType() throws BaseXException{
        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"D:\\Lagu Extract\\Coba\\Classic\\Mozzart-Andate from  Piano Concerto no 21.xml\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"HarmonicSpectralDeviationType\")then data($x/Scalar) else \"\"";

        //System.out.println(new XQuery(query).execute(context));
        String hasil = new XQuery(query).execute(context);
        return hasil;
    }
        private static String HarmonicSpectralDeviationSpread() throws BaseXException{
        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"D:\\Lagu Extract\\Coba\\Classic\\Mozzart-Andate from  Piano Concerto no 21.xml\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"HarmonicSpectralSpreadType\")then data($x/Scalar) else \"\"";

        //System.out.println(new XQuery(query).execute(context));
        String hasil = new XQuery(query).execute(context);
        return hasil;
    }
        private static String HarmonicSpectralVariationType() throws BaseXException{
        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"D:\\Lagu Extract\\Coba\\Classic\\Mozzart-Andate from  Piano Concerto no 21.xml\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"HarmonicSpectralVariationType\")then data($x/Scalar) else \"\"";

        //System.out.println(new XQuery(query).execute(context));
        String hasil = new XQuery(query).execute(context);
        return hasil;
    }
        private static String SoundModel() throws BaseXException{
        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"D:\\Lagu Extract\\Coba\\Rock\\Baru\\Metallica- Hardwired (Official Music Video).xml\")/Mpeg7/Description/Model/Initial\n return if($x/@xsi:type=\"SoundModelType\")then data($x/Transitions) else \"\"";
        String hasil = new XQuery(query).execute(context);
        return hasil;
    }
        private static String AudioWaveform() throws BaseXException{
        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"D:\\Lagu Extract\\Coba\\Classic\\Mozzart-Andate from  Piano Concerto no 21.xml\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioWaveformType\")then data($x/SeriesOfScalar/Min) else \"\"";
        //System.out.println(new XQuery(query).execute(context));
        String hasil = new XQuery(query).execute(context);
        return hasil;
    }
        private static String TemporalCentroid() throws BaseXException{
        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"D:\\Lagu Extract\\Coba\\Classic\\Mozzart-Andate from  Piano Concerto no 21.xml\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"TemporalCentroidType\")then data($x/Scalar) else \"\"";
        //System.out.println(new XQuery(query).execute(context));
        String hasil = new XQuery(query).execute(context);
        return hasil;
    }
        private static String LogAttackTime() throws BaseXException{
        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                           "for $x in doc(\"D:\\Lagu Extract\\Coba\\Classic\\Mozzart-Andate from  Piano Concerto no 21.xml\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"LogAttackTimeType\")then data($x/Scalar) else \"\"";

        //System.out.println(new XQuery(query).execute(context));
        String hasil = new XQuery(query).execute(context);
        return hasil;
    }


}
