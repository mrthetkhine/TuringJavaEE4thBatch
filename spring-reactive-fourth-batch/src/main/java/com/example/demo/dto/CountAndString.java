package com.example.demo.dto;

import lombok.Data;

@Data
public class CountAndString {
	private final String message;
    private final long count;
    public CountAndString(long c) {
        this.count = c;
        this.message = "# " + this.count;
    }
}
