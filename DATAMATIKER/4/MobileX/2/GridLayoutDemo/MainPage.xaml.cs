using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

[assembly: XamlCompilation(XamlCompilationOptions.Compile)]
namespace GridLayoutDemo {

    public partial class MainPage : ContentPage {

        public MainPage() {

            InitializeComponent();

            IList<string> leagueList = new List<string>();
            leagueList.Add("Liga 1");
            leagueList.Add("Liga 2");
            leagueList.Add("Serie A");
            leagueList.Add("La Liga");
            leagueList.Add("Bundesliga");
            leagueList.Add("Ligue 1");
            leagueList.Add("Premier League");
            leagueList.Add("Championship");
            leagueList.Add("Æresdivisionen");
            leagueList.Add("Superligaen");
            leagueList.Add("Alsvanskan");
            leagueList.Add("Tippeligaen");
            leagueList.Add("Jupiler Ligaen");

            var headLabel = new Label { Text = "Soccer leagues", TextColor = Color.White, FontSize = 36, VerticalOptions = LayoutOptions.Center, HorizontalOptions = LayoutOptions.Center };

            LeagueGrid.Children.Add(headLabel, 0, 0);
            Grid.SetColumnSpan(headLabel, 3);

            Label tempLab;
            int ix = 0;
            foreach (string league in leagueList) {
                tempLab = new Label { Text = league, TextColor = Color.FromHex("#28282c"), BackgroundColor = Color.White, FontSize = 12, HorizontalTextAlignment = TextAlignment.Center, VerticalTextAlignment = TextAlignment.Center };
                LeagueGrid.Children.Add(tempLab);
                Grid.SetRow(tempLab, 1 + (ix / 3));
                Grid.SetColumn(tempLab, ix % 3);
                ix++;
            }


        }
    }

}
