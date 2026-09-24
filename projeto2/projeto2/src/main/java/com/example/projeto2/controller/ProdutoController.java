package com.example.projeto2.controller;

import com.example.projeto2.entity.ProdutoEntity;
import com.example.projeto2.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<ProdutoEntity> listarTodos(){
        return service.listarTodosProdutos();

    }
    @PostMapping
    public ResponseEntity<Map<String, String>> salvar(@RequestBody ProdutoEntity produto){
        service.salvarProduto(produto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem","Produto salvo com suceeso!"));

    }
    @PutMapping
    public ResponseEntity<Map<String, String>> atualizar(
            @PathVariable Long id,
            @RequestBody ProdutoEntity produto){
        service.atualizarProduto(id, produto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem","produto atualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable Long id){
        service.excluirProduto(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem"," produto excluido com sucesso"));
    }
}
