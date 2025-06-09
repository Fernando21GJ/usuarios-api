package com.ebitware.usuarios_api.service;

import com.ebitware.usuarios_api.model.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario crearUsuario(Usuario usuario);
    List<Usuario> obtenerUsuarios();
    Usuario obtenerUsuarioPorId(Long id);
    Usuario actualizarUsuario(Long id, Usuario usuario);
    void eliminarUsuario(Long id);
}
