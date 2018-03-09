using System;

public static class UserListClass
{
    List<User> userList = new List<User>();

    public string ChooseToAddNewUser;

    Console.WriteLine("Would you like to add a new User?");

    Console.ReadLine(ChooseToAddNewUser);
}
