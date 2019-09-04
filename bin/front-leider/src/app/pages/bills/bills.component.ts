import { Component, OnInit, Output, EventEmitter, ViewChild } from "@angular/core";
import { NzMessageService } from "ng-zorro-antd";
import { BillsService } from '../../core/services/bills/bills.service';
import { Subscription, from } from 'rxjs';
import {Bills} from 'src/app/core/models/bills/entity/Bills';
import { NzModalService } from 'ng-zorro-antd';
import { EditBillComponent } from "./edit-bill/edit-bill.component";


@Component({
  selector: "app-bills",
  templateUrl: "./bills.component.html",
  styleUrls: ["./bills.component.css"]
})

export class BillsComponent implements OnInit {

  
  getAllbillsApiSub: Subscription;
  deletebillsApiSub: Subscription;
  isVisible = false;
  visible = false;
  DataUpdate:string="";
  Ed:EditBillComponent;
  AllBill: Bills[];
  @Output() public billObject = new EventEmitter<any>();
  @ViewChild(EditBillComponent) hijo: EditBillComponent;
  
  constructor(private msg: NzMessageService, private api: BillsService, private modalService: NzModalService) {}

  
  

  ngOnInit(): void {
    this.getAllbillsApi();
  }

  getAllbillsApi(): void { 
    this.getAllbillsApiSub = this.api.getAllbills().subscribe(
      AllBill => {this.AllBill = AllBill;
      });
  }

  deleteBillsApi(bill): void {
    this.deletebillsApiSub = this.api.deleteBillsById(bill).subscribe(
      AllBill => { this.getAllbillsApi() });
  }

  open(): void {
    this.visible = true;
  }

  close(): void {
    this.visible = false;
  }

  showModal(bill): void {
    console.log(bill)
    this.DataUpdate = bill;
    this.isVisible = true;
  }



  handleOk(): void {
    this.hijo.UpdateOk(this.DataUpdate);
    this.isVisible = false;
  }

  handleCancel(): void {
    console.log('Button cancel clicked!');
    this.isVisible = false;
  }

  ngOnDestroy() {
    if (this.getAllbillsApiSub) {
      this.getAllbillsApiSub.unsubscribe();
    }
  }

  showDeleteConfirm(bills): void {
    this.modalService.confirm({
      nzTitle: 'Se eliminara la factura de '+bills.nameClients+'',
      nzContent: '<b style="color: red;">¿Realmente quiere eliminar esta factura?</b>',
      nzOkText: 'Yes',
      nzOkType: 'danger',
      nzOnOk: () => this.deleteBillsApi(bills.idBillClients),
      nzCancelText: 'No',
      nzOnCancel: () => console.log('Cancel')
    });
  }

  edit(item: any): void {
    this.msg.success(item.email);
  }
  
  
}
