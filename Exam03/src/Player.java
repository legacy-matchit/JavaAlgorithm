import java.util.ArrayList;

public class Player {

    private int id;
    private double score;
    private int gameNbr;
    private ArrayList<Player> opponentList;

    /** Skapar en ny tävlande med nummer id, som inledningsvis har 0 poäng,
     inga spelade matcher och inga tilldelade motståndare */
    public Player(int id){
        this.id = id;
        score = 0;
        gameNbr = 0;
        opponentList = new ArrayList<>();
    }
    /** Returnerar den tävlandes nummer */
    public int getId(){
        return id;
    }
    /** Returnerar den tävlandes poäng */
    public double getScore(){
        return score;
    }
    /** Returnerar antalet matcher den tävlande spelat */
    public int getNbrGames(){
        return gameNbr;
    }
    /** Returnerar antalet motståndare som tilldelats den tävlande */
    public int getNbrOpponents(){
        return opponentList.size();
    }
    /** Returnerar den tävlandes i:te motståndare (1,2,3,...)
     Returnerar null om det inte finns någon i:te motståndare */
    public Player getOpponent(int i){
        if(opponentList.size() == 0){
            return null;
        }
        Player p = opponentList.get(i);
        return p;
    }
    /** Returnerar true om p finns med bland den tävlandes motståndare,
     annars false */
    public boolean isOpponent(Player p){
        for(Player oppoent : opponentList){
            if(oppoent.getId() == p.getId()){
                return true;
            }
        }
        return false;
    }
    /** Noterar opp som den tävlandes nästa motståndare */
    public void addNextOpponent(Player opp){
        opponentList.add(opp);
    }
    /** Noterar att den tävlande spelat en match till och där fick poängen point */
    public void addResult(double point){
        gameNbr++;
        score += point;
    }
    /** Returnerar den tävlandes resultat på formen:
     id: <antal spelade> <antal poäng> */
    public String toString(){
        return this.id + "<total gameCount : " +this.gameNbr+">" + "<total scroe : " + this.score + ">";
    }
}
