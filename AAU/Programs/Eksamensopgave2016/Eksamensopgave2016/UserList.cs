/*** Name: Jacob Sloth Thomsen
***  Student Number: 20154292
***/

using System.Collections.Generic;

namespace Eksamensopgave2016
{
    public class UserList // This class was meant to be called to hardcode in new users into a list, or alternatively use an admin command to add a user
    {
        public List<User> users = new List<User>();

        public void Userlist()
        {
            AddUsersIntoUserList();
        }

        // Method to (unfortunately) hardcode users into a list of users, using constructor, every user should have unique ids
        public void AddUsersIntoUserList()
        {
            users.Add(new User("Jacob", "Thomsen", "stgeorge", "cardisbunx@gmail.com", 75));
            users.Add(new User("John", "Cena", "johncenashow", "johncenaofficial@gmail.com", 150));
            users.Add(new User("Furion", "Stormrage", "furion", "stormrage@gmail.com", 300));
        }
    }
}
