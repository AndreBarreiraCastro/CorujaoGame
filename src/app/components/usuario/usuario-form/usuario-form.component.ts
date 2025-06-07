import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { UsuarioService } from '../../../services/usuario.service';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { NgFor, NgIf } from '@angular/common';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { Usuario } from '../../../models/usuario.model';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatSnackBar } from '@angular/material/snack-bar';
import { EstadoService } from '../../../services/estado.service';
import { MatSelectModule } from '@angular/material/select';
import { Perfil } from '../../../models/perfil';
import { PerfilService } from '../../../services/perfil.service';
import { NgxMaskDirective, provideNgxMask } from 'ngx-mask';
import { TelefonePipe } from '../../../pipes/telefone.pipe';
@Component({
  selector: 'app-usuario-form',
  imports: [NgxMaskDirective,NgFor,MatSnackBarModule,RouterLink, NgIf, ReactiveFormsModule, MatFormFieldModule, MatInputModule,
    MatButtonModule,TelefonePipe, MatToolbarModule, MatIconModule, MatCardModule,MatSelectModule,
    MatIconModule], providers: [provideNgxMask()],
  templateUrl: './usuario-form.component.html',
  
  styleUrl: './usuario-form.component.css'
})
export class UsuarioFormComponent {
  formGroup: FormGroup;
   usuario: Usuario[] = []; // Aqui vai a lista de estados
   perfis: Perfil[] = [];


  constructor( private snackBar: MatSnackBar,private formBuilder: FormBuilder,
    private usuarioService: UsuarioService,private perfilService: PerfilService,
    private router: Router,
    private activatedRoute: ActivatedRoute) {

    const usuario: Usuario = this.activatedRoute.snapshot.data['usuario'];

    this.formGroup = this.formBuilder.group({
      nome: [(usuario && usuario.nome) ? usuario.nome : '', Validators.required],
      sobrenome: [(usuario && usuario.sobrenome) ? usuario.sobrenome: '', Validators.required],
     telefone: [(usuario && usuario) ? usuario.telefone : '', Validators.required],
     cpf: [(usuario && usuario) ? usuario.cpf : '', Validators.required],
     email: [(usuario && usuario) ? usuario.email : '', Validators.required],
     idperfilUsuario: [(usuario && usuario) ? usuario.perfil : '', Validators.required],
    })

  }

ngOnInit(): void {
  this.perfilService.findAll().subscribe({
    next: (data) => {
      this.perfis = data;
    },
    error: (err) => console.error('Erro ao carregar usuarios:', err)
  });
}
  salvar() {
    if (this.formGroup.valid) {
      const usuario = this.formGroup.value;
      if(usuario.id == null) {
  
        this.usuarioService.insert(usuario).subscribe({
          next: () => {
            this.router.navigateByUrl('/usuarios');
                this.snackBar.open('Operação realizada com sucesso!', 'Fechar', {
  duration: 3000,horizontalPosition: 'end',
  verticalPosition: 'top'
});
          },
          error: (errorResponse) => {
            console.log('Erro ao gravar' + JSON.stringify(errorResponse));

   this.snackBar.open('Operação não realiza!', 'Fechar', {
  duration: 3000,horizontalPosition: 'end',
  verticalPosition: 'top'
});
          }
        })
      }
      this.router.navigateByUrl('/usuarios').then(() => {
      location.reload();  // Isso faz o F5 automaticamente.
    });
    }
  }

}

