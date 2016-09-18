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
            "Everybody Knew ","Pergi Untuk Kembali","KOLAM SUSU","Sedari Dulu","Tompi Menghujam Jantungku"
        };

        for (int i = 0 ; i < nama.length ; i++) {
            String string;
            string = AudioSpectrumProjectionType(nama[i]).trim();
            String hasil = string.replace(" ", ", ").replace("&#xD;", ",");
            //System.out.print(hasil);

            File file = new File("D:/Lagu Extract/Coba/2Minutes Cut/2Minutes Jazz/py/" + nama[i] + ".py");
            String python = "projection = [" + hasil + "]";
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
    private static String AudioSignatureType() throws BaseXException{

        String query =
                "declare default element namespace \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace mpeg7 = \"urn:mpeg:mpeg7:schema:2001\";" +
                        "declare namespace xsi = \"http://www.w3.org/2001/XMLSchema-instance\";" +
                        "for $x in doc(\"D:/Lagu Extract/Coba/EDM/2Minutes/py/\")/Mpeg7/Description/MultimediaContent/Audio/AudioDescriptionScheme return if($x/@xsi:type=\"AudioSignatureType\")then data($x/Flatness/SeriesOfVector/Mean) else \"\"";
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
