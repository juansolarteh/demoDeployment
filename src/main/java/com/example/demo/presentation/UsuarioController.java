package com.example.demo.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.domain.entity.Usuario;
import com.example.demo.domain.service.IUsuarioService;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Usuario findById(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    @RequestMapping(value = "login/{user}/{cont}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Usuario findByUserPassword(@PathVariable String user, @PathVariable String cont) {
        System.out.println("Realizando operación login => " + user + " " + cont);
        return usuarioService.findByUserPassword(user, cont);
    }
}
