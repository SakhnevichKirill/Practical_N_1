import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Metro{
    private TreeMap<String, String[]> stations;
    private ArrayList<Line> lines;

    public Metro(TreeMap<String, String[]> stations, ArrayList<Line> lines) {
        this.stations = stations;
        this.lines = lines;
    }

    public TreeMap<String, String[]> getStations() {
        return stations;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

}
