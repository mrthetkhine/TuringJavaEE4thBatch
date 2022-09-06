import { Component, OnInit } from '@angular/core';
import Swal from "sweetalert2";
import {AuthService} from "../../service/auth.service";

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.scss']
})
export class LogoutComponent implements OnInit {

  constructor(private authService:AuthService) { }

  ngOnInit(): void {
  }
  logout()
  {
    Swal.fire({
      title: 'Are you sure you want to logout?',
      /*text: 'You will not be able to recover this imaginary file!',*/
      /* icon: 'warning',*/
      showCancelButton: true,
      confirmButtonText: 'Confirm',
      cancelButtonText: 'Cancel'
    }).then((result) => {
      if (result.isConfirmed) {
        this.authService.logout();

      }
    });
  }
}
