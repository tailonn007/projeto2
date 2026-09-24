package com.example.projeto2.service;

import com.example.projeto2.entity.ProdutoEntity;
import com.example.projeto2.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    //GET
    public List<ProdutoEntity> listarTodosProdutos(){
        return repository.findAll();

    }

    // POST
    public ProdutoEntity salvarProduto(ProdutoEntity produto) {
        if (repository.findByNome(produto.getNome()).isPresent())
            throw new IllegalArgumentException("Produto ja cadastrado!");

        return repository.save(produto);

    }
    // UPDATE
    public ProdutoEntity atualizarProduto(Long id, ProdutoEntity produto){
        if (!repository.existsById(id))
            throw new IllegalArgumentException("produto não encontrado!");

        produto.setId(id);
        return repository.save(produto);
    }
    // DELETE
    public void excluirProduto(Long id){
        if (!repository.existsById(id))
            throw new IllegalArgumentException("Deletar produto.");

        repository.deleteById(id);


    }

}
