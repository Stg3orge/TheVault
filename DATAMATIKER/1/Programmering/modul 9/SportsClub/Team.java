import java.util.ArrayList;

/**
 * @author knol
 * @version 2016-09-25
 */
public class Team {
    private String teamName;
    private String discipline;
    private int points;
    private int gamesLost;
    private int gamesWon;
    private ArrayList<Member> members;
    
    public Team (String name, String discipline) {
        members = new ArrayList<>();
        setTeamName(name);
        setDiscipline(discipline);
    }
    
    public Team (String name, String discipline, int points, int lost, int won) {
        this(name, discipline);
        setPoints(points);
        setGamesLost(lost);
        setGamesWon(won);
    }
    
    public void setTeamName(String teamName){this.teamName = teamName;}
    public String getTeamName(){return teamName;}
    
    public void setDiscipline(String discipline){this.discipline = discipline;}
    public String getDiscipline(){ return discipline;}
    
    public void setPoints(int points){this.points = points;}
    public int getPoints(){return points;}
    
    public void setGamesLost(int gamesLost){this.gamesLost = gamesLost;}
    public int getGamesLost(){return gamesLost;}
    
    public void setGamesWon(int gamesWon){this.gamesWon = gamesWon;}
    public int getGamesWon(){return gamesWon;}
    
    public void addMember(Member m) {
        if(m != null) {
            members.add(m);
        }
    }
    
    public ArrayList<Member> getAllMembers() {
        // return a COPY of the member - implement information hiding
        // the caller of this method won't be able to to modify the
        // the member list in the Team class by manipulating the 
        // returned value
        ArrayList<Member> res = new ArrayList<>(this.members);
        return res;
    }
    
    public Member getOldestMember() {
        Member oldestMember = null;
        for(Member currMember : members) {
            if(oldestMember == null || oldestMember.getBirthYear() > currMember.getBirthYear()) {
                oldestMember = currMember;
            }
        }
        return oldestMember;
    }
    
    public Member getMember(String memberName) {
        Member res = null;
        if(memberName != null) {
            int i = 0;
            while(res == null && i < members.size()) {
                if(members.get(i).getName().equals(memberName)) {
                    res = members.get(i);
                }
                else {
                    i++;
                }
            }
        }
        return res;
    }
    
    public boolean isWinnerTeam() {
        return gamesWon > gamesLost;
    }
    
    @Override
    public String toString() {
        String res = teamName + ": ";
        for(Member m : members) {
            res += m.toString() + ", ";
        }
        return res;
    }
}