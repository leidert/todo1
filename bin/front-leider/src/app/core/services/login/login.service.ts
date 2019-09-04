import { Injectable } from "@angular/core";
import {
  HttpClient,
  HttpHeaders,
  HttpErrorResponse
} from "@angular/common/http";
import { Observable, of } from "rxjs";
import { catchError, tap } from "rxjs/operators";
import { Authentication } from "../../models/index.model";
import { AuthenticationAbstract } from "../../models/login/gateway/autentication-gateway.abstract";
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: "root"
})
export class LoginService extends AuthenticationAbstract {
  readonly baseUrl = `${environment.host}:${environment.port}`;
  //readonly loginUrl = `https://us-central1-training-sofka-232216.cloudfunctions.net/function-7`;
  private nameSessionStorage = "sofkiano";

  constructor(private http: HttpClient) {
    super();
  }

  postLogin(autentication: Authentication): Observable<Authentication[]> {
    const loginUrl = `${this.baseUrl}/sofkiano/login`;
    let headers = new HttpHeaders({
      "Content-Type": "application/x-www-form-urlencoded",
      email: autentication.email,
      password: autentication.password
    });
    return this.http
      .post<Authentication[]>(loginUrl, autentication, {
        headers: headers
      })
      .pipe(
        tap((authentication: Authentication[]) =>
          this.log(`Data send by back-end =${authentication}`)
        ),
        catchError(this.handleError<Authentication[]>("postLogin"))
      );
  }

  setDataAuthentication(data: string) {
    sessionStorage.setItem(this.nameSessionStorage, data);
  }

  getDataAuthentication(): string {
    return sessionStorage.getItem(this.nameSessionStorage);
  }

  removeDataAuthentication() {
    try {
      sessionStorage.removeItem(this.nameSessionStorage);
    } catch (error) {
      return error;
    }
    return { message: "Se cerro la sesión con éxito." };
  }

  private handleError<T>(operation = "operation", result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }

  private log(message: string) {
    console.log("loginService: " + message);
  }
}
