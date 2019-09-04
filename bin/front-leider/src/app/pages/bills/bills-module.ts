import { NgModule } from "@angular/core";
import { AddBillComponent } from "./add-bill/add-bill.component";
import { EditBillComponent } from "./edit-bill/edit-bill.component";
import { BillsComponent } from "./bills.component";

@NgModule({
    declarations:[
        BillsComponent,
        AddBillComponent
    ],
    imports:[],
    exports:[
        AddBillComponent,
    ]
})
export class BillsModule {}