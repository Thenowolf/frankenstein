import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user/user.component';
import { SignupComponent } from './component/signup/signup.component';

const routes: Routes = [
  {path: "users", component: UserComponent},
  {path: "user/signup", component: SignupComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
