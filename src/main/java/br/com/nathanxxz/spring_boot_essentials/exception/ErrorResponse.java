package br.com.nathanxxz.spring_boot_essentials.exception;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private  String message;
    private  Integer status;
}
