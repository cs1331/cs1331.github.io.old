import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class ChessGame {


    private String event;
    private String site;
    private String date;
    private String white;
    private String black;
    private String result;
    private List<String> moves;

    public ChessGame(String event, String site, String date,
                     String white, String black, String result) {
        this.event = event;
        this.site = site;
        this.date = date;
        this.white = white;
        this.black = black;
        moves = new ArrayList<>();
    }

    public void addMove(String move) {
        moves.add(move);
    }

    public String getMove(int n) {
        return moves.get(n - 1);
    }

    public String getEvent() { return event; }
    public String getSite() { return site; }
    public String getDate() { return date; }
    public String getWhite() { return white; }
    public String getBlack() { return black; }
}
