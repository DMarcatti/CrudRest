package br.com.crud.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.crud.error.CrudErrorType;
import br.com.crud.model.Empresa;
import br.com.crud.model.Usuario;
import br.com.crud.service.CrudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Exemplo Spring Boot, Rest, jdbcTemplate, PostGres 
 * @author Diego Marcatti
 * @version 1.0 - 30/05/17
 * @since 30/05/17
 */

@CrossOrigin
@RestController
@Api(value = "Usuario")
public class CrudController {

	@Autowired
	private CrudService service;
	

	
    @ApiOperation(value = "deleteAll", notes = "Remove todos os usuarios cadastrados")
    @RequestMapping(value="/deleteAll" , method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteAll() {
		service.deleteAllUsuarios();
    	return new ResponseEntity(HttpStatus.OK);
    }	

    @ApiOperation(value = "deleteById", notes = "Remove usuario cadastrados por ID")
    @RequestMapping(value="/delete/{id}" , method=RequestMethod.DELETE,
    				produces = { MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity deleteById(@PathVariable("id") long id) {
    	service.deleteUsuarioById(id);
    	return new ResponseEntity(HttpStatus.OK);
    }	

    @ApiOperation(value = "Gravar Empresa", notes = "Grava o Empresa" , response = Empresa.class)
    @RequestMapping(value="/gravar" , method=RequestMethod.POST,
    				produces = { MediaType.APPLICATION_JSON_VALUE,
    							 MediaType.APPLICATION_JSON_VALUE 
    						   }
    			   )
    public ResponseEntity<Empresa> gravar( @RequestBody Empresa empresa) {
    	service.saveEmpresa(empresa);
    	return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
    }	    
    
    

    @ApiOperation(value = "save", notes = "Grava o Usuario" , response = Usuario.class)
    @RequestMapping(value="/save" , method=RequestMethod.POST,
    				produces = { MediaType.APPLICATION_JSON_VALUE,
    							 MediaType.APPLICATION_JSON_VALUE 
    						   }
    			   )
    public ResponseEntity<Usuario> save( @RequestBody Usuario usuario) {
/*    	if(service.isUsuarioExist(usuario)){
            return new ResponseEntity(new CrudErrorType("User with id " + usuario.getNome()
                    + " not found"), HttpStatus.NO_CONTENT);

    	}*/
    	service.saveUsuario(usuario);
    	return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }	

    @ApiOperation(value = "findById", notes = "Pesquisa usuario utilizando ID", response = Usuario.class)
    @RequestMapping(value="/findbyid/{id}" , method=RequestMethod.GET,
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
    
    @RequestMapping(value="/findAll" , method=RequestMethod.GET)
    public ResponseEntity<List<Usuario>> findAll() {
    	return new ResponseEntity<List<Usuario>>(service.findAllUsuarios(), HttpStatus.OK);
    }	

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/findbynome/{name}" , method=RequestMethod.GET)
    public ResponseEntity<List<Usuario>> findByName(@PathVariable("nome") String nome) {
    	List<Usuario> usuarios = service.findByName(nome);
        if (usuarios == null) {
            return new ResponseEntity(new CrudErrorType("User(s) with nome " + nome
                    + " not found"), HttpStatus.NOT_FOUND);
        }    	
        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }

    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/findempresa" , method=RequestMethod.GET)
    public ResponseEntity<List<Empresa>> findempresa() {
    	List<Empresa> empresas = service.findAllEmpresas();
        return new ResponseEntity<List<Empresa>>(empresas, HttpStatus.OK);
    }
    
    
}
