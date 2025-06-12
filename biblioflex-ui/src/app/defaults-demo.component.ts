import { Component, ElementRef } from '@angular/core';

@Component({
  selector: 'app-defauts-demo',
  template: `<div #dangerZone></div>`,
})
export class DefautsDemoComponent {
  public a = 5; // ❌ Mauvais nommage
  public b = 5; // ❌ Code dupliqué

  constructor(private el: ElementRef) {}

  ngOnInit() {
    if (this.a = 5) { // ❌ Bug : affectation au lieu de comparaison
      console.log("Toujours vrai"); // ❌ Code inutile
    }

    if (true) { // ❌ Code mort (toujours vrai)
      console.log("Ce bloc est toujours exécuté");
    }

    if (this.a > 0) {
      return true;
    } else {
      return false; // ❌ Else inutile
    }

    this.ancienneMethode(); // ❌ Fonction non utilisée ailleurs
    this.el.nativeElement.innerHTML = location.href; // ⚠️ OWASP XSS potentiel
  }

  ancienneMethode() {
    let x: any = 'texte'; // ❌ Type any utilisé
    console.log(x);
  }

  functionDupliquee() { // ❌ Fonction dupliquée
    console.log("Fonction 1");
  }

  functionDupliquee2() { // ❌ Fonction dupliquée (même contenu)
    console.log("Fonction 1");
  }

  fonctionComplexe(n: number): string { // ❌ Complexité cyclomatique élevée
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
