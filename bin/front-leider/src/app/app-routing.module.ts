import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { BillsComponent } from "./pages/bills/bills.component";
import { BillsListComponent } from './pages/bills/bills-list/bills-list.component';

const routes: Routes = [
  { path: "", redirectTo: "/bills", pathMatch: "full" },
  {
    path: "bills",
    component: BillsComponent
  },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
