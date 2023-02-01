import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

public class Carte {

    /**
     * The key is the point (x,y).
     * The value will be true if the point has space ' ' on the map and false if it has '#'
     */
    private final Map<Point, Boolean> map = new HashMap<>();

    /**
     * La valeur maximal dans l'axe des X
     */
    private int nbX = 0;

    /**
     * La valeur maximal dans l'axe des Y
     */
    private int nbY = 0;

    /**
     * Les directions autorisées
     */
    private static final Set<Character> DIRECTIONS = Set.of('N', 'S', 'E', 'O');

    public Carte() {
        this.readMapFile();
    }

    public Map<Point, Boolean> getMap() {
        return map;
    }

    public int getNbX() {
        return nbX;
    }

    public int getNbY() {
        return nbY;
    }

    /**
     * Lire le fichier "carte.txt" et initialiser les variables {@link #nbX}, {@link #nbY}
     * et ajouter les key/value sur la {@link #map}
     */
    private void readMapFile() {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get("src/main/resources/carte.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.nbX = lines.get(0).length();
            this.nbY = lines.size();
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                for (int j = 0; j < line.length(); j++) {
                    Point point = new Point(j, i);
                    if (line.charAt(j) == ' ') {
                        this.map.put(point, true);
                    } else if (line.charAt(j) == '#') {
                        this.map.put(point, false);
                    }
                }
            }
        }
    }

    /**
     * Tester si le point est valid
     * @param x int
     * @param y int
     * @return boolean
     * @see #pointIsValid(Point)
     */
    public boolean pointIsValid(int x, int y) {
        return (x >= 0 && x < nbX) && (y >= 0 && y < nbY);
    }

    /**
     * Tester si le point est valid
     * @param point {@link Point}
     * @return boolean
     * @see #pointIsValid(int, int)
     */
    public boolean pointIsValid(Point point) {
        return pointIsValid(point.x, point.y);
    }

    /**
     * Tester si les directions sont valid
     * @param directions {@link String}
     * @return boolean
     * @see #DIRECTIONS
     */
    public boolean directionsIsValid(String directions) {
        if (directions.length() == 0) return false;
        for (int i = 0; i < directions.length(); i++) {
            if (!DIRECTIONS.contains(directions.charAt(0))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Tester si le déplacement vers le point donné est autorisé
     * @param point {@link Point}
     * @return boolean
     * @see #pointIsValid(Point)
     */
    public boolean pointIsAllowed(Point point) {
        return pointIsValid(point) && map.get(point);
    }
}
