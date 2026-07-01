package ru.ivanov.igor.kafkaone.dto;

public record PostedMessageResponse(String msg_id,
                                    long timestamp,
                                    String method,
                                    String uri) {}
