import java.util.ArrayList;
/**
 * @author knol
 * @version 2016-09-25
 */
public class Club {
    private String name;
    private ArrayList<Team> teams;
    
    public Club(String name) {
        teams = new ArrayList<>();
        setName(name);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void addTeam(Team t) {
        if(t != null) {
            teams.add(t);
        }
    }
    
    public void deleteTeam(String teamName) {
        if(teamName != null) {
            boolean found = false;
            int i = 0 ;
            while(i < teams.size() && !found) {
                if(teams.get(i).getTeamName().equals(teamName)) {
                    teams.remove(i);
                    found = true;
                }
                else {
                    i++;
                }
            }
        }
    }
    
    public ArrayList<Team> findWinnerTeams() {
        // Note how we always return an ArrayList object, even if
        // ther are no teams that have won more than lost.
        // If this is the case the returned ArrayList is empty.
        // The caller doesn't need to worry about NPE's when 
        // using the returned ArrayList when we adopt this approach.
        ArrayList<Team> res = new ArrayList<>();
        for(Team currTeam : teams) {
            if(currTeam.isWinnerTeam()) {
                res.add(currTeam);
            }
        }
        return res;
    }
    
    public Team findTeamByMemberName(String memberName) {
        Team currTeam = null;
        Team res = null;
        int i = 0;
        if(memberName != null) {
            while(i < teams.size() && res == null) {
                currTeam = teams.get(i);
                if(currTeam.getMember(memberName) != null) {
                    res = currTeam;
                }
                else {
                    i++;
                }
            }
        }
        return res;
    }
    
    public Member findMostSeniorMember() {
        Member res = null;
        Member currOldestMember = null;
        for(Team currTeam : teams) {
            currOldestMember = currTeam.getOldestMember();
            if(res == null || res.getBirthYear() > currOldestMember.getBirthYear()) {
                res = currOldestMember;
            }
        }
        return res;
    }
    
    public String toString() {
        String res = name + "{";
        for(Team t : teams) {
            res += "[" + t.toString() + "] ";
        }
        res += "}";
        return res;
    }
}