import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { SeeproductComponent } from './seeproduct/seeproduct.component';
import { AddproductComponent } from './addproduct/addproduct.component';
import { SeeuserComponent } from './seeuser/seeuser.component';
import { SeerequestComponent } from './seerequest/seerequest.component';
import { AuthGuard } from './auth.guard';
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

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'aboutus', component: AboutComponent },
  { path: 'login', component: LoginComponent },
  { path: 'registration', component: RegistrationComponent },
  { path: 'visitorproduct', component: VisitorproductComponent },
  {
    path: 'userproduct', component: UserproductComponent, data: {
      canActivate: [AuthGuard],
      role: ['user']
    }
  },
  {
    path: 'seeproduct', component: SeeproductComponent, data: {
      canActivate: [AuthGuard],
      role: ['admin']
    }
  },
  {
    path: 'paymentinfo', component: PaymentComponent, data: {
      canActivate: [AuthGuard],
      role: ['user']
    }
  },
  {
    path: 'userpage', component: UserpageComponent, data: {
      canActivate: [AuthGuard],
      role: ['user']
    }
  },
  {
    path: 'sendrequest', component: SendrequestComponent, data: {
      canActivate: [AuthGuard],
      role: ['user']
    }
  },
  {
    path: 'viewcart', component: ViewcartComponent, data: {
      canActivate: [AuthGuard],
      role: ['user']
    }
  },
  {
    path: 'updateuser', component: UpdateuserComponent
    , data: {
      canActivate: [AuthGuard],
      role: ['user']
    }
  },
  {
    path: 'userhistory', component: UserhistoryComponent, data: {
      canActivate: [AuthGuard],
      role: ['user']
    }
  },
  {
    path: 'history', component: HistoryComponent, data: {
      canActivate: [AuthGuard],
      role: ['admin']
    }
  },
  {
    path: 'addproduct', component: AddproductComponent, data: {
      canActivate: [AuthGuard],
      role: ['admin']
    }
  },
  {
    path: 'seeuser', component: SeeuserComponent, data: {
      canActivate: [AuthGuard],
      role: ['admin']

    }
  },
  {
    path: 'adminpage', component: AdminpageComponent, data: {
      canActivate: [AuthGuard],
      role: ['admin']

    }
  },
  {
    path: 'seerequest', component: SeerequestComponent, data: {
      canActivate: [AuthGuard],
      role: ['admin']
    }
  },
  { path: '**', component: PagenotfoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
