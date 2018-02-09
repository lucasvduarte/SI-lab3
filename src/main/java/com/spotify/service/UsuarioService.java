package com.spotify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spotify.models.Usuario;
import com.spotify.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	private BCryptPasswordEncoder bcryptpsse = new BCryptPasswordEncoder();
	
	public Usuario cadastroUsuario(Usuario novoUsuario) {
		Usuario usuario = usuarioRepository.findAllByEmailUsuario(novoUsuario.getEmailUsuario());
		String senhaCriptografada = bcryptpsse.encode(novoUsuario.getPassword());
		if(usuario == null){
			novoUsuario.setSenhaUsuario(senhaCriptografada);
			return usuarioRepository.save(novoUsuario);	
		}
		return null;
	}
	
//	public Usuario logarUsuario(Usuario usuario) {
//		Usuario usuario2 = usuarioRepository.findAllByEmailUsuario(usuario.getUsername());
//		if(usuario2 != null && usuario2.getPassword().equals(usuario.getPassword())){
//			return usuarioRepository.save(usuario2);
//		}
//		return null;
//	}
//	

}