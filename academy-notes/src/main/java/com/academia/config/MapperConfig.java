package com.academia.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuracion para implemetar los Mapper de las Entities
 */
@Configuration
public class MapperConfig {

    @Bean("estudianteMapper")
    public ModelMapper estudianteMapper(){
        return new ModelMapper();
    }

    @Bean("cursoMapper")
    public ModelMapper cursoMapper(){
        return new ModelMapper();
    }

    @Bean("matriculaMapper")
    public ModelMapper matriculaMapper(){
        return new ModelMapper();
    }

}
