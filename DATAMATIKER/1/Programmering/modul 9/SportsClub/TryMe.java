import java.util.ArrayList;
public class TryMe {
    
    public void tryMe() {
        Member m1 = new Member("1212801999", "Joe", "At Home", "12121212");
        Member m2 = new Member("1212891999", "Jane", "Somewhere", "11111111");
        Member m3 = new Member("1212991999", "Janice", "Right there", "22222222");
        Member m4 = new Member("1212009999", "Jack", "Mommy's", "33333333");
        Member m5 = new Member("2212039999", "Juan", "A casa", "44444444");
        
        Team t1 = new Team("Soccer guys", "Football", 123, 12, 21);
        Team t2 = new Team("Bruce Lee's Disciples", "Jeet kune do", 321, 21, 12);
        
        t2.addMember(m1);
        t2.addMember(m2);
        t2.addMember(m3);
        t1.addMember(m4);
        t1.addMember(m5);
        
        Club c = new Club("Sønderhøj Idrætsforening");
        c.addTeam(t1);
        c.addTeam(t2);
        
        ArrayList<Member> membersInTeam1 = t1.getAllMembers();
        System.out.println("Members in team 1: \n" + membersInTeam1);
        
        ArrayList<Member> membersInTeam2 = t2.getAllMembers();
        System.out.println("Members in team 2: \n" + membersInTeam2);
       
        System.out.println("Team 1 has won: " + t1.getGamesWon());
        System.out.println("Team 1 has lost: " + t1.getGamesLost());
        System.out.println("Team 1 is a winner team: " + t1.isWinnerTeam());
        System.out.println("Team 2 is a winner team: " + t2.isWinnerTeam());
        
        System.out.println("Oldest in Team 1: " + t1.getOldestMember());
        System.out.println("Oldest in Team 2: " + t2.getOldestMember());
        
        System.out.println("Oldest in club: " + c.findMostSeniorMember());
        System.out.println("Winner teams: " + c.findWinnerTeams() + "\n\n");
        
        System.out.println("Team with Joe in it: " + c.findTeamByMemberName("Joe").getTeamName());
        System.out.println("Team with Carl in it: " + 
               (c.findTeamByMemberName("Carl") != null ?
                c.findTeamByMemberName("Carl").getTeamName() : 
                "Can't find it captain!")
        );
    }

}








