package com.company.kafkawithcuba.service;

public interface SerderMessageService {
    String NAME = "kafkawithcuba_SerderMessageService";

    public void sendMessage(String message);
}