package com.pedrovbo.emprestimolivros.service;

import com.pedrovbo.emprestimolivros.model.Usuario;
import com.pedrovbo.emprestimolivros.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
