import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { SeeproductComponent } from './seeproduct/seeproduct.component';
import { AddproductComponent } from './addproduct/addproduct.component';
import { SeeuserComponent } from './seeuser/seeuser.component';
import { SeerequestComponent } from './seerequest/seerequest.component';
import { FormsModule } from '@angular/forms';
import { VisitorproductComponent } from './visitorproduct/visitorproduct.component';
import { UserproductComponent } from './userproduct/userproduct.component';
import { ViewcartComponent } from './viewcart/viewcart.component';
import { UpdateuserComponent } from './updateuser/updateuser.component';
import { SendrequestComponent } from './sendrequest/sendrequest.component';
import { PaymentComponent } from './payment/payment.component';
import { UserpageComponent } from './userpage/userpage.component';
import { AdminpageComponent } from './adminpage/adminpage.component';
import { HistoryComponent } from './history/history.component';
import { UserhistoryComponent } from './userhistory/userhistory.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    HeaderComponent,
    LoginComponent,
    RegistrationComponent,
    PagenotfoundComponent,
    SeeproductComponent,
    AddproductComponent,
    SeeuserComponent,
    SeerequestComponent,
    VisitorproductComponent,
    UserproductComponent,
    ViewcartComponent,
    UpdateuserComponent,
    SendrequestComponent,
    PaymentComponent,
    UserpageComponent,
    AdminpageComponent,
    HistoryComponent,
    UserhistoryComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
