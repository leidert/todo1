import { TestBed, getTestBed } from "@angular/core/testing";

import { LoginService } from "./login.service";
import {
  HttpClientTestingModule,
  HttpTestingController
} from "@angular/common/http/testing";
import { Authentication } from "../../models/index.model";
import { FormsModule } from "@angular/forms";

describe("LoginService", () => {
  let injector: TestBed;
  let service: LoginService;
  let httpMock: HttpTestingController;

  beforeEach(async () => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, FormsModule],
      providers: [LoginService]
    });
    injector = getTestBed();
    service = injector.get(LoginService);
    httpMock = injector.get(HttpTestingController);
  });

  beforeEach(() => {
    let store = {};
    const mockSessionStorage = {
      getItem: (key: string): string => {
        return key in store ? store[key] : null;
      },
      setItem: (key: string, value: string) => {
        store[key] = `${value}`;
      },
      removeItem: (key: string) => {
        delete store[key];
      },
      clear: () => {
        store = {};
      }
    };

    spyOn(sessionStorage, "getItem").and.callFake(mockSessionStorage.getItem);
    spyOn(sessionStorage, "setItem").and.callFake(mockSessionStorage.setItem);
    spyOn(sessionStorage, "removeItem").and.callFake(
      mockSessionStorage.removeItem
    );
    spyOn(sessionStorage, "clear").and.callFake(mockSessionStorage.clear);
  });

  it("should be created", () => {
    expect(service).toBeTruthy();
  });

  describe("#postLogin", () => {
    it("There should be a function called postLogin", () => {
      expect(service.postLogin).toBeDefined();
    });

    it("should post the correct data", () => {
      const bodyLogin = [
        {
          email: "Colanta@test.com",
          password: "64612814"
        }
      ];

      let authentication: Authentication;
      authentication = { email: "Colanta@test.com", password: "64612814" };

      service.postLogin(authentication).subscribe(response => {
        expect(response[0].email).toBe("Colanta@test.com");
        expect(response.length).toBe(1);
        expect(bodyLogin).toEqual(response);
      });

      const req = httpMock.expectOne(
        `http://${service.baseUrl}/sofkiano/login`
      );
      expect(req.request.method).toBe("POST");
      req.flush(bodyLogin);
    });
  });

  describe("#setDataAuthentication", () => {
    it("should store the data in sessionStorage", () => {
      service.setDataAuthentication("somedata");
      expect(sessionStorage.getItem("sofkiano")).toEqual("somedata");
    });
  });

  describe("#getDataAuthentication", () => {
    it("should return stored data from sessionStorage", () => {
      sessionStorage.setItem("sofkiano", "anotherdata");
      expect(service.getDataAuthentication()).toEqual("anotherdata");
    });
  });

  afterEach(() => {
    httpMock.verify();
  });
});
