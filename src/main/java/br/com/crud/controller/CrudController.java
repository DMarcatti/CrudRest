package br.com.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.crud.error.CrudErrorType;
import br.com.crud.model.Usuario;
import br.com.crud.service.CrudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Usuario")
public class CrudController {

	@Autowired
	private CrudService service;
	

	
	@RequestMapping(value="/deletAll" , method=RequestMethod.DELETE)
    public ResponseEntity delete() {
		service.deleteAllUsuarios();
    	return new ResponseEntity(HttpStatus.OK);
    }	
	

    @RequestMapping(value="/delete/{id}" , method=RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("id") long id) {
    	service.deleteUsuarioById(id);
    	return new ResponseEntity(HttpStatus.OK);
    }	
	
	
	@RequestMapping(value="/salvar" , method=RequestMethod.POST)
    public ResponseEntity<Usuario> gravar( @RequestBody Usuario usuario) {
//    	if(service.isUsuarioExist(usuario)){
//            return new ResponseEntity(new CrudErrorType("User with id " + usuario.getNome() 
//                    + " not found"), HttpStatus.NO_CONTENT);
//    		
//    	}
    	service.saveUsuario(usuario);
    	return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }	

    @ApiOperation(value = "findById", 
            notes = "Retrieves a single customer", response = Usuario.class)
    @RequestMapping(value="/pesquisa/{id}" , method=RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity findById(@Valid @PathVariable("id") long id) {
    	Usuario usuario = service.findById(id);
        if (usuario == null) {
            return new ResponseEntity(new CrudErrorType("User with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }    	
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }	
    
    @RequestMapping(value="/listar" , method=RequestMethod.GET)
    public ResponseEntity<List<Usuario>> findAll() {
    	return new ResponseEntity<List<Usuario>>(service.findAllUsuarios(), HttpStatus.OK);
    }	

    @RequestMapping(value="/pesquisa_nome/{nome}" , method=RequestMethod.GET)
    public ResponseEntity<List<Usuario>> findByNome(@PathVariable("nome") String nome) {
    	List<Usuario> usuarios = service.findByName(nome);
        if (usuarios == null) {
            return new ResponseEntity(new CrudErrorType("User(s) with nome " + nome
                    + " not found"), HttpStatus.NOT_FOUND);
        }    	
        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }	

    
    
}
