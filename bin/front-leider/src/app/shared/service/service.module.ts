import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import {
  LoginService,
  BillsService
} from "./index.services";

//import { AuthenticationAbstract } from "../../core/models/login/gateway/autentication-gateway.abstract";
import { BillsAbstract } from "../../core/models/bills/gateway/Bills-gateway.abstract";


@NgModule({
  declarations: [],
  imports: [CommonModule],
  providers: [
    //{ provide: AuthenticationAbstract, useClass: LoginService },
   // { provide: BillsAbstract, useClass: BillsService },
  ]
})
export class ServiceModule {}
