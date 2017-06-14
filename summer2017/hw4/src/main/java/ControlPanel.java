import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This is the ControlPanel for PokeBattle. It allows the
 * user to pick which Pokemon it would like to add next.
 *
 * @author Sundeep, Ethan, Heather
 * @version 1.0
 */
public class ControlPanel extends JPanel {
    private JButton blaziken, poliwhirl, torterra;

    //TODO
    // uncomment and change line 23 below to reflect
    // your custom Pokemons' names
    // Don't forget to delete the "TODO" to fix checkstyle

    //private JButton pokemon1, pokemon2;

    private JLabel current;

    private String pokemonSpecies;

    public ControlPanel() {
        setPreferredSize(new Dimension(150, PokeWorld.HEIGHT));

        blaziken = new JButton("Blaziken");
        blaziken.addActionListener(new ButtonListener("Blaziken"));
        add(blaziken);

        poliwhirl = new JButton("Poliwhirl");
        poliwhirl.addActionListener(new ButtonListener("Poliwhirl"));
        add(poliwhirl);

        torterra = new JButton("Torterra");
        torterra.addActionListener(new ButtonListener("Torterra"));
        add(torterra);

        //TODO
        // Uncomment the code below and replace the variables and
        // Button names with those matching your custom Pokemon
        // Don't forget to delete the "TODO" to fix checkstyle

        /*
        pokemon1 = new JButton("Pokemon1");
        pokemon1.addActionListener(new ButtonListener("Pokemon1"));
        add(pokemon1);

        pokemon2 = new JButton("Pokemon2");
        pokemon2.addActionListener(new ButtonListener("Pokemon2"));
        add(pokemon2);
        */

        //default starting pokemon
        pokemonSpecies = "Blaziken";
        add(new JLabel("Current Pokemon"));
        current = new JLabel("Blaziken");
        add(current);

    }

    /**
     * Invoked by PokeWorld to determine which Pokemon
     * was chosen
     *
     * @return The currently selected Pokemon species
     */
    public String getPokemonSpecies() {
        return pokemonSpecies;
    }

    /**
     * Listener for clicks on the Pokemon switcher buttons
     */
    public class ButtonListener implements ActionListener {
        private String name;

        public ButtonListener(String className) {
            name = className;
        }

        public void actionPerformed(ActionEvent e) {
            pokemonSpecies = name;
            current.setText(name);
        }
    }
}
