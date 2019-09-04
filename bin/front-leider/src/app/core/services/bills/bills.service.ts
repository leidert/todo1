import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, } from "@angular/common/http";
import { Observable } from "rxjs";
import { Bills } from "../../models/bills/entity/Bills";
import { newBillData } from "../../models/bills/entity/newBillData";
import { catchError, map, tap } from "rxjs/operators";
import { environment } from "src/environments/environment";
import { BillsAbstract } from "../../models/bills/gateway/bills-gateway.abstract";



const httpOptions = {
  headers: new HttpHeaders({ "Content-Type": "application/json" })
};

@Injectable({
  providedIn: "root"
})
export class BillsService extends BillsAbstract {

  
  private clientsUrl = `${environment.host}:${environment.port}/bills`;

  constructor(private http: HttpClient) {
    super();
  }

  

  getAllbills(): Observable<Bills[]> {
    return this.http.get<Bills[]>(`http://localhost:8080/bills/allBill`);
  }

  getBillByName(nameClient:string): Observable<Bills[]> {
    return this.http.get<Bills[]>(this.clientsUrl);
  } 
  updateBills(id: string, data: newBillData): Observable<newBillData> {
    return this.http.put<newBillData>(`http://localhost:8080/bills/updateByIdBill/${id}`, JSON.stringify(data));
    
  }

  deleteBillsById(id: string): Observable<Bills> {
    return this.http.delete<Bills>(`http://localhost:8080/bills/deleteBillById/${id}`);
  }

  getBillById(id: string): Observable<Bills> {
    return this.http.get<Bills>(`http://localhost:8080/bills/getByIdBill/${id}`);
  }

  saveNewBill(newBillData): Observable<newBillData> {
    return this.http.post<newBillData>(`http://localhost:8080/bills/saveNewBill`, JSON.stringify(newBillData));
  }
}
