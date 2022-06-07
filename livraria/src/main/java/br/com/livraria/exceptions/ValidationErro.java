package br.com.livraria.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationErro extends StandardError{

    List<FieldMensage> erros = new ArrayList<>();

    public void adicionarErros(String fieldName, String mensage) {
        this.erros.add(new FieldMensage(fieldName,mensage));
    }

    public ValidationErro(Instant timestamp, String status, String error) {
        super(timestamp, status, error);
    }
}
