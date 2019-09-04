import { TestBed, async, ComponentFixture } from "@angular/core/testing";
import { RouterTestingModule } from "@angular/router/testing";
import { AppComponent } from "./app.component";
import { BrowserModule, By } from "@angular/platform-browser";
import { FormsModule } from "@angular/forms";
import { DebugElement } from "@angular/core";
import { NgZorroAntdModule } from "ng-zorro-antd";
//import { LoginComponent } from './components/login/login.component';
//import { HeaderComponent } from './components/shared/header/header.component';
//import { FooterComponent } from './components/shared/footer/footer.component';

//LoginComponent,
//HeaderComponent,
//FooterComponent

describe("test AppComponent", () => {
  let component: AppComponent;
  let fixture: ComponentFixture<AppComponent>;
  let de: DebugElement;
  let el: HTMLElement;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        BrowserModule,
        FormsModule,
        NgZorroAntdModule
      ],
      declarations: [AppComponent]
    });

    fixture = TestBed.createComponent(AppComponent);
    component = fixture.componentInstance;
  });

  it("create app component", () => {
    fixture.detectChanges();
    expect(component).toBeTruthy();
  });
});
