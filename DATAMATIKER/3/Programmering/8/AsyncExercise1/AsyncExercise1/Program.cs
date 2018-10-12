using System;
using System.Diagnostics;
using System.Threading;
using System.Threading.Tasks;

namespace AsyncExercise1
{
    class Program
    {
        static void Main(string[] args)
        {
            //UseSystemThreading();
            //UseSystemThreadingTasks();
            while (true)
            {
                UseAsync();
            }

            Console.ReadLine();
        }

        private static async void UseAsync()
        {

            Task t = Task.Run(() => DoWorkAsync());

            for (int count = 0; count < 100; count++)
            {
                Console.Write("-");
            }

            await t;
        }

        private static async Task DoWorkAsync()
        {
            await Task.Run(() =>
            {
                for (int count = 0; count < 100; count++)
                {
                    Console.Write("+");
                }
            });
        }


        private static void UseSystemThreading()
        {
            //Create Thread
            ThreadStart threadStart = DoWork;
            Thread plusThread = new Thread(threadStart);
            // start thread
            plusThread.Start();
            //
            for (int count = 0; count < 100; count++)
            {
                Console.Write("-");
            }
            //wait for plusThread to terminate
            plusThread.Join();
        }

        private static void DoWork()
        {
            for (int count = 0; count < 100; count++)
            {
                Console.Write("+");
            }
        }

        private static void UseSystemThreadingTasks()
        {

            // Create and run Task
            Task plusTask = Task.Run(
                () =>
                {
                    for (int count = 0; count < 1000; count++)
                    {
                        Console.Write('+');
                    }
                });

            Debug.WriteLine("Plus Task status: " + plusTask.Status);

            for (int count = 0; count < 1900; count++)
            {
                Console.Write('-');
            }
            plusTask.Wait();
            Debug.WriteLine("Plus Task status: " + plusTask.Status);
        }

    }
}
