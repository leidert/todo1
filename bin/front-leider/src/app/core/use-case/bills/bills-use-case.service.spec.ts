import { TestBed } from "@angular/core/testing";
import { BillsUseCaseService } from "./bills-use-case.service";
import { SofkianoService } from "../../services/sofkiano/sofkiano.service";
import { HttpClientTestingModule } from "@angular/common/http/testing";
import { BillsService } from "../../services/bills/bills.service";

describe("SofkianoUseCaseService", () => {
  let billsUseCaseService: BillsUseCaseService;
  let billsService: BillsService;
  let spy;
  let spyPost;
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [BillsUseCaseService, BillsService]
    });
   billsUseCaseService = TestBed.get(BillsUseCaseService);
    billsService = TestBed.get(BillsService);
    spy = spyOn(billsService, "getAllBills").and.callThrough();
    spyPost = spyOn(billsService, "postBill").and.callThrough();
  });

  it("should be created sofkiano service use-case", () => {
    expect(billsUseCaseService).toBeTruthy();
  });

  it("the sofkianoService integrated with SofkianoUseCaseService ", () => {
    billsUseCaseService = new BillsUseCaseService(spy);
    expect(billsUseCaseService.getAllBillsService).toBeTruthy();
  });

  it("post method SofkianoService intedrated with SofkianoUseCaseService", () => {
    billsUseCaseService = new BillsUseCaseService(spyPost);
    expect(billsUseCaseService.postBillervice).toBeTruthy();
  });
});
