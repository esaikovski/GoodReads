import {Component} from '@angular/core';
import {MatMenuModule} from '@angular/material/menu';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule, MatIconRegistry} from "@angular/material/icon";
import {DomSanitizer} from "@angular/platform-browser";
import {Router} from "@angular/router";

const ACCOUNT_ICON =
  `
  <svg xmlns="http://www.w3.org/2000/svg" height="48" viewBox="0 -960 960 960" width="48">
  <path d="M232.001-253.077q59.923-38.461 118.922-58.961 59-20.5 129.077-20.5t129.384 20.5q59.308 20.5 119.231 58.961 43.615-50.538 64.807-106.692Q814.615-415.923 814.615-480q0-141.538-96.538-238.077Q621.538-814.615 480-814.615t-238.077 96.538Q145.385-621.538 145.385-480q0 64.077 21.5 120.231 21.5 56.154 65.116 106.692Zm247.813-204.231q-53.968 0-90.775-36.994-36.808-36.993-36.808-90.961 0-53.967 36.994-90.775 36.993-36.807 90.961-36.807 53.968 0 90.775 36.993 36.808 36.994 36.808 90.961 0 53.968-36.994 90.775-36.993 36.808-90.961 36.808Zm-.219 357.307q-78.915 0-148.39-29.77-69.475-29.769-120.878-81.576-51.403-51.808-80.864-120.802-29.462-68.994-29.462-148.351 0-78.972 29.77-148.159 29.769-69.186 81.576-120.494 51.808-51.307 120.802-81.076 68.994-29.77 148.351-29.77 78.972 0 148.159 29.77 69.186 29.769 120.494 81.076 51.307 51.308 81.076 120.654 29.77 69.345 29.77 148.233 0 79.272-29.77 148.192-29.769 68.919-81.076 120.727-51.308 51.807-120.783 81.576-69.474 29.77-148.775 29.77Z"/></svg>
  `
;
@Component({
  selector: 'app-user-settings',
  templateUrl: './user-settings.component.html',
  styleUrls: ['./user-settings.component.css'],
  standalone: true,
  imports: [MatButtonModule, MatMenuModule, MatIconModule],
})
export class UserSettingsComponent {
  constructor(iconRegistry: MatIconRegistry, sanitizer: DomSanitizer, private router: Router) {
    iconRegistry.addSvgIconLiteral('thumbs-up', sanitizer.bypassSecurityTrustHtml(ACCOUNT_ICON));
  }

  onSettings(): void {
    this.router.navigate(['/settings']).then(()=> window.location.reload());
  }

  onSignout(): void {
    this.router.navigate(['/home']).then(()=> window.location.reload());
  }
}
