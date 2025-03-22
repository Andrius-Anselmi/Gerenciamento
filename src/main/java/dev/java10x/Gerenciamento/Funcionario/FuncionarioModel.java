package dev.java10x.Gerenciamento.Funcionario;

import dev.java10x.Gerenciamento.Cargo.CargoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_funcionario")
public class FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String cidade;

    //@ManyToOne - MUITOS FUNCIONARIOS PODEM TER UM UNICO CARGO
    @JoinColumn(name = "cargo_id") //Foreing Key ou chave estrangeira
    @ManyToOne
    private CargoModel cargos;


}
