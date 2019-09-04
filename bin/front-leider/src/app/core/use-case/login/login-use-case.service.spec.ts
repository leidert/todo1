import { TestBed, getTestBed } from "@angular/core/testing";

import { LoginUseCaseService } from "./login-use-case.service";
import { HttpClientTestingModule } from "@angular/common/http/testing";
import { RouterTestingModule } from "@angular/router/testing";
import { Router } from "@angular/router";
import { Authentication } from "../../models/index.model";
import { of } from "rxjs";

describe("LoginUseCaseService", () => {
  let injector: TestBed;
  let service: LoginUseCaseService;
  let router: Router;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, RouterTestingModule],
      providers: [LoginUseCaseService]
    });
    injector = getTestBed();
    service = injector.get(LoginUseCaseService);
  });

  it("should be created", () => {
    //const service: LoginUseCaseService = TestBed.get(LoginUseCaseService);
    expect(service).toBeTruthy();
  });

  it("should be creted the function postLogin", () => {
    //const service: LoginUseCaseService = TestBed.get(LoginUseCaseService);
    expect(service.postServiceLoginUseCase).toBeDefined();
  });

  describe("#postServiceLoginUseCase", () => {
    let authentication: Authentication;
    let mockLoginService;

    beforeEach(() => {
      authentication = { email: "Colanta@test.com", password: "64612814" };

      mockLoginService = jasmine.createSpyObj([
        "postLogin",
        "setDataAuthentication"
      ]);

      router = injector.get(Router);
      spyOn(router, "navigateByUrl");

      service = new LoginUseCaseService(router, mockLoginService);
    });

    it("should send data", () => {
      const bodyLogin = {
        email: "Colanta@test.com",
        password: "64612814"
      };

      mockLoginService.postLogin.and.returnValue(of(true));

      service.postServiceLoginUseCase(authentication);
      expect(mockLoginService.postLogin).toHaveBeenCalledWith(bodyLogin);
    });
  });
});
