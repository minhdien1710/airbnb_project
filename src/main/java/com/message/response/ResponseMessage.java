package com.message.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ResponseMessage {
    private boolean b;
    private String message;
    private Object o;

    public ResponseMessage(String message){
        this.message = message;
    }


    public ResponseMessage(boolean b, String message, Object o) {
        this.b = b;
        this.message = message;
        this.o = o;
    }
}
