// package com.Proyecto.service;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.stereotype.Service;

// import com.Proyecto.model.Usuario;

// import jakarta.servlet.http.HttpSession;



// @Service
// public class UserDetailServiceImpl implements UserDetailsService{
	
// 	@Autowired
// 	private UsuarioService usuarioService;
	
// 	@Autowired
// 	private BCryptPasswordEncoder bCrypt;
	
// 	@Autowired
// 	HttpSession session;


// 	@Override
// 	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
// 		Optional<Usuario> optionalUser=usuarioService.findByEmail(username);
// 		if (optionalUser.isPresent()) {
// 			session.setAttribute("idusuario", optionalUser.get().getId());
// 			Usuario usuario= optionalUser.get();
// 			return User.builder().username(usuario.getNombre()).password(bCrypt.encode(usuario.getPassword())).roles(usuario.getTipo()).build();
// 		}else {
// 			throw new UsernameNotFoundException("Usuario no encontrado");			
// 		}
// 	}

// }
