package com.portfolio.FullStack.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppResponse {
    private int status;
    private String message;
    private boolean success;
    private Object data;
}
