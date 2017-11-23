import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ChessGame {

    private StringProperty event = new SimpleStringProperty(this, "NA");
    private StringProperty site = new SimpleStringProperty(this, "NA");
    private StringProperty date = new SimpleStringProperty(this, "NA");
    private StringProperty white = new SimpleStringProperty(this, "NA");
    private StringProperty black = new SimpleStringProperty(this, "NA");
    private StringProperty result = new SimpleStringProperty(this, "NA");
    private List<String> moves;

    public ChessGame(String event, String site, String date,
                     String white, String black, String result) {
        this.event.set(event);
        this.site.set(site);
        this.date.set(date);
        this.white.set(white);
        this.black.set(black);
        this.result.set(result);
        moves = new ArrayList<>();
    }

    public void addMove(String move) {
        moves.add(move);
    }

    public String getMove(int n) {
        return moves.get(n - 1);
    }

    public String getEvent() {
        return event.get();
    }

    public String getSite() {
        return site.get();
    }

    public String getDate() {
        return date.get();
    }

    public String getWhite() {
        return white.get();
    }

    public String getBlack() {
        return black.get();
    }

    public String getResult() {
        return result.get();
    }
}
