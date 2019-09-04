import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from "@angular/core";
import { CommonModule } from "@angular/common";
import {
  BillsComponent,
 // LoginComponent,
} from "../pages";

@NgModule({
  declarations: [
    BillsComponent,
  //  LoginComponent
  ],
  imports: [CommonModule],
  exports: [
    BillsComponent,
      //  LoginComponent
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ModuleModule {}
