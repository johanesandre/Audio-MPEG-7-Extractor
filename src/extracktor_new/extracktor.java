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
                "2Minutes- Faded","2Minutes- Things Will Get Better Lyrics ","2Minutes- Turn Up The Speakers","ALEXANDRA STAN - Mr. Saxobeat - 1","Bach, Air on the G string - 1",
                "Beethoven-Introduction To Symphony no 5 - 1","Bon Jovi - It's My Life - 1","Bon Jovi - Livin' On A Prayer - 1","Citra - Everybody Knew - 1","Dillon Francis DJ Snake - Get Low - 1",
                "Dimitri Vegas - Tremor - 1","DJ Snake - Middle - 1","Ello - Pergi Untuk Kembali - 1","Isyana Sarasvati - Tetap Dalam Jiwa - 1","Jean-Joseph Mouret  - 1","Jennifer Lopez-On The Floor Pitbull - 1",
                "KOLAM SUSU-KOES PLUS - 1","Linkin Park - Somewhere I Belong - 1","Metallica - For Whom The Bell Tolls with lyrics - 1","Metallica - Whiskey In The Jar- 1",
                "Mozart -  Allegro - 1","Mozzart-Andate  - 1","Pitbull - I Know You Want Me - 1","PROJECT POP - MOVE ON - 1","R3HAB  KSHMR - Karate - 1","R3HAB  VINAI - How We Party - 1",
                "Raisa - Firasat - 1","Raisa - Kali Kedua - 1","RAISA - Terjebak Nostalgia - 1","RAISA- Apalah - 1","Tompi - Sedari Dulu - 1","Tompi Menghujam Jantungku - 1"
            };

            String base = new String("D:\\Lagu Extract\\XML\\Wav\\Cut 2Minutes");

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
                File file1 = new File("D:\\Lagu Extract\\XML\\Wav\\Cut 2Minute\\" + nama[i] + ".xml");
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
