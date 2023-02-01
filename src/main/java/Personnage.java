public class Personnage {

    /**
     * La position de Personnage dans la carte
     */
    private Point position;

    public Personnage(Point position) {
        this.position = new Point(position);
    }

    public Point getPosition() {
        return position;
    }

    /**
     * Déplacer le Personnage
     * @param carte {@link Carte} La carte dans laquelle le Personnage vas se déplacer
     * @param directions {@link String} Les directions de déplacement
     */
    public void move(Carte carte, String directions) {

        for (int i = 0; i < directions.length(); i++) {
            Point temporaryPosition = new Point(position);
            switch (directions.charAt(i)) {
                case 'N' -> temporaryPosition.translate(0, -1);
                case 'S' -> temporaryPosition.translate(0, 1);
                case 'E' -> temporaryPosition.translate(1, 0);
                case 'O' -> temporaryPosition.translate(-1, 0);
            }
            if (carte.pointIsAllowed(temporaryPosition)) {
                this.position = temporaryPosition;
            }
        }
    }
}
