import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { AuthenticationAbstract } from "../../core/models/login/gateway/autentication-gateway.abstract";
import { LoginUseCaseService } from "src/app/core/use-case/login/login-use-case.service";

@NgModule({
  declarations: [],
  imports: [CommonModule],
  providers: [
    { provide: AuthenticationAbstract, useClass: LoginUseCaseService }
  ]
})
export class ServiceUseCaseModule {}
