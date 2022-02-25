package com.pedrovbo.emprestimolivros.service;

import com.pedrovbo.emprestimolivros.model.Emprestimo;
import com.pedrovbo.emprestimolivros.model.Usuario;
import com.pedrovbo.emprestimolivros.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return null;
    }

    @Transactional
    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Page<Usuario> findAll(Pageable pageable){
        return usuarioRepository.findAll(pageable);
    }

    public Optional<Usuario> findById(Long id){
        return usuarioRepository.findById(id);
    }

    @Transactional
    public void delete(Usuario usuario){
        usuarioRepository.delete(usuario);
    }
}
