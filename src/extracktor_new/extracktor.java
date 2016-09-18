/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extracktor_new;

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


public class extracktor{


    public static void main(String[] args){
        try {
            String sourceConfig = "C:\\Users\\Andre\\Documents\\NetBeansProjects\\MPEG-7_Extract\\config\\config.xml";
            InputStream inputStream = new FileInputStream(sourceConfig);
            Reader reader = new InputStreamReader(inputStream);
            Config config = ConfigXML.parse(reader);

            String[] nama = new String[]{
                            "2Minutes Beethoven","2Minutes-Allegro","2Minutes-Andate","2Minutes-Bach Air on the G string","2Minutes-JeanJoseph Mouret "
            };

            String base = new String("D:\\Lagu Extract\\Coba\\2Minutes Cut\\2Minutes Classic\\");

            for(int i = 0 ; i < nama.length ; i++) {

                String input = base + nama[i] + ".wav";
                File file = new File(input);
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                Document mpeg7 = MP7DocumentBuilder.encode(audioInputStream, config);

                DOMSource domSource = new DOMSource(mpeg7);

                StringWriter stringWriter = new StringWriter();
                StreamResult result = new StreamResult(stringWriter);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.transform(domSource, result);

                String hasil = stringWriter.toString();
                File file1 = new File("D:\\Lagu Extract\\Coba\\2Minutes Cut\\2Minutes Classic\\" + nama[i] + ".xml");
                FileWriter fileWriter = new FileWriter(file1, false);

                fileWriter.write(hasil);
                stringWriter.flush();
                fileWriter.flush();
                fileWriter.close();
                System.out.println("i :" + i);
            }
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
