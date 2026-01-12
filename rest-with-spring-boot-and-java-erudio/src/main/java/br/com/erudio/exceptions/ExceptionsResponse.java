package br.com.erudio.exceptions;

import java.util.Date;

public record ExceptionsResponse(Date timestamp, String message, String details) {}
