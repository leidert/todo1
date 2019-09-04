import { Observable } from "rxjs";
import { Bills, newBillData } from "../../index.model";

export abstract class BillsAbstract {
  abstract getAllbills(): Observable<Bills[]>;
  abstract updateBills(id: string, data: newBillData): Observable<newBillData>;
  abstract deleteBillsById(id: string): Observable<Bills>;
  abstract getBillById(id: string): Observable<Bills>;
  abstract getBillByName(nameClient: string): Observable<Bills[]>;
  abstract saveNewBill(body: string[]): Observable<newBillData>;
}
