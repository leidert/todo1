import { Injectable } from "@angular/core";
import { LoginService } from "../../services/login/login.service";
import { Authentication } from "../../models/index.model";
import { Observable } from "rxjs";
import { Router } from "@angular/router";

@Injectable({
  providedIn: "root"
})
export class LoginUseCaseService {
  constructor(private _router: Router, private _loginService: LoginService) {}

  postServiceLoginUseCase(autentication: Authentication) {
    this._loginService.postLogin(autentication).subscribe(
      response => {
        if (response != null) {
          this._router.navigate(["/menu"]);
          sessionStorage.error = JSON.stringify(false);
        } else {
          sessionStorage.error = JSON.stringify(true);
        }
        this._loginService.setDataAuthentication(JSON.stringify(response));
      },
      err => {
        console.log("Error data");
      }
    );
  }

  getServiceDataAuthentication(): string {
    return this._loginService.getDataAuthentication();
  }
}
