import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Loader {
    public static void main(String[] args) {
        try {
            System.out.println(parseFile());
            Document html = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();
            System.out.println(html.title() + "\n");
            Element link = html.select("div#metrodata").first();
            Elements news = link.getElementsByTag("span");

            Line line = new Line();
            TreeMap<String, Line> lines = new TreeMap<>(); // список записанных линий
            Station station = new Station(); // текущая станция

            int prevNum = 0, num = 0;
            for (var item : news)
            {
                if(item.attributes().get("class").equals("num")){
                    // Станции московского метро (номер линии)
                    num = Integer.parseInt(item.childNodes().get(0).toString().replaceAll("\\D+", ""));
                    if (num != prevNum){
                        station = new Station();
                        prevNum = num;
                    }
                }
                else if(item.attributes().get("class").equals("name")){
                    // Станции московского метро (получаете имя станции)
                    station.name = item.childNodes().get(0).toString().replaceAll("[\\[\\]]", "");
                    if (num == 0)
                        System.out.println("Все плохо!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    line.stations.put(num, station);
                }
                else if (item.attributes().get("class").startsWith("t-icon-metroln")){ // заполняем пересадки
                    String ln = item.attributes().get("class").replace("t-icon-metroln ln-", "");
                    String temp = item.attributes().get("title").substring(item.attributes().get("title").indexOf("«")+1, item.attributes().get("title").indexOf("»"));
                    if (lines.containsKey(ln)){ // если уже существует линия для пересадки
                        Line l = lines.get(ln);
                        if (!l.lineName.isEmpty()) { // проверка
                            l.lineTitle = item.attributes().get("title").substring(item.attributes().get("title").indexOf("»")+2); // добавили тег
                            station.transfers.put(temp, l);
                        }   // пРОВАЛИЛАСЬ ПРОВЕРКА НУЖНО РАССМОТРЕТЬ СЛУЧАЙ, КОГДА TITLE НЕ ПУСТОЙ, ТОГДА КАК ПОСТУПИТЬ С ИМЕНЕМ
                        else if (!l.lineTitle.isEmpty()){
                            station.transfers.put(temp, l);
                        }
                        else {
                            System.out.println("Ошибка.");
                        }
                    }
                    else { // если еще не существует
                        Line l = new Line(item.attributes().get("title").substring(item.attributes().get("title").indexOf("»")+2));
                        station.transfers.put(temp, l);
                        lines.put(ln, l);
                    }
                }
                else { // Линии московского метро (получаете имя линии, номер линии).
                    if (lines.containsKey(item.attributes().get("data-line"))){ // линиия уже существует
                        line = lines.get(item.attributes().get("data-line"));
                        if(!line.lineTitle.isEmpty()){
                            line.lineName = item.childNodes().toString().replaceAll("[\\[\\]]", "");
                        }
                        else {
                            System.out.println("Ошибка.");
                        }
                        
                    }
                    else { // линия еще не существует
                        if (line.lineName != item.childNodes().toString().replaceAll("[\\[\\]]", "")){
                            line = new Line();
                        }
                        else {
                            System.out.println("Ошибка.");
                        }
                        line.lineName = item.childNodes().toString().replaceAll("[\\[\\]]", "");
                        lines.put(item.attributes().get("data-line"), line);
                    }
                }
            }



            Gson json = new GsonBuilder().setPrettyPrinting().create();
            writeJsonToFile(json, lines);

            Line person = json.fromJson(parseFile(), Line.class);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void writeJsonToFile(Gson json, TreeMap<String, Line> lines) {
        File dir = new File("data");
        if (!dir.exists())
            dir.mkdir();

        FileWriter jsonFile;
        try {
            jsonFile = new FileWriter("data/metro.json");

            jsonFile.write(json.toJson(lines));
            jsonFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String parseFile() {
        StringBuilder builder = new StringBuilder();

        try {
            List<String> files = Files.readAllLines(Paths.get("data/metro.json"));

            files.forEach(file -> builder.append(file).append("\n"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return builder.toString();
    }

}

class Line{
    String lineName = "";
    String lineTitle = "";
    public TreeMap<Integer, Station> stations = new TreeMap<>();

    Line (){

    }
    Line (String lineTitle){
        this.lineTitle = lineTitle;
    }
}

class Station{
    String name = "";
    public TreeMap<String, Line> transfers = new TreeMap<>();
}
