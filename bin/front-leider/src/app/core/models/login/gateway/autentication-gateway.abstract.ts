import { Observable } from "rxjs";
import { Authentication } from "../../index.model";

export abstract class AuthenticationAbstract {
  abstract postLogin(
    autentication: Partial<Authentication>
  ): Observable<Authentication[]>;
}
