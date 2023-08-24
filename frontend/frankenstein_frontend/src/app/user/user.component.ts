import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.model';
import { UserService } from '../user.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss'],
  //imports: [],
})
export class UserComponent implements OnInit {

  displayedColumns: string[] = ['position', 'name', 'weight'];
  public users!: User[];
  
  constructor(private userService: UserService){

  }

  ngOnInit(): void {
    this.getUsers();
  }

  public getUsers(): void{
    this.userService.getUsers().subscribe(
      (response: User[]) => {
        this.users = response;
      },
      (error:HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

}
