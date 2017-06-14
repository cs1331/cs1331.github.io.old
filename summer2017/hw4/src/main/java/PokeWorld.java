import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

/**
 * This class represents Pokeworld
 *
 * @author Sundeep, Ethan Shernan, Heather
 * @version 1.0
 */
public class PokeWorld extends JPanel {
    public static final int WIDTH = 600, HEIGHT = 600;

    private ArrayList<Pokemon> types = new ArrayList<Pokemon>();
    private ControlPanel cPanel;
    private Timer timer;
    private Rectangle bounds;

    /**
     * Constructor
     *
     * @param control A ControlPanel instance which is used
     * to determine the next Pokemon to create
     */
    public PokeWorld(ControlPanel control) {
        cPanel = control;

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.GREEN);
        bounds = new Rectangle(0, 0, WIDTH, HEIGHT);

        addMouseListener(new ClickListener());

        timer = new Timer(100, new TimerListener());
        timer.start();
    }

    /**
     * Move all the Pokemon in PokeWorld
     */
    public void moveAll() {
        for (Pokemon a : types) {
            a.move();
        }
    }

    /**
     * Check to see whether any of the types can wound
     * the other types they are around. Then wounds them.
     */
    public void checkFoodChain() {
        for (Pokemon a : types) {
            for (Pokemon other : types) {
                if (a != other && a.collidesWithPokemon(other)
                    && a.canHarmPokemon(other)) {
                    a.harmPokemon(other);
                }
            }
        }
    }

    /**
     * Checks to see if members of a type need to reproduce
     */
    public void checkReproduce() {
        int currTypesSize = types.size();
        for (int i = 0; i < currTypesSize; i++) {
            for (int j = 0; j < currTypesSize; j++) {
                //don't want self reproduction
                if (i != j) {
                    if (types.get(i).
                        collidesWithPokemon(types.get(j))) {
                        if (types.get(i).
                            canReproduceWithPokemon(types.get(j))) {
                            Pokemon baby = types.get(i).
                                reproduceWithPokemon(types.get(j));
                            if (baby != null) {
                                //Prevent Heapsize crashes
                                if (types.size() < 1000) {
                                    types.add(baby);
                                    currTypesSize++;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Circle of life. Fainted Pokemon are no longer able to battle.
     * Therefore, remove them from the list.
     *
     * Since Java Garbage collects, once the only reference to the
     * Pokemon is gone, it is deleted from memory.
     */
    public void checkFaint() {
        for (int i = 0; i < types.size(); i++) {
            if (types.get(i).hasFainted()) {
                types.remove(i);
                i--;
            }
        }
    }

    /**
     * Once a Pokemon isOld, they are taken out of the wild.
     * Powerful Pokemon must retire.
     */
    public void retire() {
        for (Pokemon a : types) {
            if (a.isOld()) {
                a.faint();
            }
        }
    }

    /**
     * Draw all the types
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(WIDTH / 2, HEIGHT / 2, WIDTH, HEIGHT);
        g.setColor(Color.CYAN);
        g.fillRect(0, HEIGHT / 2, WIDTH / 2, HEIGHT);
        g.setColor(Color.ORANGE);
        g.fillRect(WIDTH / 2, 0, WIDTH, HEIGHT / 2);
        for (Pokemon a : types) {
            a.draw(g);
        }
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            moveAll();
            checkReproduce();
            checkFoodChain();
            retire();
            checkFaint();
            repaint();
        }
    }

    private class ClickListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            // Determine type of Pokemon to create using ControlPanel
            // Based on the button that was last clicked
            String pokemonSpecies = cPanel.getPokemonSpecies();
            Point p = e.getPoint();

            // Prevent Heapsize crashes, but allow more than reproduce
            if (types.size() < 1100) {
                // Create the corresponding Pokemon
                // TODO
                // uncomment the last two else-ifs below at lines
                // and replace the "Pokemon1" and "Pokemon2" with
                // your actual species names. Don't forget to
                // delete the TODO to fix checkstyle!
                if (pokemonSpecies.equals("Rapidash")) {
                    types.add(new Rapidash(p.x, p.y, bounds));
                } else if (pokemonSpecies.equals("Venusaur")) {
                    types.add(new Venusaur(p.x, p.y, bounds));
                } else if (pokemonSpecies.equals("Poliwhirl")) {
                    types.add(new Poliwhirl(p.x, p.y, bounds));
                } /* else if (pokemonSpecies.equals("Pokemon1")) {
                    types.add(new Pokemon1(p.x, p.y, bounds));
                } else if (pokemonSpecies.equals("Pokemon2")) {
                    types.add(new Pokemon2(p.x, p.y, bounds));
                } */
            }

            repaint();
        }
    }
}
