using System;
using System.Net;

namespace UsingTaskBasedApi {
    class Program {
        static void Main(string[] args) {
            var web = new WebClient();
            string result =
                web.DownloadString("http://localhost:49182/Slow.ashx");
            Console.WriteLine(result);
            Console.Read();
        }
    }
}
