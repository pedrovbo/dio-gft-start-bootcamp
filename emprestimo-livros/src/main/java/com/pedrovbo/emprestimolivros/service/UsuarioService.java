package com.pedrovbo.emprestimolivros.service;

import com.pedrovbo.emprestimolivros.model.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario createUsuario(Usuario usuario);
    List<Usuario> getAllUsuarios();

}
