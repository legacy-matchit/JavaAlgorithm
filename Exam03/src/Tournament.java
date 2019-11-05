import java.util.ArrayList;

public class Tournament {
    ArrayList<Player> players;
    /** Skapar en ny turnering för de tävlande i players */
    public Tournament(ArrayList<Player> players){
        this.players = players;
    }
    /** Skriver ut en sorterad aktuell resultatlista, med en tävlande per
     rad på formen: id: <antal spelade> <antal poäng> */
    public void printPlayerRank(){
        for(Player p: players){
            System.out.println(p.toString());
        }
    }
    /** Notes which contestants will meet in the next round, and returns one
           list of competitors who could not be assigned a new opponent */
    public ArrayList<Player> setNextRoundOpponents(){
        ArrayList<Player> list = newPlayerRank();

        while (!list.isEmpty()){
            Player p1 = list.remove(0);
            Player p2 = list.remove(0);
            p1.addNextOpponent(p2);
            p2.addNextOpponent(p1);


        }

        return list;
    }
    /** Noterar att den tävlande med nummer id spelat en match till och fick där
     poängen point */
    public void addNewResult(int id, double point){

    }

    /** Returnerar en sorterad aktuell resultatlista */
    private ArrayList<Player> newPlayerRank() {
        ArrayList<Player>tem = new ArrayList<>();
        for(int i = 0; i < players.size(); i++){
            int pos = i;
            for(int j = i; j < players.size(); j++){
                if(players.get(j).getScore() > players.get(pos).getScore()){
                    pos  = j;
                }
            }

            tem.add(players.get(pos));
        }
        return tem;
    }
}
