import de.crysandt.audio.mpeg7audio.Config;
import de.crysandt.audio.mpeg7audio.ConfigDefault;
import de.crysandt.audio.mpeg7audio.ConfigXML;
import de.crysandt.audio.mpeg7audio.MP7DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;


public class Descriptor{


    public static void main(String[] args){
        try {
            String sourceConfig = "C:\\Users\\Andre\\Documents\\NetBeansProjects\\MPEG-7_Extract\\config\\config.xml";
            InputStream inputStream = new FileInputStream(sourceConfig);
            Reader reader = new InputStreamReader(inputStream);
            Config config = ConfigXML.parse(reader);

            /* ini yag lama
            Config config = new ConfigDefault();
            config.enableAll(true);*/


            //System.out.println("1");
            //String input = new String("C:/Users/ponighzwa/IdeaProjects/CobaRP/lagu/Isyana.wav");
            String input = new String("D:\\Lagu Extract\\Coba\\Classic\\Mozzart-Andate from  Piano Concerto no 21.wav");
            //System.out.println("2");
            File file = new File(input);
            //System.out.println("3");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            //System.out.println("4");
            Document mpeg7 = MP7DocumentBuilder.encode(audioInputStream,config);

            //coba baru
            DOMSource domSource = new DOMSource(mpeg7);

            StringWriter stringWriter = new StringWriter();
            StreamResult result = new StreamResult(stringWriter);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(domSource, result);

            String hasil = stringWriter.toString();
            //System.out.println("5");

            //File file1 = new File("C:/Users/ponighzwa/IdeaProjects/CobaRP/descriptor/Isyana-final.xml");
            File file1 = new File("D:\\Lagu Extract\\Coba\\Classic\\Mozzart-Andate from  Piano Concerto no 21.xml");
            FileWriter fileWriter = new FileWriter(file1,false);

            fileWriter.write(hasil);
            stringWriter.flush(); // <- baru
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            System.out.println(e);

        }catch (UnsupportedAudioFileException e){
            System.out.println(e);

        } catch (ParserConfigurationException e){
            System.out.println(e);

        } catch (TransformerException e){
            System.out.println("e");

        } catch (SAXException e){
            System.out.println("error baru");
        }

    }

}
