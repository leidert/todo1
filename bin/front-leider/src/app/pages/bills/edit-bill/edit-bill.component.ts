import { Component, OnInit, Input } from '@angular/core';
import { BillsService } from '../../../core/services/bills/bills.service';
import { newBillData } from 'src/app/core/models/bills/entity/newBillData';

@Component({
  selector: 'app-edit-bill',
  templateUrl: './edit-bill.component.html',
  styleUrls: ['./edit-bill.component.css']
})
export class EditBillComponent implements OnInit {
  respuesta: newBillData;
  isVisible = false;
  bill: any = {};
  newBillData: newBillData = this.bill;
  @Input() data: any;

  constructor( private api: BillsService ) { }

  updacteBillIdApi(id, BillData): void{
    this.api.updateBills(id, BillData).subscribe(
      respuesta => {
        this.respuesta = respuesta;
        this.api.getAllbills();
      });
  }
  getAllbillIdApi(bill): void{
    this.api.getBillById(bill).subscribe(
      allBill => {
        this.bill = allBill;
      });
 }
 UpdateOk(value){
  console.log(value);
  this.parseBillDada();
  this.updacteBillIdApi(value.idBillClients, this.newBillData);
}

  parseBillDada(){
    this.newBillData.idBill = this.data.idBillClients;
    this.newBillData.name = this.data.nameClients;
    this.newBillData.companyL = this.data.companyLeaders;
    this.newBillData.telephone =this. data.telephoneClients;
    this.newBillData.address = this.data.addressClients;
    this.newBillData.city = this.data.cityClients;
    this.newBillData.currency = this.data.currencyToPays;
    this.newBillData.total = this.data.fullPayments;
    this.newBillData.amountHoursWorkedS = this.data.amountHourWorked;
    this.newBillData.discountProduct = this.data.discounts;
    this.newBillData.description = this.data.descriptionProducts;
    console.log(this.newBillData);
  }
  handleOk() {
    this.isVisible = false;
    this.parseBillDada()
    this.updacteBillIdApi(this.bill.idBillClients, this.newBillData);
  }

  ngOnInit() {
    
  }
  
}
