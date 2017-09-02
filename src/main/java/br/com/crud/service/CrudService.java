package br.com.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crud.dao.EmpresaImp;
import br.com.crud.dao.UsuarioImp;
import br.com.crud.model.Empresa;
import br.com.crud.model.Usuario;

@Service
public class CrudService {

	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Usuario> usuarios;
	
	@Autowired
	UsuarioImp usuarioDao;
	
	@Autowired
	EmpresaImp empresaDao;

//	static{
//    	usuarios = populateDummyUsuarios();
//
//    }	z
	

    public List<Empresa> findAllEmpresas() {
    	
        return empresaDao.findAll();
    }
	
    public List<Usuario> findAllUsuarios() {
        return usuarioDao.findAllUsuarios();
    }
     
    public Usuario findById(long id) {
    	
    	return usuarioDao.findById(id);
    	
//        for(Usuario Usuario : usuarios){
//            if(Usuario.getId() == id){
//                return Usuario;
//            }
//        }
//        return null;
    }
     
    public List<Usuario> findByName(String name) {
    	
    	return usuarioDao.findByName(name);
//        for(Usuario Usuario : usuarios){
//            if(Usuario.getNome().equalsIgnoreCase(name)){
//                return Usuario;
//            }
//        }
//        return null;
    }
     
    public void saveUsuario(Usuario usuario) {
        usuario.setId(counter.incrementAndGet()+usuarioDao.findAllUsuarios().size());
        usuarioDao.salvar(usuario);
    }

    
    public void saveEmpresa(Empresa empresa) {
        empresaDao.salvar(empresa);
    }    
    
    
    public void updateUsuario(Usuario Usuario) {
        int index = usuarios.indexOf(Usuario);
        usuarios.set(index, Usuario);
    }
 
    public void deleteUsuarioById(long id) {
    	usuarioDao.deleteUsuarioById(id);
//        for (Iterator<Usuario> iterator = usuarios.iterator(); iterator.hasNext(); ) {
//            Usuario Usuario = iterator.next();
//            if (Usuario.getId() == id) {
//                iterator.remove();
//            }
//        }
    }
 
    public boolean isUsuarioExist(Usuario usuario) {
        return findByName(usuario.getNome())!=null;
    }
     
    public void deleteAllUsuarios(){
        usuarioDao.deleteAllUsuarios();
    }
 
    public List<Usuario> populateDummyUsuarios(){
//        List<Usuario> Usuarios = new ArrayList<Usuario>();
//
//        Usuarios.add(new Usuario(counter.incrementAndGet(),"Sam","Sanx", "123456"));
//        Usuarios.add(new Usuario(counter.incrementAndGet(),"Tom","Tomx", "123456"));
//        Usuarios.add(new Usuario(counter.incrementAndGet(),"Jerome","Jeromex", "123456"));
//        Usuarios.add(new Usuario(counter.incrementAndGet(),"Silvia","Silviax","123456"));
        
        return usuarioDao.findAllUsuarios() ;        
        
        //return Usuarios;
    }	
	
	
}
