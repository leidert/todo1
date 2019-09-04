import { Component, OnInit } from '@angular/core';
import { NzMessageService } from "ng-zorro-antd";
import { BillsService } from '../../../core/services/bills/bills.service';
import { Subscription, from } from 'rxjs';
import {Bills} from 'src/app/core/models/bills/entity/Bills';
import {BillsUseCaseService } from 'src/app/core/use-case/bills/bills-use-case.service';
import { NzModalService } from 'ng-zorro-antd';

@Component({
  selector: 'app-bills-list',
  templateUrl: './bills-list.component.html',
  styleUrls: ['./bills-list.component.css']
})
export class BillsListComponent implements OnInit {

  getAllbillsApiSub: Subscription;
  AllBill: Bills[];

  constructor(private msg: NzMessageService, private api: BillsService, private billsUseCase: BillsUseCaseService,
    private modalService: NzModalService) { }

    ngOnInit(): void {
      this.getAllbillsApi();
    }
  
    getAllbillsApi(): void {
      this.getAllbillsApiSub = this.api.getAllbills().subscribe(
        AllBill => {this.AllBill = AllBill;
        });
    }



}
