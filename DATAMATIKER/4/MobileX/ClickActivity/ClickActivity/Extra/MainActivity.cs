using Android.App;
using Android.Content;
using Android.Widget;
using Android.OS;

namespace OnYourOwn {
    [Activity(Label = "@string/AppHeadline", MainLauncher = true, Icon = "@drawable/icon")]
    public class MainActivity : Activity {
        protected override void OnCreate(Bundle savedInstanceState) {
            base.OnCreate(savedInstanceState);

            // Set our view from the "main" layout resource
            SetContentView(Resource.Layout.Main);

            Button nextButton = FindViewById<Button>(Resource.Id.NextButton);
            nextButton.Click += (sender, e) => {
                var intent = new Intent(this, typeof(ActivityHello));
                StartActivity(intent);
            };

        }
    }
}

