import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ArnRolesService {

  _role = "arn:aws:iam::517949891193:role/CA-ROL-APID";
  
  constructor() { }

  getRole = () => this._role;
  
  setRole = (role: string) => this._role = role;
}
