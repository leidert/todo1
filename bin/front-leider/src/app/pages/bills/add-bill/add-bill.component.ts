import { Component, OnInit } from '@angular/core';
import { NzModalService } from 'ng-zorro-antd';
import {FormBuilder, FormGroup } from '@angular/forms'
import { BillsComponent } from '../bills.component';
import { BillsService } from '../../../core/services/bills/bills.service';
import {Bills} from 'src/app/core/models/bills/entity/Bills';
import { Subscription } from 'rxjs';
import { newBillData } from 'src/app/core/models/bills/entity/newBillData';

@Component({
  selector: 'app-add-bill',
  templateUrl: './add-bill.component.html',
  styleUrls: ['./add-bill.component.css']
})
export class AddBillComponent implements OnInit {
  visible = false;
  formulario: FormGroup;
  saveNewBillsApiSub: Subscription;
  AllBill: newBillData;

  constructor(private builder: FormBuilder, private bill: BillsComponent, private api: BillsService) { 
    this.formulario = this.builder.group({
      name: [""],
      companyL: [""],
      telephone: [""],
      address: [""],
      city: [""],
      currency: [""],
      description: [""],
      amountHoursWorkedS: [""],
      discountProduct: [""],
      total: [""],
    })
  }

  enviar(bill:newBillData) {
    this.saveNewBillsApiSub = this.api.saveNewBill(bill).subscribe(
      AllBill => {this.AllBill = AllBill;
                  this.bill.getAllbillsApi() });
  }

  close(): void {
    this.visible = false;
    this.bill.close()
  }

  ngOnInit() {
  }

}
