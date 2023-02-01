import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        Carte carte = new Carte();

        Point position = new Point(-1, -1);
        String directions = "";

        while (!carte.pointIsValid(position)) {
            int x = -1;
            int y = -1;
            System.out.println("Entrez le point initial (x,y)");
            System.out.println("NB: Les cordonnées x et y doivent être entre 0 et 19");
            String pointStr = new Scanner(System.in).nextLine();
            String[] parts = pointStr.replaceAll(" ", "").split(",");
            try {
                x = Integer.parseInt(parts[0]);
                y = Integer.parseInt(parts[1]);
            } catch (NumberFormatException ignored) {
            } finally {
                position.move(x, y);
            }
        }

        while (!carte.directionsIsValid(directions)) {
            System.out.println("Entrez la suite des directions N/S/E/O :");
            directions = new Scanner(System.in).nextLine().replaceAll(" ", "");
        }

        Personnage personnage = new Personnage(position);
        personnage.move(carte, directions);

        System.out.println(personnage.getPosition());

    }
}
