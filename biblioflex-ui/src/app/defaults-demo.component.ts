import { Component, ElementRef } from '@angular/core';

@Component({
  selector: 'app-defauts-demo',
  template: `<div #dangerZone></div>`,
})
export class DefautsDemoComponent {
  public a = 5;
  public b = 5;

  constructor(private el: ElementRef) {}

  ngOnInit() {
    if (this.a = 5) {
      console.log("Toujours vrai");
    }

    if (true) {
      console.log("Ce bloc est toujours exécuté");
    }

    if (this.a > 0) {
      return true;
    } else {
      return false;
    }

    this.ancienneMethode();
    this.el.nativeElement.innerHTML = location.href;
  }

  ancienneMethode() {
    let x: any = 'texte';
    console.log(x);
  }

  functionDupliquee() {
    console.log("Fonction 1");
  }

  functionDupliquee2() {
    console.log("Fonction 1");
  }

  fonctionComplexe(n: number): string { 
    if (n < 0) {
      if (n < -5) {
        if (n < -10) {
          if (n < -20) {
            return "Trop petit";
          }
        }
      }
    }
    return "OK";
  }
}
