package com.ebitware.usuarios_api.service;

import com.ebitware.usuarios_api.Exception.ResourceNotFoundException;
import com.ebitware.usuarios_api.model.Usuario;
import com.ebitware.usuarios_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuarioDetalles) {
        Usuario usuario = obtenerUsuarioPorId(id);
        usuario.setNombre(usuarioDetalles.getNombre());
        usuario.setCorreo(usuarioDetalles.getCorreo());
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
