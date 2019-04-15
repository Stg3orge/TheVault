import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private Auth: AuthenticationService) { }

  ngOnInit() {
  }

  loginUser(event) {
    event.preventDefault();
    let target = event.target;
    let username = target.querySelector('#username').value;
    let password = target.querySelector('#password').value;

    this.Auth.getUserDetails(username, password);

    console.log(username, password);
  }

}
