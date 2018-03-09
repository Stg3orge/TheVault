import java.util.*;
public class Team {

    private String teamName;
    private String discipline;
    private int points;
    private int gamesLost;
    private int gamesWon;
    private ArrayList<Member> members;

    public Team(String _teamname, String _disc, int _points, int _gameslost, int _gameswon) {
        setTeamName(_teamname);
        setDiscipline(_disc);
        setPoints(_points);
        setGamesLost(_gameslost);
        setGamesWon(_gameswon);        
        members = new ArrayList<>();
    }

    public String getTeamName(){
        return teamName;
    }

    public void setTeamName(String input){
        teamName = input;
    }

    public String getDiscipline(){
        return discipline;
    }

    public void setDiscipline(String input){
        discipline = input;
    }

    public int getPoints(){
        return points;
    }

    public void setPoints(int input){
        points = input;
    }

    public int getGamesLost(){
        return gamesLost;
    }

    public void setGamesLost(int input){
        gamesLost = input;
    }

    public int getGamesWon(){
        return gamesWon;
    }

    public void setGamesWon(int input){
        gamesWon = input;
    }

    public ArrayList<Member> getMembers(){
        return members;
    }

    public void addMember(Member member){
        members.add(member);
    }

    public Member getOldestMember(){

        Member member = new Member("1010202020", "Harry", "Silkeborgvej 12", "51269983");
        int birthyear = 10000;

        for(Member element : members){  

            if(birthyear > element.getBirthYear()){
                birthyear = element.getBirthYear();
                member = element;
            }
        }
        
        return member;
    }
    
    public int numberOfTeamMembers(){
        
        int count = 0;
        
        for(Member element : members){
            count++;
        }
        
        return count;
    }
    
    
}
