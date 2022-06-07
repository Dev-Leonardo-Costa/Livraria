package br.com.livraria.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldMensage implements Serializable {

    private final static long serialVersionUID = 1l;

    private String fieldName;
    private String mensage;

}
