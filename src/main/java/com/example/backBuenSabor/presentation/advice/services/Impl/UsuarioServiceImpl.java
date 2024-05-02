package com.example.backBuenSabor.presentation.advice.services.Impl;

import com.example.backBuenSabor.presentation.advice.services.IUsuarioService;
import com.example.backBuenSabor.domain.entities.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario,Long> implements IUsuarioService {
}
