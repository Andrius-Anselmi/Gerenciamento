package dev.java10x.Gerenciamento.Funcionario;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/bemvindo")
    public String boasVindas() {
        return "Seja bem vindo";
    }

    //CADASTRAR FUNCIONARIO
    @PostMapping("/cadastro")
    public FuncionarioModel criarFuncionario(@RequestBody FuncionarioModel funcionarioModel) {
        return funcionarioService.criarFuncionario(funcionarioModel);
    }
    //EXIBIR FUNCIONARIOS
    @GetMapping("/exibir")
    public List<FuncionarioModel> exibirFuncionarios() {
        return funcionarioService.exibirFuncionarios();
    }

    //EXIBIR FUNCIONARIO POR ID
    @GetMapping("/exibir/{id}")
    public FuncionarioModel exibirFuncionarioPorId(@PathVariable Long id) {
        return funcionarioService.exibirFuncionariosPorId(id);
    }
    //DELETAR FUNCIONARIO POR ID
    @DeleteMapping("/deletar/{id}")
    public String deletarFuncionario(@PathVariable Long id) {
        funcionarioService.deletarFuncionarioPorId(id);
        return " funcionario deletado";
    }
    //ALTERAR FUNCIONARIO POR ID
    @PutMapping("/alterar/{id}")
    public FuncionarioModel alterarFuncionario(@PathVariable Long id, @RequestBody FuncionarioModel funcionario) {
        return funcionarioService.alterarFuncionarioPorId(id,funcionario);
    }


}
