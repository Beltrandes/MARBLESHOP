package com.beltrandes.MARBLESHOP.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {
    @Getter
    @Setter
    private Long timestamp;
    @Getter
    @Setter
    private Integer status;
    @Getter
    @Setter
    private String error;
    @Getter
    @Setter
    private String message;
    @Getter
    @Setter
    private String path;

}
