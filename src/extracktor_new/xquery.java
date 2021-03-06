/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extracktor_new;


import org.basex.core.*;
import org.basex.core.cmd.*;
import org.basex.io.serial.*;
import org.basex.query.*;
import org.basex.query.iter.*;
import org.basex.query.value.*;
import org.basex.query.value.item.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class xquery {

    static Context context = new Context();
    public static void main(String[] args) throws IOException, QueryException, BaseXException{

        //nyoba baru
        //System.out.println("Audio projection:");
        String[] nama = new String[]{
                "2Minutes- Faded","2Minutes- Things Will Get Better Lyrics ","2Minutes- Turn Up The Speakers","ALEXANDRA STAN - Mr. Saxobeat - 1","Bach, Air on the G string - 1",
                "Beethoven-Introduction To Symphony no 5 - 1","Bon Jovi - It's My Life - 1","Bon Jovi - Livin' On A Prayer - 1","Citra - Everybody Knew - 1","Dillon Francis DJ Snake - Get Low - 1",
                "Dimitri Vegas - Tremor - 1","DJ Snake - Middle - 1","Ello - Pergi Untuk Kembali - 1","Isyana Sarasvati - Tetap Dalam Jiwa - 1","Jean-Joseph Mouret  - 1","Jennifer Lopez-On The Floor Pitbull - 1",
                "KOLAM SUSU-KOES PLUS - 1","Linkin Park - Somewhere I Belong - 1","Metallica - For Whom The Bell Tolls with lyrics - 1","Metallica - Whiskey In The Jar- 1",
                "Mozart -  Allegro - 1","Mozzart-Andate  - 1","Pitbull - I Know You Want Me - 1","PROJECT POP - MOVE ON - 1","R3HAB  KSHMR - Karate - 1","R3HAB  VINAI - How We Party - 1",
                "Raisa - Firasat - 1","Raisa - Kali Kedua - 1","RAISA - Terjebak Nostalgia - 1","RAISA- Apalah - 1","Tompi - Sedari Dulu - 1","Tompi Menghujam Jantungku - 1"        };


for (int i = 0 ; i < nama.length ; i++) {
            String string;
            string = AudioSignatureType(nama[i]).trim();
            String hasil = string.replace(" ", ", ").replace("&#xD;", "");
            //System.out.print(hasil);

            File file = new File("D:/Lagu Extract/XML/Wav/Cut 2Minutes/py/" + nama[i] + ".py");
            String python = "signature = [" + hasil + "]";
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(python);
            fileWriter.flush();
            fileWriter.close();
            System.out.println(nama[i] + " done");
        }
		
        /*
        String[] hasil = string.split("&#xD;");
        for(int i = 0 ; i<hasil.length;i++){
            System.out.print(hasil[i].trim().replace(" ",","));
            if (i%19 == 0)
                System.out.print("\n");
            if(i != hasil.length-1)
                System.out.print(",");
        }*/
    }

    //v
    private static String AudioSignatureType(String nama) throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"D:/Lagu Extract/XML/Wav/Cut 2Minutes/"+ nama + ".xml"+"\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptionScheme return if($x/@xsi:type=\"AudioSignatureType\")then data($x/Flatness/SeriesOfVector/Mean) else \"\"";
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
                        "for $x in doc(\"C:/Users/ponighzwa/IdeaProjects/ExtractDescriptor/hasil/Sugar2.xml\")/Mpeg7/Description/MultimediaContent/Audio return if($x/AudioDescriptor/@xsi:type=\"AudioFundamentalFrequencyType\")then data($x/AudioDescriptor/SeriesOfScalar/Raw) else \"\"";
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
                        "for $x in doc(\"C:/Users/ponighzwa/IdeaProjects/ExtractDescriptor/hasil/Sugar2.xml\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioHarmonicityType\")then data($x/HarmonicRatio/SeriesOfScalar/Raw) else \"\"";

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
                        "for $x in doc(\"C:/Users/ponighzwa/IdeaProjects/ExtractDescriptor/hasil/Sugar2.xml\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioPowerType\")then data($x/SeriesOfScalar/Raw) else \"\"";

        String hasil = new XQuery(query).execute(context);
        return hasil;
        //System.out.println(new XQuery(query).execute(context));
    }

    private static void AudioSpectrumBasisType() throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"C:/Users/ponighzwa/IdeaProjects/ExtractDescriptor/hasil/Isyana-1.xml\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioSpectrumBasisType\")then data($x/SeriesOfVector/Raw) else \"\"";

        System.out.println(new XQuery(query).execute(context));
    }

    private static String AudioSpectrumProjectionType(String nama) throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"D:/Lagu Extract/Coba/2Minutes Cut/2Minutes Jazz/"+ nama + ".xml"+"\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioSpectrumProjectionType\")then data($x/SeriesOfVector/Raw) else \"\"";

        String hasil = new XQuery(query).execute(context);
        return hasil;
    }

    //v
    private static String AudioSpectrumCentroidType() throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"C:/Users/ponighzwa/IdeaProjects/ExtractDescriptor/hasil/Sugar2.xml\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioSpectrumCentroidType\")then data($x/SeriesOfScalar/Raw) else \"\"";

        String hasil = new XQuery(query).execute(context);
        return hasil;
        //System.out.println(new XQuery(query).execute(context));
    }

    private static void AudioSpectrumEnvelopeType() throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"IsyanaCoba.xml\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioSpectrumEnvelopeType\")then data($x/SeriesOfVector/Raw) else \"\"";

        System.out.println(new XQuery(query).execute(context));
    }

    private static void AudioSpectrumFlatnessType() throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"IsyanaCoba.xml\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioSpectrumFlatnessType\")then data($x/SeriesOfVector/Raw) else \"\"";

        System.out.println(new XQuery(query).execute(context));
    }

    //v
    private static String AudioSpectrumSpreadType() throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"C:/Users/ponighzwa/IdeaProjects/ExtractDescriptor/hasil/Sugar2.xml\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptor\n return if($x/@xsi:type=\"AudioSpectrumSpreadType\")then data($x/SeriesOfScalar/Raw) else \"\"";

        String hasil = new XQuery(query).execute(context);
        return hasil;
        //System.out.println(new XQuery(query).execute(context));
    }
}
