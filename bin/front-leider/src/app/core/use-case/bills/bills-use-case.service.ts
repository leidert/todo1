import { Injectable } from '@angular/core';
import { Bills, newBillData } from 'src/app/core/models/index.model';
import { Observable } from 'rxjs';
import { BillsService } from '../../services/bills/bills.service';

@Injectable({
  providedIn: 'root'
})
export class BillsUseCaseService {

  constructor(private billsService: BillsService) {}

  postBillervice(bill: newBillData): Observable<newBillData> {
    return this.billsService.saveNewBill(newBillData);
  }
  getAllBillsService(): Observable<Bills[]> {
    return this.billsService.getAllbills();
  }
}
